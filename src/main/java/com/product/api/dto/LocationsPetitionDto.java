package com.product.api.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.product.AbstractLocation;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Dto for input in "/api/getMatrixHomesRated"
 * isResponseOnlyOnList :
 * if true :homaps will get back the best home just with the inputs introduced by User
 * if false : homaps will support with homes from database
 */
public class LocationsPetitionDto {

    private final boolean isResponseOnlyOnList;

    @NotNull
    private final List<AbstractLocation> locations;

    @JsonCreator
    public LocationsPetitionDto(
            @JsonProperty("isResponseOnlyOnList") boolean isResponseOnlyOnList,
            @JsonProperty("locations")List<AbstractLocation> locations) {
        this.isResponseOnlyOnList = isResponseOnlyOnList;
        this.locations = locations;
    }


    public boolean isResponseOnlyList() {
        return isResponseOnlyOnList;
    }

    public List<AbstractLocation> getLocations() {
        return locations;
    }
}