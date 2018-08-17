package com.example.nvmanh.demoretrofit.data.screen.main;

import com.example.nvmanh.demoretrofit.data.model.Hero;
import com.example.nvmanh.demoretrofit.data.source.HerosDataSource;
import com.example.nvmanh.demoretrofit.data.source.HerosRepository;
import com.example.nvmanh.demoretrofit.data.source.remote.HerosRemoteDataSource;

import java.util.List;

public class MainPresenter implements MainContact.Presenter {

    private MainContact.View mView;
    private HerosRepository mRepository;

    public MainPresenter(MainContact.View view) {
        mView = view;
        mRepository = HerosRepository.getInstance(HerosRemoteDataSource.getInstance());
    }

    @Override
    public void getHeros() {
        mRepository.getHeros(new HerosDataSource.OnCompleteListener<List<Hero>>() {

            @Override
            public void onSuccess(List<Hero> heroes) {
                mView.showHeros(heroes);
            }

            @Override
            public void onFailed(Exception e) {
                mView.showErros();
            }
        });
    }

    @Override
    public void searchHeros(String key) {
        mRepository.searchHeros(key, new HerosDataSource.OnCompleteListener<List<Hero>>() {
            @Override
            public void onSuccess(List<Hero> heroes) {
                mView.showHeros(heroes);
            }

            @Override
            public void onFailed(Exception e) {
                mView.showErros();
            }
        });
    }
}
