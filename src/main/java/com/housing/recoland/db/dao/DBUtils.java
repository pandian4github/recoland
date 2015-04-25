package com.housing.recoland.db.dao;

import com.google.common.collect.Lists;
import com.housing.recoland.db.models.*;
import com.housing.recoland.utils.JsonUtils;

import java.sql.*;
import java.util.List;

/**
 * Created by pandian.raju on 25/04/15.
 */
public class DBUtils {

    public static String USERNAME = "username";
    public static String LATITUDE = "latitude";
    public static String LONGITUDE = "longitude";
    public static String SEARCH_LATITUDE = "search_latitude";
    public static String SEARCH_LONGITUDE = "search_longitude";
    public static String ORDERED_AT = "ordered_at";
    public static String CUISINE_TYPE = "cuisine_type";
    public static String BOOKED_AT = "booked_at";
    public static String MOVIE_LANGUAGE = "movie_language";
    public static String RATING = "rating";

    public static List<BrowseHistory> getBrowseHistory(String username) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver") ;
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/recoland", "land", "land") ;
        Statement stmt = conn.createStatement() ;
        String query = "select * from `browse_history` where `username` =  '" + username + "';" ;
        ResultSet rs = stmt.executeQuery(query) ;

        List<BrowseHistory> browseHistories = Lists.newArrayList();
        while (rs.next()) {
            browseHistories.add(new BrowseHistory(rs.getString(USERNAME), rs.getDouble(LATITUDE), rs.getDouble(LONGITUDE),
                    rs.getDouble(SEARCH_LATITUDE), rs.getDouble(SEARCH_LONGITUDE)));
        }
        return browseHistories;
    }

    public static List<FoodHistory> getFoodHistory(String username) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver") ;
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/recoland", "land", "land") ;
        Statement stmt = conn.createStatement() ;
        String query = "select * from `food_history` where `username` =  '" + username + "';" ;
        ResultSet rs = stmt.executeQuery(query) ;

        List<FoodHistory> foodHistories = Lists.newArrayList();
        while (rs.next()) {
            foodHistories.add(new FoodHistory(rs.getString(USERNAME), rs.getDate(ORDERED_AT), rs.getString(CUISINE_TYPE)));
        }
        return foodHistories;

    }

    public static List<MovieHistory> getMovieHistory(String username) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver") ;
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/recoland", "land", "land") ;
        Statement stmt = conn.createStatement() ;
        String query = "select * from `movie_history` where `username` =  '" + username + "';" ;
        ResultSet rs = stmt.executeQuery(query) ;

        List<MovieHistory> movieHistories = Lists.newArrayList();
        while (rs.next()) {
            movieHistories.add(new MovieHistory(rs.getString(USERNAME), rs.getDate(BOOKED_AT),
                    rs.getString(MOVIE_LANGUAGE)));
        }
        return movieHistories;

    }

    public static List<GeoHistory> getGeoHistory(String username) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver") ;
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/recoland", "land", "land") ;
        Statement stmt = conn.createStatement() ;
        String query = "select * from `geo_history` where `username` =  '" + username + "';" ;
        ResultSet rs = stmt.executeQuery(query) ;

        List<GeoHistory> geoHistories = Lists.newArrayList();
        while (rs.next()) {
            geoHistories.add(new GeoHistory(rs.getString(USERNAME), rs.getDouble(LATITUDE), rs.getDouble(LONGITUDE),
                    rs.getString("location"), rs.getString("location_type")));
        }
        return geoHistories;

    }

    public static List<HotelDetails> getHotelDetails() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver") ;
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/recoland", "land", "land") ;
        Statement stmt = conn.createStatement() ;
        String query = "select * from `hotel_details`;" ;
        ResultSet rs = stmt.executeQuery(query) ;

        List<HotelDetails> hotelDetails = Lists.newArrayList();
        while (rs.next()) {
            hotelDetails.add(new HotelDetails(rs.getDouble(LATITUDE), rs.getDouble(LONGITUDE), rs.getString(CUISINE_TYPE),
                    rs.getDouble(RATING)));
        }
        return hotelDetails;
    }

    public static List<TheaterDetails> getTheaterDetails() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver") ;
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/recoland", "land", "land") ;
        Statement stmt = conn.createStatement() ;
        String query = "select * from `theater_details`;" ;
        ResultSet rs = stmt.executeQuery(query) ;

        List<TheaterDetails> theaterDetails = Lists.newArrayList();
        while (rs.next()) {
            theaterDetails.add(new TheaterDetails(rs.getDouble(LATITUDE), rs.getDouble(LONGITUDE), rs.getString(MOVIE_LANGUAGE),
                    rs.getDouble(RATING)));
        }
        return theaterDetails;
    }

    public static List<LandDetails> getLandDetails() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver") ;
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/recoland", "land", "land") ;
        Statement stmt = conn.createStatement() ;
        String query = "select * from `land_details`;" ;
        ResultSet rs = stmt.executeQuery(query) ;

        List<LandDetails> landDetails = Lists.newArrayList();
        while (rs.next()) {
            landDetails.add(new LandDetails(rs.getDouble(LATITUDE), rs.getDouble(LONGITUDE), rs.getString("area_name"),
                    rs.getDouble("area")));
        }
        return landDetails;
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(JsonUtils.DEFAULT.toJson(getBrowseHistory("pandian")));
    }

}
