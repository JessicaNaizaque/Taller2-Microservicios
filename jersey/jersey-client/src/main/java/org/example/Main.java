package org.example;

import org.example.controllers.RestClient;
import org.example.trips.Trip;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Trip> trips = RestClient.getAllTrips();
        System.out.println(trips);
    }
}