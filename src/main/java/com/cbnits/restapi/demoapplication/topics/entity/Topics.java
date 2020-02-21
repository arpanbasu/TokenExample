package com.cbnits.restapi.demoapplication.topics.entity;

import javax.validation.constraints.NotNull;

public class Topics {
    private String id;
    private String name;
    private Integer duration;
    private String description;

    public Topics(String id, String name, Integer duration, String description) {
        this.id = id;
        this.name = name;

        this.duration = duration;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
