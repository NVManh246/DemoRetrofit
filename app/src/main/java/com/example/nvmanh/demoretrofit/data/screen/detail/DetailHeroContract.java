package com.example.nvmanh.demoretrofit.data.screen.detail;

import com.example.nvmanh.demoretrofit.data.model.Hero;

public interface DetailHeroContract {
    interface View {
        void showHero(Hero hero);
        void showErros();
    }

    interface Presenter {
        void getHero(int id);
    }
}
