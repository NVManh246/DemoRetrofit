package com.example.nvmanh.demoretrofit.data.screen.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.nvmanh.demoretrofit.R;
import com.example.nvmanh.demoretrofit.data.model.Hero;

import java.util.List;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {

    private Context mContext;
    private List<Hero> mHeroes;
    private OnClickItemHeroListener mListener;

    public HeroAdapter(Context context, List<Hero> heroes, OnClickItemHeroListener listener) {
        mContext = context;
        mHeroes = heroes;
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =
                (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_hero, parent, false);
        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(mContext, mHeroes);
    }

    @Override
    public int getItemCount() {
        return mHeroes != null ? mHeroes.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mImageHero;
        private TextView mTextName1;
        private TextView mTextName2;
        private TextView mTextHistory;
        private OnClickItemHeroListener mListener;


        public ViewHolder(View itemView, OnClickItemHeroListener listener) {
            super(itemView);
            mListener = listener;
            mImageHero = itemView.findViewById(R.id.image_hero);
            mTextName1 = itemView.findViewById(R.id.text_name1);
            mTextName2 = itemView.findViewById(R.id.text_name2);
            mTextHistory = itemView.findViewById(R.id.text_history);
            mImageHero.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mListener.onClickHero(getAdapterPosition());
        }

        private void bindView(Context context, List<Hero> heroes){
            Hero hero = heroes.get(getAdapterPosition());
            RequestOptions options = new RequestOptions();
            options.placeholder(R.color.colorAccent);
            options.error(R.color.cardview_dark_background);
            Glide.with(context)
                    .load("http://" + hero.getAvatar())
                    .apply(options)
                    .into(mImageHero);
            mTextName1.setText(hero.getName1());
            mTextName2.setText(hero.getName2());
            mTextHistory.setText(hero.getHistory());
        }
    }
}
