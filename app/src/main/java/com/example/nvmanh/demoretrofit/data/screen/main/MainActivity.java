package com.example.nvmanh.demoretrofit.data.screen.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.nvmanh.demoretrofit.R;
import com.example.nvmanh.demoretrofit.data.model.Hero;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContact.View{

    private MainContact.Presenter mPresenter;
    private RecyclerView mRecyclerHero;
    private HeroAdapter mHeroAdapter;
    private List<Hero> mHeroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerHero = findViewById(R.id.recycler_hero);
        setupRecycler();
        mPresenter = new MainPresenter(this);
        mPresenter.getHeros();
    }

    @Override
    public void showHeros(List<Hero> heroes) {
        mHeroes.addAll(heroes);
        mHeroAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErros() {

    }

    private void setupRecycler(){
        mHeroes = new ArrayList<>();
        mHeroAdapter = new HeroAdapter(this, mHeroes);
        mRecyclerHero.setAdapter(mHeroAdapter);
        mRecyclerHero.setLayoutManager(new LinearLayoutManager(this));
    }
}
