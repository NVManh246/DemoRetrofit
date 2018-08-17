package com.example.nvmanh.demoretrofit.data.screen.detail;

import com.example.nvmanh.demoretrofit.data.model.Hero;
import com.example.nvmanh.demoretrofit.data.source.HerosDataSource;
import com.example.nvmanh.demoretrofit.data.source.HerosRepository;
import com.example.nvmanh.demoretrofit.data.source.remote.HerosRemoteDataSource;

public class DetailHeroPresenter implements DetailHeroContract.Presenter {

    private DetailHeroContract.View mView;
    private HerosRepository mRepository;

    public DetailHeroPresenter(DetailHeroContract.View view) {
        mView = view;
        mRepository = HerosRepository.getInstance(HerosRemoteDataSource.getInstance());
    }

    @Override
    public void getHero(int id) {
        mRepository.getHero(id, new HerosDataSource.OnCompleteListener<Hero>() {

            @Override
            public void onSuccess(Hero hero) {
                mView.showHero(hero);
            }

            @Override
            public void onFailed(Exception e) {
                mView.showErros();
            }
        });
    }
}
