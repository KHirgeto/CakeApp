package com.kingstech_app.cakeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class ShopActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private ArrayList<Cake>springCakes;
    private ArrayList<Cake>summerCakes;
    private ArrayList<Cake>fallCakes;
    private ArrayList<Cake>holidayCakes;
    private ShopAdapter mShopAdapter;
    Button spring,summer,fall,holiday,home,setting,homeBTN,shopBTN,settingBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        homeBTN = (Button) findViewById(R.id.shopHomeBTN);
        shopBTN = (Button) findViewById(R.id.shopShopBTN);
        settingBTN = (Button) findViewById(R.id.shopSettingBTN);
        mViewPager = findViewById(R.id.shopViewPager);
        loadCards();

    }

    private void loadCards() {
        springCakes = new ArrayList<Cake>();
        summerCakes = new ArrayList<Cake>();
        fallCakes = new ArrayList<Cake>();
        holidayCakes = new ArrayList<Cake>();

        //What i will do is, creat the list for each array list of cake.
        //Then I will set the current cake based on what the user click on the menu list.
        //I will so use the (position)to open the preview oage with the cake information.
        //for this, I will use a page listener and jsut like we were able to set the background and action bar based on which was clicked.

    }
}