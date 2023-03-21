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

        // delete trip 1000
        /*
        System.out.println("Delete trip 1000:");
        RestClient.deleteTrip(1000L);
        trips = RestClient.getAllTrips();
        System.out.println(trips);
        */

        // print type of trips list
        System.out.println("Type of trips list: " + trips.get(0).getClass());

        // modify trip 1001 origin to "New York", destination to "Los Angeles"
        System.out.println("Modify trip 1001:");
        Trip trip1001 = trips.stream().filter(trip -> trip.getId() == 1001).findFirst().orElse(null);
        if (trip1001 != null) {
            TripWithoutId tripWithoutId = new TripWithoutId(trip1001.getName(), "New York", "Los Angeles", trip1001.getDate());
            Trip updatedTrip = RestClient.updateTrip(1001L, tripWithoutId);
            System.out.println("Updated trip: " + updatedTrip);
            trips = RestClient.getAllTrips();
            System.out.println(trips);
        }

        // create new trip
        System.out.println("Create new trip:");
        TripWithoutId newTrip = new TripWithoutId("New Trip", "Mexico City", "Miami", "2023-01-01");
        Trip createdTrip = RestClient.createTrip(newTrip);
        System.out.println("Created trip: " + createdTrip);
        trips = RestClient.getAllTrips();
        System.out.println(trips);
    }
}
