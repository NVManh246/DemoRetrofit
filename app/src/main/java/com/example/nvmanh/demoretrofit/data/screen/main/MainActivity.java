package com.example.nvmanh.demoretrofit.data.screen.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.example.nvmanh.demoretrofit.R;
import com.example.nvmanh.demoretrofit.data.model.Hero;
import com.example.nvmanh.demoretrofit.data.screen.detail.DetailHeroActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContact.View,
        OnClickItemHeroListener{

    private MainContact.Presenter mPresenter;
    private RecyclerView mRecyclerHero;
    private EditText mEditSearch;
    private HeroAdapter mHeroAdapter;
    private List<Hero> mHeroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerHero = findViewById(R.id.recycler_hero);
        mEditSearch = findViewById(R.id.eidt_hero);

        setupRecycler();
        searchHeros();
        mPresenter = new MainPresenter(this);
        mPresenter.getHeros();
    }

    @Override
    public void showHeros(List<Hero> heroes) {
        mHeroes.clear();
        mHeroes.addAll(heroes);
        mHeroAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErros() {

    }

    @Override
    public void onClickHero(int position) {
        Intent intent = DetailHeroActivity.getDetailHeroIntent(MainActivity.this, position);
        startActivity(intent);
    }

    private void setupRecycler(){
        mHeroes = new ArrayList<>();
        mHeroAdapter = new HeroAdapter(this, mHeroes, this);
        mRecyclerHero.setAdapter(mHeroAdapter);
        mRecyclerHero.setLayoutManager(new LinearLayoutManager(this));
    }

    private void searchHeros(){
        mEditSearch.addTextChangedListener(new OnTextChange() {
            @Override
            public void searchHeros(String key) {
                mPresenter.searchHeros(key);
            }
        });
    }
}
