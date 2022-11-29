package br.com.api.ysw.DTO.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class TagDTO implements Serializable {
    @JsonProperty("name")
    private String name;

    @JsonProperty("lat")
    private double lat;

    @JsonProperty("lon")
    private double lng;

//    @JsonProperty("sensorType")
//    private String sensorType;
    @JsonProperty("numSerial")
    private String numSerial;

    @JsonProperty("description")
    private String description;
}
