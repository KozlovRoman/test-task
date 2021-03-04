package com.ringcentral.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BodyCharacteristics {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("body_length")
    private Integer body_length;

    @JsonProperty("body_width")
    private Integer body_width;

    @JsonProperty("body_height")
    private Integer body_height;

    @JsonProperty("body_style")
    private String body_style;
}
