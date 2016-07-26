package com.product.api.service.helpers;

import com.product.AbstractLocation;
import com.product.Home;
import com.product.Poi;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class LocationInputHelperTest {


    private  List<AbstractLocation> locations;

    @Before
    public void init(){

        AbstractLocation homeBarcelona = new Home("Barcelona, España","122121,1221212",new BigDecimal(400));
        AbstractLocation homeSegovia = new Home("Segovia, España","-122121,1332",new BigDecimal(500));
        AbstractLocation poiGymInMadrid = new Poi("Madrid, España","45545,45564",4,5);

        locations = new ArrayList<>();
        locations.add(homeBarcelona);
        locations.add(homeSegovia);
        locations.add(poiGymInMadrid);
    }


    @Test
    public void filterLocationsByHome() throws Exception {
        List result = LocationInputHelper.filterLocationsByHome(locations);
        Assert.assertEquals(result.size(),2);

    }

    @Test
    @SuppressWarnings("unchecked")
    public void filterLocationsByPoi() throws Exception {
        List<Poi> result = LocationInputHelper.filterLocationsByPoi(locations);
        Assert.assertEquals(result.size(),1);
        Assert.assertEquals(result.get(0).getName(),"Madrid, España");
    }

}