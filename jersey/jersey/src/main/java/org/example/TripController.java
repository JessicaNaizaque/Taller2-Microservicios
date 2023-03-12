package org.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("trips")
public class TripController {
    private final Trip trip = new Trip("1", "Trip1", "Bogotá", "Bali", "2023-07-31");
    @GET
    @Produces("application/json")
    @Path("available1")
    public List<Trip> available() {
        return new ArrayList<Trip>(Arrays.asList(trip));
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("available2")
    public List<Trip> available2() {
        return new ArrayList<Trip>(Arrays.asList(trip));
    }
}
