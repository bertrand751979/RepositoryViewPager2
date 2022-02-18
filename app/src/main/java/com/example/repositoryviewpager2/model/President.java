package com.example.repositoryviewpager2.model;

import java.io.Serializable;

public class President implements Serializable {
    private String presidentName;
    private String presidentCountry;


    public President(String presidentName, String presidentCountry) {
        this.presidentName = presidentName;
        this.presidentCountry = presidentCountry;
    }

    public President(){}

    public String getPresidentName() {
        return presidentName;
    }

    public void setPresidentName(String presidentName) {
        this.presidentName = presidentName;
    }

    public String getPresidentCountry() {
        return presidentCountry;
    }

    public void setPresidentCountry(String presidentCountry) {
        this.presidentCountry = presidentCountry;
    }
}
