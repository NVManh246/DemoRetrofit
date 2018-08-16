package com.example.nvmanh.demoretrofit.data.source;

import com.example.nvmanh.demoretrofit.data.model.Hero;

import java.util.List;

public interface HerosDataSource {

    interface OnCompleteListener {
        void onSuccess(List<Hero> heros);
        void onFailed(Exception e);
    }

    interface HerosRemoteDataSource {
        void getHeros(OnCompleteListener callback);
    }
}
