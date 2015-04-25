package com.housing.recoland.db.models;

import java.util.Date;

/**
 * Created by pandian.raju on 25/04/15.
 */
public class MovieHistory {
    private String username;
    private Date bookedAt;
    private String movieLanguage;

    public MovieHistory() {
    }

    public MovieHistory(String username, Date bookedAt, String movieLanguage) {
        this.username = username;
        this.bookedAt = bookedAt;
        this.movieLanguage = movieLanguage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBookedAt() {
        return bookedAt;
    }

    public void setBookedAt(Date bookedAt) {
        this.bookedAt = bookedAt;
    }

    public String getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(String movieLanguage) {
        this.movieLanguage = movieLanguage;
    }
}
