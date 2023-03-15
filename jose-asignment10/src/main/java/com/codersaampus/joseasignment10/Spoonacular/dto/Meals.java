package com.codersaampus.joseasignment10.Spoonacular.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Meals {

    @JsonProperty("id")
    private Long id;


    @JsonProperty("imageType")
    private String imateType;


    @JsonProperty("title")
    private String title;


    @JsonProperty("readyInMinutes")
    private Integer readyInMinutes;


    @JsonProperty("servings")
    private Integer servings;


    @JsonProperty("sourceUrl")
    private String sourceUrl;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImateType() {
        return imateType;
    }

    public void setImateType(String imateType) {
        this.imateType = imateType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(Integer readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }
}
