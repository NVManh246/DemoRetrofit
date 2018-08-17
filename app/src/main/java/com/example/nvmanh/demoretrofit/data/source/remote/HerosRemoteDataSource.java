package com.example.nvmanh.demoretrofit.data.source.remote;

import android.util.Log;

import com.example.nvmanh.demoretrofit.data.model.Hero;
import com.example.nvmanh.demoretrofit.data.source.api.ApiClient;
import com.example.nvmanh.demoretrofit.data.source.api.ApiInterface;
import com.example.nvmanh.demoretrofit.data.source.HerosDataSource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HerosRemoteDataSource implements HerosDataSource.HerosRemoteDataSource {

    private static HerosRemoteDataSource sInstance;

    private HerosRemoteDataSource(){}

    public static HerosRemoteDataSource getInstance(){
        if(sInstance == null){
            sInstance = new HerosRemoteDataSource();
        }
        return sInstance;
    }

    @Override
    public void getHero(int id, final HerosDataSource.OnCompleteListener callBack) {
        ApiInterface apiService = ApiClient.getInstance().create(ApiInterface.class);
        Call<Hero> call = apiService.getHeroById(id);
        call.enqueue(new Callback<Hero>() {
            @Override
            public void onResponse(Call<Hero> call, Response<Hero> response) {
                callBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Hero> call, Throwable t) {
                callBack.onFailed((Exception) t);
            }
        });
    }

    @Override
    public void getHeros(final HerosDataSource.OnCompleteListener callback) {
        ApiInterface apiService = ApiClient.getInstance().create(ApiInterface.class);
        Call<List<Hero>> call = apiService.getHeros();
        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                callback.onFailed((Exception) t);
            }
        });
    }

    @Override
    public void searchHeros(String key, final HerosDataSource.OnCompleteListener callback) {
        ApiInterface apiService = ApiClient.getInstance().create(ApiInterface.class);
        Call<List<Hero>> call = apiService.searchHeros(key);
        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                List<Hero> heroes = response.body();
                if(heroes != null){
                    callback.onSuccess(heroes);
                } else {
                    callback.onFailed(null);
                }
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                callback.onFailed((Exception) t);
            }
        });
    }
}
