package com.example.nvmanh.demoretrofit.data.source;

import com.example.nvmanh.demoretrofit.data.model.Hero;

import java.util.List;

public interface HerosDataSource {

    interface OnCompleteListener<T> {
        void onSuccess(T t);
        void onFailed(Exception e);
    }

    interface HerosRemoteDataSource {
        void getHero(int id, OnCompleteListener callBack);
        void getHeros(OnCompleteListener callback);
        void searchHeros(String key, OnCompleteListener callback);
    }
}
