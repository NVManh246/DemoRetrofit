package com.example.nvmanh.demoretrofit.data.screen.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.nvmanh.demoretrofit.R;
import com.example.nvmanh.demoretrofit.data.model.Hero;

public class DetailHeroActivity extends AppCompatActivity implements DetailHeroContract.View{
    public static final String ID_HERO = "id";
    private DetailHeroContract.Presenter mPresenter;

    public static Intent getDetailHeroIntent(Context context, int id){
        Intent intent = new Intent(context, DetailHeroActivity.class);
        intent.putExtra(ID_HERO, id);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new DetailHeroPresenter(this);
        int id = getIntent().getIntExtra(ID_HERO, -1);
        mPresenter.getHero(id);
    }

    @Override
    public void showHero(Hero hero) {
        Log.d("kiemtra", hero.getName1() + " - " + hero.getName2());
    }

    @Override
    public void showErros() {
        Toast.makeText(this, R.string.erros, Toast.LENGTH_SHORT).show();
    }
}
