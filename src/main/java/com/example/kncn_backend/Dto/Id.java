package com.example.kncn_backend.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Id {
    @JsonProperty("kind")
    String kind;
    @JsonProperty("videoId")
    String videoId;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}
