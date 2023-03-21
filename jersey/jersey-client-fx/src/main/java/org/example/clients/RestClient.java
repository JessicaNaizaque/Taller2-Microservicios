package org.example.clients;

import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.trips.Trip;
import org.example.trips.TripWithoutId;

import java.util.List;

public class RestClient {
    public static final String SERVER_URI = "http://localhost:8080";
    private static final Client client = ClientBuilder.newClient();
    private static final WebTarget target = client.target(SERVER_URI);

    public static List<Trip> getAllTrips() {
        List<Trip> trips = null;
        Invocation.Builder invocationBuilder = target.path("/trips/json").request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        if (response.getStatus() == 200) {
            // response is a list of trips
            trips = response.readEntity(new GenericType<>() {});
        }
        return trips;
    }

    public static void deleteTrip(Long id) {
        Invocation.Builder invocationBuilder = target.path("/trips/" + id).request(MediaType.APPLICATION_JSON);
        invocationBuilder.delete();
    }

    public static Trip createTrip(TripWithoutId trip) {
        Invocation.Builder invocationBuilder = target.path("/trips").request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(trip, MediaType.APPLICATION_JSON));
        if (response.getStatus() == 200) {
            return response.readEntity(Trip.class);
        } else {
            return null;
        }
    }

    public static Trip updateTrip(Long id, TripWithoutId trip) {
        Invocation.Builder invocationBuilder = target.path("/trips/" + id).request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.put(Entity.entity(trip, MediaType.APPLICATION_JSON));
        if (response.getStatus() == 200) {
            return response.readEntity(Trip.class);
        } else {
            return null;
        }
    }
}
