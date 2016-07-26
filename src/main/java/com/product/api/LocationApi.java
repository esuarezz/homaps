package com.product.api;


import com.google.maps.model.DistanceMatrix;
import com.product.AbstractLocation;
import com.product.api.dto.LocationsPetitionDto;
import com.product.api.dto.ResultMatrixGeneratedDto;
import com.product.api.service.MatrixHomeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import java.util.List;


@RestController
public class LocationApi {

    private final MatrixHomeService matrixHomeService;

    @Inject
    public LocationApi(MatrixHomeService matrixHomeService) {
        this.matrixHomeService = matrixHomeService;
    }

    /**
     * Json created with Poi, and homeList, database will checked depending the parameter
     * Right now just implemented to generate the rate for Homes introduced by User
     * @param locationsPetition
     */
    @Consumes("application/json")
    @RequestMapping(method= RequestMethod.POST,value="/api/getMatrixHomesRated")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<ResultMatrixGeneratedDto> getMatrixHomesRated(@Valid @RequestBody LocationsPetitionDto locationsPetition){


        return matrixHomeService.rateMatrixGenerated(locationsPetition.getLocations());


    }




}
