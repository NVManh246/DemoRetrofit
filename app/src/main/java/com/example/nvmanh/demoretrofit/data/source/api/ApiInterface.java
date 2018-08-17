package com.example.nvmanh.demoretrofit.data.source.api;

import com.example.nvmanh.demoretrofit.data.model.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("gethero.php")
    Call<List<Hero>> getHeros ();

    @POST("get_hero_by_id.php")
    @FormUrlEncoded
    Call<Hero> getHeroById(@Field("id") int id);

    @GET("searchheros.php")
    Call<List<Hero>> searchHeros(@Query("key") String key);
}
