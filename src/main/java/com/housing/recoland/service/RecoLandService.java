package com.housing.recoland.service;

import com.google.common.collect.Sets;
import com.housing.recoland.db.dao.DBUtils;
import com.housing.recoland.db.models.BrowseHistory;
import com.housing.recoland.db.models.LandDetails;
import com.housing.recoland.service.utils.LandDetailsUtils;

import java.sql.SQLException;
import java.util.Set;

/**
 * Created by pandian.raju on 25/04/15.
 */
public class RecoLandService {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String userName = args[0];

        Set<LandDetails> landDetailsList = Sets.newHashSet();
        for (BrowseHistory browseHistory : DBUtils.getBrowseHistory(userName)) {
            landDetailsList.addAll(LandDetailsUtils.getClosestLandDetails(browseHistory.getLatitude(),
                    browseHistory.getLongitude()));
        }

        for (LandDetails landDetails : landDetailsList) {

        }

    }
}
