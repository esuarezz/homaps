package com.product.api.service;


import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;
import com.product.AbstractLocation;
import com.product.Home;
import com.product.Poi;
import com.product.api.dto.ResultMatrixGeneratedDto;
import com.product.api.service.helpers.LocationInputHelper;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class MatrixHomeServiceImpl implements MatrixHomeService {

    private  GeoApiContext geoapi;

    /**
     * Inject the key for googlemaps and generate the GeoApiContext where URL is located and authorized
     * @param key
     */
    @Inject
    public MatrixHomeServiceImpl(
            @Value("${googlemaps.key}") String key) {
        this.geoapi = new GeoApiContext().setApiKey(key);
    }


    /**
     * TODO: develop this algorithm to return a DTO and this will be the response for the FE
     * @param locations
     * @return
     */
    @Override
    public List<ResultMatrixGeneratedDto> rateMatrixGenerated(List<AbstractLocation> locations) {
        final List<DistanceMatrix> matrixLocations = generateMatrixInfoLocations(locations);
        //TODO: calculate with the algorithm
        return new ArrayList<>();
    }

    /**
     *  Make the request to the api, using MatrixAPI, it will generate a request for each Home to every Poi
     * TODO: Improve this algorithm to make for differents Transport
     * @param locations
     * @return
     */
    @Override
    public List<DistanceMatrix> generateMatrixInfoLocations(List<AbstractLocation> locations) {

        DistanceMatrixInputBuilder matrixGenerated = generateMatrixRequest(locations);
        List<DistanceMatrix> distanceMatrixResults = new ArrayList<>();
        String[] origins = matrixGenerated.getOrigins();

        for(String itemOrigin: origins){
            try {
                distanceMatrixResults.add(DistanceMatrixApi.newRequest(geoapi)
                        .origins(itemOrigin)
                        .destinations(matrixGenerated.getDestinations())
                        .departureTime(matrixGenerated.getDepartureTime().plusMinutes(5))
                        .mode(TravelMode.BICYCLING)
                        .await());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return distanceMatrixResults;
    }

    /**
     * Helper to generate the matrix , probably it will be introduced more params in the future
     * @param locations
     * @return
     */
    private DistanceMatrixInputBuilder generateMatrixRequest(List<AbstractLocation> locations) {
        DistanceMatrixInputBuilder distanceMatrixBuilder;
        List<Poi> pois =  LocationInputHelper.filterLocationsByPoi(locations);
        List<Home> homes = LocationInputHelper.filterLocationsByHome(locations);
        //TODO: get this info from Json, and we should call from each one
        TravelMode[] travelModes = {TravelMode.WALKING,TravelMode.BICYCLING,TravelMode.TRANSIT};
        //TODO: ask for the time we want to check
        DateTime dateTime = new DateTime();

        final String[] origins = homes.stream()
                .map(AbstractLocation::getName)
                .toArray(String[]::new);
        final String[] destinations = pois.stream()
                .map(AbstractLocation::getName)
                .toArray(String[]::new);

        return new DistanceMatrixInputBuilder(
                origins,
                destinations,
                travelModes,
                dateTime);

    }


}
