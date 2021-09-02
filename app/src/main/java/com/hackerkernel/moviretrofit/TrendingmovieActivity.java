package com.hackerkernel.moviretrofit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.hackerkernel.moviretrofit.Adapter.TrendingmovieoneAdapter;

public class TrendingmovieActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager pager;
    String persion_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trendingmovie);

        tab=findViewById(R.id.tab);
        pager=findViewById(R.id.pager);

        persion_id=getIntent().getStringExtra("persion_id");

        TrendingmovieoneAdapter trendingmovieoneAdapter=new TrendingmovieoneAdapter(getSupportFragmentManager(),persion_id);

        tab.setupWithViewPager(pager);
        pager.setAdapter(trendingmovieoneAdapter);


    }
}