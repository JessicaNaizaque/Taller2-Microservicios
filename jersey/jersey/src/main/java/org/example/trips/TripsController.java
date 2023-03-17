package org.example.trips;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("/trips")
public class TripsController {
    private final Trip trip = new Trip(1L, "Trip to Paris", "London", "Paris", "2021-01-01");

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Trip> getTripsAsJson() {
        return new ArrayList<>(Arrays.asList(trip));
    }

    @GET
    @Path("/xml")
    @Produces(MediaType.APPLICATION_XML)
    public List<Trip> getTripsAsXml() {
        return new ArrayList<>(Arrays.asList(trip));
    }
}
