package com.example.nvmanh.demoretrofit.data.screen.main;

import com.example.nvmanh.demoretrofit.data.model.Hero;

import java.util.List;

public interface MainContact {
    interface View {
        void showHeros(List<Hero> heroes);
        void showErros();
    }

    interface Presenter {
        void getHeros();
        void searchHeros(String key);
    }
}
