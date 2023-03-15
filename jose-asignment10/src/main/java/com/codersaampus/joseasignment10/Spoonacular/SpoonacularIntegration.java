package com.codersaampus.joseasignment10.Spoonacular;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class SpoonacularIntegration {


    public void callApiSpoonacular(){
        RestTemplate rt = new RestTemplate();
        URI url = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
                .queryParam("function","TIME_SERIES_INTRADAY")
                .build()
                .toUri();



    }
}
