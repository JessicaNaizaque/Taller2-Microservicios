package org.example.trips;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.ws.rs.core.Response;

@Path("/trips")
public class TripsController {

    private final File file = new File("src/resources/trips.json");
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static List<Trip> trips;
    {
        try {
            trips = objectMapper.readValue(file, new TypeReference<List<Trip>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTripsAsJson() {

        return Response
                .status(Response.Status.OK)
                .entity(trips)
                .build();
    }

    @GET
    @Path("/xml")
    @Produces(MediaType.APPLICATION_XML)
    public List<Trip> getTripsAsXml() {
        return trips;
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTrip(@PathParam("id") Long id) throws Exception{
        trips = trips.stream().filter(trip -> !trip.getId().equals(id)).collect(Collectors.toList());
        objectMapper.writeValue(file, trips);

        return Response
                .status(Response.Status.NO_CONTENT)
                .build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateTrip(@PathParam("id") Long id, TripWithoutId updatedTrip) throws Exception{
        Trip tripToUpdate = null;
        for (Trip current: trips) {
            if (current.getId().equals(id)) {
                tripToUpdate = current;
                break;
            }
        }
        if (tripToUpdate != null) {
            tripToUpdate.setName(updatedTrip.getName());
            tripToUpdate.setOrigin(updatedTrip.getOrigin());
            tripToUpdate.setDestination(updatedTrip.getDestination());
            tripToUpdate.setDate(updatedTrip.getDate());
            objectMapper.writeValue(file, trips);

            return Response
                    .status(Response.Status.OK)
                    .entity(tripToUpdate)
                    .build();
        }
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity("The trip with ID " + id + " was not found.")
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTrip(TripWithoutId newTrip) throws Exception {
        // next id is the last id + 1
        Long nextId = trips.get(trips.size() - 1).getId() + 1;
        Trip trip = new Trip(nextId, newTrip.getName(), newTrip.getOrigin(), newTrip.getDestination(), newTrip.getDate());
        trips.add(trip);
        objectMapper.writeValue(file, trips);

        return Response
                .status(Response.Status.OK)
                .entity(trip)
                .build();
    }
}
