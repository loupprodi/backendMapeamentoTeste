package br.com.api.ysw.model.RequestAPI;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {

    @JsonProperty("formatted_address")
    private String address;
    @JsonProperty("geometry")
    private Geometry geometry;

}
