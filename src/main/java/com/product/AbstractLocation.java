package com.product;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.hibernate.validator.constraints.NotEmpty;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Home.class, name = "Home"),

        @JsonSubTypes.Type(value = Poi.class, name = "Poi") }
)

/**
 * Class used to map the information from JSON in the Api call "/api/getMatrixHomesRated"
 * Deserialization by polymorphism
 */
public abstract class AbstractLocation {

    @NotNull
    @NotEmpty
    private final  String name;

    @NotNull
    @NotEmpty
    private final  String coordinate;

    @Inject
    public AbstractLocation(
            String name,
            String coordinate) {
        this.name = name;
        this.coordinate = coordinate;
    }

    public String getName() {
        return name;
    }
    public String getCoordenade() {
        return coordinate;
    }


}