package com.example.nvmanh.demoretrofit.data.source.api;

import com.example.nvmanh.demoretrofit.data.model.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("gethero.php")
    Call<List<Hero>> getHeros ();
}
