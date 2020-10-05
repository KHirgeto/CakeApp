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

    private ArrayList<Cake>mPopularCakes;
    private PopularCakeAdapter mPopularCakeAdapter;
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
                    barLayout.setBackgroundResource(R.drawable.barcurve);
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
        mPopularCakes = new ArrayList<Cake>();
        mPopularCakes.add(new Cake("Double Chocolate Cake","A triple layer chocolate dream, filled with a dense chocolate filling and covered with a rich, chocolate buttercream.",30,R.drawable.chocletcake,1,R.drawable.dctp,4));
        mPopularCakes.add(new Cake("UpsideDown Pineapple Cake","A basic single layer yellow butter cake inverted after baking to reveal a flavor infused glistening mosaic of caramelized canned pineapples.",25,R.drawable.upsidedowncake,2,R.drawable.upsidedown_t,4));
        mPopularCakes.add(new Cake("Key Lime Pie","Cool zesty cream with sweet graham-cracker crust makes this semi-tart pie a winner. 9&quot Round - 16 Servings",20,R.drawable.keylimepie,1,R.drawable.keylimecake,4));
        mPopularCakes.add(new Cake("Carrot Cake","Our decadent carrot cake is studded with raisins, freshly grated carrots, pineapple and coconut with a luscious smooth cream cheese filling filling and finish.",30,R.drawable.carootcakecur,2,R.drawable.carrocake,4));
        mPopularCakes.add(new Cake("Banana Cake","Don't let this bread's simple flavor fool you. Our Banana bread's moist texture will have your mouth watering.",15,R.drawable.bananacake,1,R.drawable.bntbone,4));
     //  mPopularCakes.add(new Cake("Red Velvet Cheesecake","A luscious three layered cake, a silky smooth layer of cheesecake nestled between two layers of delectable Red Velvet Cake. Icing and toppings optional.",40,R.drawable.redvelvetcheescake,2,R.drawable.rvctp));

        //setup adapter
        mPopularCakeAdapter = new PopularCakeAdapter(this,mPopularCakes);
        //set adapter to view pager
        mViewPager.setAdapter(mPopularCakeAdapter);
        //set default padding from left to right
        mViewPager.setPadding(160,0,160,0);
    }
}