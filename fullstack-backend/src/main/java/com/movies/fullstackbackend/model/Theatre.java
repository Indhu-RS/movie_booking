package com.movies.fullstackbackend.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Theatre {

    @Id
    @GeneratedValue
    private Long theatreid;
    private String name;
    private String location;

    public Long getTheatreid() {
        return theatreid;
    }

    public void setTheatreid(Long theatreid) {
        this.theatreid = theatreid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    }

