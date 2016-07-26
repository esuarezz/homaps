package com.product.api.service.helpers;


import com.product.AbstractLocation;
import com.product.Home;
import com.product.Poi;

import java.util.List;
import java.util.stream.Collectors;

public class LocationInputHelper {

    //I could create something like this, then introduce a new param in the method and do it generic
    //But I think right now has more sense in this way

    /*public final static Predicate isHome() {
        return p -> p instanceof Home;
    }*/


    /**
     * Filtering the type of instance
     * @param locations
     * @return
     */
    public static List filterLocationsByHome(List<AbstractLocation> locations) {
        return locations
                .stream()
                .filter(p -> p instanceof Home)
                .collect(Collectors.toList());
    }

    public static List filterLocationsByPoi(List<AbstractLocation> locations) {
        return locations
                .stream()
                .filter(p -> p instanceof Poi)
                .collect(Collectors.toList());
    }
}
