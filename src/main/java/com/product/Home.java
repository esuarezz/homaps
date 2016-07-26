package com.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/**
 * Places where user could live
 */
public class Home extends AbstractLocation{

    private BigDecimal price;


    @JsonCreator
    public Home(@JsonProperty("name")String name,
                @JsonProperty("coordinate") String coordinate,
                @JsonProperty("price") BigDecimal price) {
        super(name, coordinate);
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

}
