package com.housing.recoland.service.utils;

import com.housing.recoland.db.dao.DBUtils;
import com.housing.recoland.db.models.LandDetails;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by pandian.raju on 25/04/15.
 */
public class LandDetailsUtils {
    public static List<LandDetails> getClosestLandDetails(Double latitude, Double longitude) throws SQLException, ClassNotFoundException {
        List<LandDetails> allLandDetails = DBUtils.getLandDetails();
        for (LandDetails landDetails : allLandDetails) {
            landDetails.setDistance(DistanceCalculator.getDistance(landDetails.getLatitude(),
                    landDetails.getLongitude(), latitude, longitude));
        }
        Collections.sort(allLandDetails, new Comparator<LandDetails>() {
            @Override
            public int compare(LandDetails o1, LandDetails o2) {
                return  ((o1.getDistance() < o2.getDistance()) ? 1 : 0);
            }
        });
        return allLandDetails;
    }
}
