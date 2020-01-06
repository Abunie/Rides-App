package com.example.gaiya_ridebook;

/* This class contains all the attributes for each Ride each ride has a ride Id */

public class Rides {
    //fields
//    private int rideID;
    private double rideDistance;
    private double averageSpeed;
    private String averageCadence;
    private String comment;
    private String date;
    private String time;

    public Rides( double rideDistance, double averageSpeed, String averageCadence, String comment, String date, String time) {
//        this.rideID = rideID;
        this.rideDistance = rideDistance;
        this.averageSpeed = averageSpeed;
        this.averageCadence = averageCadence;
        this.comment = comment;
        this.date = date;
        this.time = time;
    }

//    public int getRideID() {
//        return rideID;
//    }
//
//    public void setRideID(int rideID) {
//        this.rideID = rideID;
//    }

    public double getRideDistance() {
        return rideDistance;
    }

    public void setRideDistance(double rideDistance) {
        this.rideDistance = rideDistance;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public String getAverageCadence() {
        return averageCadence;
    }

    public void setAverageCadence(String averageCadence) {
        this.averageCadence = averageCadence;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
