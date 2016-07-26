package com.product.api.service;
import com.google.maps.model.TravelMode;
import org.joda.time.DateTime;


public class DistanceMatrixInputBuilder {

    private final String[] origins;
    private final String[] destinations;

    private final TravelMode[] travelModes;
    private final DateTime departureTime;

    /**
     * This is based on googlemapsMatrixApi to do the request, homaps will be improved in this way
     * @param origins
     * @param destinations
     * @param travelModes
     * @param departureTime
     */
    public DistanceMatrixInputBuilder(
            String[] origins,
            String[] destinations,
            TravelMode[] travelModes,
            DateTime departureTime) {
        this.origins = origins;
        this.destinations = destinations;
        this.travelModes = travelModes;
        this.departureTime = departureTime;
    }

    public String[] getOrigins() {
        return origins;
    }

    public String[] getDestinations() {
        return destinations;
    }

    public TravelMode[] getTravelModes() {
        return travelModes;
    }

    public DateTime getDepartureTime() {
        return departureTime;
    }
}