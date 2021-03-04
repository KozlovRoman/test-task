package com.ringcentral.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EngineCharacteristics {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("fuel_type")
    private String fuel_type;

    @JsonProperty("engine_cylinders")
    private String engine_cylinders;

    @JsonProperty("engine_displacement")
    private Integer engine_displacement;

    @JsonProperty("engine_horsepower")
    private Integer engine_horsepower;
}
