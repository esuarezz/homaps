package com.product.api.service;


import com.google.maps.model.DistanceMatrix;
import com.product.AbstractLocation;
import com.product.api.dto.ResultMatrixGeneratedDto;

import java.util.List;

public interface MatrixHomeService {

    /**
     * Rate the matrix generated with the response from googlemaps based on Time, transport..
     *
     * TODO: Algorithm has to be designed
     * @param distanceMatrixGenerated
     * @return
     */
    List<ResultMatrixGeneratedDto> rateMatrixGenerated(List<AbstractLocation> distanceMatrixGenerated);

    /**
     * Make the request to the api, using MatrixAPI, it will generate a request for each Home to every Poi
     * TODO: Improve this algorithm to make for differents Transport
     * @param locations
     * @return
     */
    List<DistanceMatrix> generateMatrixInfoLocations(List<AbstractLocation> locations);

}
