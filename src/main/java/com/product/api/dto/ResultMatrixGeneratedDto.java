package com.product.api.dto;


import java.math.BigDecimal;
import java.util.Map;

/**
 *
 */
public class ResultMatrixGeneratedDto {

    private final String homeName;
    private final Map<String,Long> durationToPoi;
    private final BigDecimal rated;

    /**
     *
     * @param homeName
     * @param durationToPoi ,  time between home and poi - String: poiName,Long: time
     * @param rated
     */
    public ResultMatrixGeneratedDto(
            String homeName,
            Map<String, Long> durationToPoi,
            BigDecimal rated) {
        this.homeName = homeName;
        this.durationToPoi = durationToPoi;
        this.rated = rated;
    }

    public String getHomeName() {
        return homeName;
    }

    public Map<String, Long> getDurationToPoi() {
        return durationToPoi;
    }

    public BigDecimal getRated() {
        return rated;
    }
}