package br.com.api.ysw.DTO.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class TagDTO implements Serializable {
    @JsonProperty("numSerial")
    private String numSerial;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
}
