package com.example.kncn_backend.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class snippet {
    @JsonProperty("title")
    String title;
    @JsonProperty("description")
    String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
