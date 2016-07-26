package com.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.inject.Inject;

/**
 * Point of interest, places that user will visit
 */
public class Poi extends AbstractLocation{

    private final int frequency;
    private final int relevance;

    @JsonCreator
    public Poi(@JsonProperty("name")String name,
               @JsonProperty("coordinate") String coordinate,
               @JsonProperty("frequency") int frequency,
               @JsonProperty("relevance") int relevance) {
        super(name, coordinate);
        this.frequency = frequency;
        this.relevance = relevance;
    }

    public int getFrecuency() {
        return frequency;
    }

    public int getRelevance() {
        return relevance;
    }
}