package org.example;

import org.example.controllers.RestClient;
import org.example.trips.Trip;
import org.example.trips.TripWithoutId;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // get all trips
        System.out.println("All trips:");
        List<Trip> trips = RestClient.getAllTrips();
        System.out.println(trips);

        // delete one trip
        Trip trip = trips.get(trips.size() - 1);
        System.out.println("Delete trip " + trip.getId() + ":");
        RestClient.deleteTrip(trip.getId());
        trips = RestClient.getAllTrips();
        System.out.println(trips);

        // modify one trip's origin to "New York", destination to "Los Angeles"
        trip = trips.get(0);
        System.out.println("Modify trip " + trip.getId() + ":");
        TripWithoutId tripWithoutId = new TripWithoutId(trip.getName(), "New York", "Los Angeles", trip.getDate());
        Trip updatedTrip = RestClient.updateTrip(trip.getId(), tripWithoutId);
        System.out.println("Updated trip: " + updatedTrip);
        trips = RestClient.getAllTrips();
        System.out.println(trips);

        // create new trip
        System.out.println("Create new trip:");
        TripWithoutId newTrip = new TripWithoutId("New Trip", "Mexico City", "Miami", "2023-01-01");
        Trip createdTrip = RestClient.createTrip(newTrip);
        System.out.println("Created trip: " + createdTrip);
        trips = RestClient.getAllTrips();
        System.out.println(trips);
    }
}
