package com.product.api.service;

import com.google.maps.GeoApiContext;
import com.google.maps.model.Distance;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixRow;
import com.product.AbstractLocation;
import com.product.HomapsApplication;
import com.product.Home;
import com.product.Poi;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=HomapsApplication.class)
@WebIntegrationTest({"server.port=0", "management.port=0"})
@PropertySource("classpath:application.properties")
@EnableAutoConfiguration
public class MatrixHomeServiceImplTest {

    private GeoApiContext geoapi;

    @Inject
    private MatrixHomeService matrixHomeService;


    @Value("${googlemaps.key}") String key;


    @Before
    public void  init(){
        this.geoapi = new GeoApiContext().setApiKey(key);
    }

    @Test
    public void generateMatrixInfoLocationsIntegration() throws Exception {
        AbstractLocation homeBarcelona = new Home("Barcelona, España","122121,1221212",new BigDecimal(400));
        AbstractLocation homeSegovia = new Home("Segovia, España","-122121,1332",new BigDecimal(500));
        AbstractLocation poiGymInMadrid = new Poi("Madrid, España","45545,45564",4,5);

        List<AbstractLocation> locations = new ArrayList<>();
        locations.add(homeBarcelona);
        locations.add(homeSegovia);
        locations.add(poiGymInMadrid);

        List<DistanceMatrix> response = matrixHomeService.generateMatrixInfoLocations(locations);
        Assert.assertNotNull(response);
        Assert.assertEquals(response.size(),2);
        String[] destinationAddresses = response.get(0).destinationAddresses;
        Assert.assertEquals(destinationAddresses.length,1);
        DistanceMatrixRow[] rows = response.get(0).rows;
        Assert.assertNotNull(rows);
        Assert.assertEquals(rows[0].elements[0].distance.humanReadable,"636 km");

    }


}