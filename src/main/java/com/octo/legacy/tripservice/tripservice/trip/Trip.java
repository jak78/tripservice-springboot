package com.octo.legacy.tripservice.tripservice.trip;

import java.util.Objects;

public class Trip {
    private String id;
    private String destination;

    public Trip(String id, String destination) {
        this.id = id;
        this.destination = destination;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return Objects.equals(id, trip.id) &&
                Objects.equals(destination, trip.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, destination);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Trip{");
        sb.append("id='").append(id).append('\'');
        sb.append(", destination='").append(destination).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
