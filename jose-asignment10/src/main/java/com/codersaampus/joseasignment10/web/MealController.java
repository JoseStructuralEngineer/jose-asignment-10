package com.codersaampus.joseasignment10.web;

import com.codersaampus.joseasignment10.Spoonacular.dto.DayResponse;
import com.codersaampus.joseasignment10.Spoonacular.dto.WeekResponse;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.Properties;

@RestController
public class MealController {

    private String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private String appConfigPath = rootPath + "application.properties";

    @GetMapping("mealplanner/week")
    public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions){
        Properties appProps = readProperties();
        RestTemplate rt = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(appProps.getProperty("spoonacular.urls.base") + appProps.getProperty("spoonacular.urls.mealplan"))
                .queryParam("timeFrame","week")
                .queryParam("apiKey","a9c35b91e3b44202b661bad9b7ff6445");
        if (!StringUtils.isEmpty(numCalories)) {
            builder = builder.queryParam("targetCalories", Integer.parseInt(numCalories));
        }
        if (!StringUtils.isEmpty(diet)) {
            builder = builder.queryParam("diet", diet);
        }
        if (!StringUtils.isEmpty(exclusions)) {
            builder = builder.queryParam("exclude", exclusions);
        }

        URI url = builder.build().toUri();


        ResponseEntity<WeekResponse> response = rt.getForEntity(url, WeekResponse.class);
        System.out.println(response);
        return response;
    }


    @GetMapping("mealplanner/day")

    public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions){
        Properties appProps = readProperties();
        RestTemplate rt = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(appProps.getProperty("spoonacular.urls.base") + appProps.getProperty("spoonacular.urls.mealplan"))
                .queryParam("timeFrame","day")
                .queryParam("apiKey","a9c35b91e3b44202b661bad9b7ff6445");
        if (!StringUtils.isEmpty(numCalories)) {
            builder = builder.queryParam("targetCalories", Integer.parseInt(numCalories));
        }
        if (!StringUtils.isEmpty(diet)) {
            builder = builder.queryParam("diet", diet);
        }
        if (!StringUtils.isEmpty(exclusions)) {
            builder = builder.queryParam("exclude", exclusions);
        }

        URI url = builder.build().toUri();
        ResponseEntity<DayResponse> response = rt.getForEntity(url, DayResponse.class);
        System.out.println(response);
        return response;
    }

    private Properties readProperties(){
        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return appProps;

    }

}
