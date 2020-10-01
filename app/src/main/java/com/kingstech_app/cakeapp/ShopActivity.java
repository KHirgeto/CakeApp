package com.kingstech_app.cakeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        homeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShopActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        settingBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShopActivity.this,SettingActivity.class);
                startActivity(intent);
            }
        });

    }

    private void loadCards() {
        springCakes = new ArrayList<Cake>();
        summerCakes = new ArrayList<Cake>();
        fallCakes = new ArrayList<Cake>();
        holidayCakes = new ArrayList<Cake>();

        springCakes.add(new Cake("UpsideDown Pineapple Cake","",25,R.drawable.upsidedowncake,2));
        springCakes.add(new Cake("Key Lime Pie","",20,R.drawable.keylimepie,1));
        springCakes.add(new Cake("Coconut Cake","",30,R.drawable.cocunutcake,2));
        springCakes.add(new Cake("Strawberry Shortcake","",35,R.drawable.sshortcaketwo,1));
        springCakes.add(new Cake("5 Flavor Pound Cake","",25,R.drawable.poundcake,2));



        fallCakes.add(new Cake("Carrot Cake","",30,R.drawable.carootcakecur,2));
        fallCakes.add(new Cake("Double Chocolate Cake","",30,R.drawable.chocletcake,1));
        fallCakes.add(new Cake("New York Cheesecake","",30,R.drawable.nycakeone,2));
        fallCakes.add(new Cake("Red Velvet Cake","",30,R.drawable.redvalvetcake,1));
        fallCakes.add(new Cake("Sweet Potato Cheesecake","",40,R.drawable.sweetpotatocake,2));
        fallCakes.add(new Cake("Banana Cake","",15,R.drawable.bananacake,1));
        fallCakes.add(new Cake("Red Velvet Cheesecake","",40,R.drawable.redvelvetcheescake,2));
        fallCakes.add(new Cake("Bacardi Rum Cake","",30,R.drawable.bascardirumcake,1));

        mShopAdapter = new ShopAdapter(this,springCakes);
        mViewPager.setAdapter(mShopAdapter);
        mViewPager.setPadding(160,0,160,0);
        //What i will do is, creat the list for each array list of cake.
        //Then I will set the current cake based on what the user click on the menu list.
        //I will so use the (position)to open the preview oage with the cake information.
        //for this, I will use a page listener and jsut like we were able to set the background and action bar based on which was clicked.

    }
}