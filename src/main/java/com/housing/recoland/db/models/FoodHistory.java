package com.housing.recoland.db.models;

import java.util.Date;

/**
 * Created by pandian.raju on 25/04/15.
 */
public class FoodHistory {
    private String username;
    private Date orderedAt;
    private String cuisineType;

    public FoodHistory() {
    }

    public FoodHistory(String username, Date orderedAt, String cuisineType) {
        this.username = username;
        this.orderedAt = orderedAt;
        this.cuisineType = cuisineType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(Date orderedAt) {
        this.orderedAt = orderedAt;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }
}
