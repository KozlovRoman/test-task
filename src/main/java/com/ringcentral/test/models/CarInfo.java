package com.ringcentral.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarInfo {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("segment")
    private String segment;

    @JsonProperty("brand_id")
    private Integer brand_id;

    @JsonProperty("model")
    private String model;

    @JsonProperty("generation")
    private String generation;

    @JsonProperty("modification")
    private String modification;
}