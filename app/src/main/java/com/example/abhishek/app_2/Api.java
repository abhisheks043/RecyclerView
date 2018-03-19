package com.example.abhishek.app_2;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Abhishek on 3/18/2018.
 */

public interface Api {

    String BASE_URL = "http://www.androidbegin.com";

    @GET("tutorial/jsonparsetutorial.txt")
    Call<JSONResponse> getJSON();

}
