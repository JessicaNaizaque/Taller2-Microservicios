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
    private static ObjectMapper objectMapper = new ObjectMapper();
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
    public List<Trip> getTripsAsJson() {
        return trips;
    }

    @GET
    @Path("/xml")
    @Produces(MediaType.APPLICATION_XML)
    public List<Trip> getTripsAsXml() {
        return trips;
    }

    @DELETE
    @Path("/delete")
    public Response deleteTrip(@QueryParam("id") Long id) throws Exception{
        trips = trips.stream().filter(trip -> !trip.getId().equals(id)).collect(Collectors.toList());
        objectMapper.writeValue(file, trips);
        return Response
                .status(Response.Status.OK)
                .entity("The trip with ID " + id + " was deleted successfully.")
                .build();
    }

    @PUT
    @Path("/update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Trip updateName(@PathParam("id") Long id, @QueryParam("name") String name) throws Exception{
        Trip modifiedTrip = new Trip();
        for (int i = 0; i < trips.size(); i++){
            if(trips.get(i).getId().equals(id)){
                trips.get(i).setName(name);
                modifiedTrip = trips.get(i);
            }
        }
        objectMapper.writeValue(file, trips);
        return modifiedTrip;
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addTrip(Trip trip)throws Exception{
        boolean exist = false;
        for (Trip current: trips){
            if (trip.getId().equals(current.getId())){
                exist = true;
            }
        }
        if (!exist){
            trips.add(trip);
            objectMapper.writeValue(file, trips);
        }
    }
}
