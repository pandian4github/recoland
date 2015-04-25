package com.housing.recoland.db.models;

/**
 * Created by pandian.raju on 25/04/15.
 */
public class UserAuxDetails {
    private String username;
    private Double currentLatitude;
    private Double currentLongitude;
    private String maritalStatus;

    public UserAuxDetails() {
    }

    public UserAuxDetails(String username, Double currentLatitude, Double currentLongitude, String maritalStatus) {
        this.username = username;
        this.currentLatitude = currentLatitude;
        this.currentLongitude = currentLongitude;
        this.maritalStatus = maritalStatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getCurrentLatitude() {
        return currentLatitude;
    }

    public void setCurrentLatitude(Double currentLatitude) {
        this.currentLatitude = currentLatitude;
    }

    public Double getCurrentLongitude() {
        return currentLongitude;
    }

    public void setCurrentLongitude(Double currentLongitude) {
        this.currentLongitude = currentLongitude;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
}
