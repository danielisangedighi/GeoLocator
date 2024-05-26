package com.example.Advisor.model;

public class Location {
    private double latitude;
    private double longitude;

    public Location() {
    }

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setCoordinatesFromString(String coordinates) {
        if (coordinates != null && !coordinates.isEmpty()) {
            String[] parts = coordinates.split(",");
            if (parts.length == 2) {
                this.latitude = Double.parseDouble(parts[0]);
                this.longitude = Double.parseDouble(parts[1]);
            } else {
                throw new IllegalArgumentException("Invalid coordinates format. Expected format: 'latitude,longitude'");
            }
        } else {
            throw new IllegalArgumentException("Coordinates string cannot be null or empty");
        }
    }

    @Override
    public String toString() {
        return latitude + "," + longitude;
    }

    public Object getCoordinatesAsString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCoordinatesAsString'");
    }
}
