package com.ringcentral.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarFullInfo {
    @JsonProperty("id")
    private Long id;

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

    @JsonProperty("year_range")
    private String year_range;

    @JsonProperty("fuel_type")
    private String fuel_type;

    @JsonProperty("engine_cylinders")
    private String engine_cylinders;

    @JsonProperty("engine_displacement")
    private Integer engine_displacement;

    @JsonProperty("engine_horsepower")
    private Integer engine_horsepower;

    @JsonProperty("gearbox")
    private String gearbox;

    @JsonProperty("wheel_drive")
    private String wheel_drive;

    @JsonProperty("body_length")
    private Integer body_length;

    @JsonProperty("body_width")
    private Integer body_width;

    @JsonProperty("body_height")
    private Integer body_height;

    @JsonProperty("body_style")
    private String body_style;

    @JsonProperty("acceleration")
    private Double acceleration;

    @JsonProperty("max_speed")
    private Integer max_speed;

    @JsonProperty("title")
    private String title;
}
