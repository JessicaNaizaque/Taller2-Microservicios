package org.example.trips;

public class TripWithoutId {
    private String name;
    private String origin;
    private String destination;
    private String date;

    public TripWithoutId() {
    }

    public TripWithoutId(String name, String origin, String destination, String date) {
        this.name = name;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
