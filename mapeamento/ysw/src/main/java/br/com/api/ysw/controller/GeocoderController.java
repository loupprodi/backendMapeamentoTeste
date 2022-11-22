package br.com.api.ysw.controller;

import br.com.api.ysw.model.RequestAPI.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GeocoderController {


    private static final Object API_KEY = "AIzaSyD1_SpKtnSBgB7BaTAcWeS4lBYDj5-AqLw";

/* exemplo a ser passado na rota
* http://localhost:8080/getLocation/lat=-23.533773&lng=-46.625290
* */

    @GetMapping("/getLocation/lat={lat}&lng={lng}")
    public Response getGeoDetails(@PathVariable("lat") double lat, @PathVariable("lng") double lng) {
        ResponseEntity<Response> responseApi = new RestTemplate()
                .getForEntity("https://maps.googleapis.com/maps/api/geocode/json?latlng="+lat+","+lng+"&key="+API_KEY
                        , Response.class);
        return responseApi.getBody();
    }
}
