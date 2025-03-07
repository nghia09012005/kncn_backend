package com.example.kncn_backend.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    @JsonProperty("id")
    public Id id;
    @JsonProperty("snippet")
    public snippet snippet;

    public snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(snippet snippet) {
        this.snippet = snippet;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }
}
