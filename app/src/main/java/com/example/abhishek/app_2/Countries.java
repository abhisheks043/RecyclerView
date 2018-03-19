package com.example.abhishek.app_2;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Abhishek on 3/18/2018.
 */
public class Countries {

    private int rank;
    private String country;
    private String population;
    private String flag;

    public Countries(int rank, String country, String population, String flag) {
        this.rank = rank;
        this.country = country;
        this.population = population;
        this.flag = flag;
    }

    public int getRank() {
        return rank;
    }

    public String getCountry() {
        return country;
    }

    public String getPopulation() {
        return population;
    }

    public String getFlag() {
        return flag;
    }

}
