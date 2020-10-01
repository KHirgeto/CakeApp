package com.kingstech_app.cakeapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    //actionbar
    private ActionBar mActionBar;
    private ViewPager mViewPager;
    ConstraintLayout mConstraintLayout;
    Button homeBTN, shopBTN,settingBTN;
    LinearLayout barLayout;

    private ArrayList<PopularCake>mPopularCakes;
    private MyAdapter mMyAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mConstraintLayout = (ConstraintLayout) findViewById(R.id.mainLayout);
        homeBTN = (Button) findViewById(R.id.homeHomeBTN);
        shopBTN = (Button) findViewById(R.id.homeShopBTN);
        settingBTN = (Button) findViewById(R.id.homeSettingBTN);
        barLayout = (LinearLayout) findViewById(R.id.homeBarLayout);
        //init actionbar
        mActionBar = getSupportActionBar();

        //init UI views
        settingBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // The shope Icon gets bigger when home buttion is clicked, so it has to fixed
                settingBTN.setWidth(47);
                settingBTN.setHeight(46);
                homeBTN.setWidth(28);
                homeBTN.setWidth(27);
                homeBTN.setBackgroundResource(R.drawable.whitehome);
                settingBTN.setBackgroundResource(R.drawable.whitebgsetting);
                Intent intent = new Intent(HomeActivity.this,SettingActivity.class);
                startActivity(intent);
            }
        });
        shopBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,ShopActivity.class);
                startActivity(intent);
            }
        });
        settingBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,SettingActivity.class);
                startActivity(intent);
            }
        });
        mViewPager = findViewById(R.id.viewPager);
        loadCards();



        //set mViewPager change listener
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //just change the title of actionbar
//                String tile = mPopularCakes.get(position).getName();
                if(mPopularCakes.get(position).getCakeNum() == 1)
                {
                    mConstraintLayout.setBackgroundResource(R.color.one);
                }

                else if(mPopularCakes.get(position).getCakeNum()==2)
                {
                    mConstraintLayout.setBackgroundResource(R.color.two);
                    barLayout.setBackgroundResource(R.drawable.barcurve);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void loadCards() {
        //init list
        mPopularCakes = new ArrayList<PopularCake>();
        mPopularCakes.add(new PopularCake(  "Red Velvet Cake",
                R.drawable.curvecake,
                1));
        mPopularCakes.add(new PopularCake(  "Carrot Cake",
                R.drawable.carrocake,
                2));
        mPopularCakes.add(new PopularCake(  "Strawberry Shortcake",
                R.drawable.strawberrycake,
                1));
        mPopularCakes.add(new PopularCake(  "NewYork Style CheeseCake",
                R.drawable.nycake,
                2));

        //setup adapter
        mMyAdapter = new MyAdapter(this,mPopularCakes);
        //set adapter to view pager
        mViewPager.setAdapter(mMyAdapter);
        //set default padding from left to right
        mViewPager.setPadding(160,0,160,0);
    }
}