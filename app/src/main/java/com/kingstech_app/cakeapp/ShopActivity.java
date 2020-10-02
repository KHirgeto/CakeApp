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
    Button springBTN,summerBTN,fallBTN,holidayBTN,homeBTN,settingBTN,shopBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        homeBTN = (Button) findViewById(R.id.shopHomeBTN);
        shopBTN = (Button) findViewById(R.id.shopShopBTN);
        settingBTN = (Button) findViewById(R.id.shopSettingBTN);
        mViewPager = findViewById(R.id.shopViewPager);
        fallBTN = (Button) findViewById(R.id.fallBTN);
        springBTN = (Button) findViewById(R.id.springBTN);
        summerBTN = (Button) findViewById(R.id.summerBTN);
        holidayBTN = (Button) findViewById(R.id.holidayBTN);

        loadSpring();
        springBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                springBTN.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                fallBTN.setTextColor(getResources().getColor(R.color.white));
                summerBTN.setTextColor(getResources().getColor(R.color.white));
                loadSpring();
            }
        });
        fallBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                springBTN.setTextColor(getResources().getColor(R.color.white));
                fallBTN.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                summerBTN.setTextColor(getResources().getColor(R.color.white));
                loadFall();
            }
        });
        summerBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                springBTN.setTextColor(getResources().getColor(R.color.white));
                summerBTN.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                fallBTN.setTextColor(getResources().getColor(R.color.white));
                loadSummer();
            }
        });
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

    private void loadSpring() {
        springCakes = new ArrayList<Cake>();

        springCakes.add(new Cake("UpsideDown Pineapple Cake","A basic single layer yellow butter cake inverted after baking to reveal a flavor infused glistening mosaic of caramelized canned pineapples.",25,R.drawable.upsidedowncake,2,R.drawable.upsidedown_t));
        springCakes.add(new Cake("Key Lime Pie","Cool zesty cream with sweet graham-cracker crust makes this semi-tart pie a winner. 9&quot Round - 16 Servings",20,R.drawable.keylimepie,1,R.drawable.keylimecake));
        springCakes.add(new Cake("Coconut Cake","Two layers of moist coconut flavored yellow cake filled with a sweetened coconut filling while covered with buttercream frosting and finely shredded coconut",30,R.drawable.cocunutcake,2,R.drawable.cctp));
        springCakes.add(new Cake("Strawberry Shortcake","An old-fashioned, two layers of tender shortcake, brusting with strawberries and topped with whipped cream",35,R.drawable.sshortcaketwo,1,R.drawable.sstp));
        springCakes.add(new Cake("5 Flavor Pound Cake","A simple yet rich, finely textured yellow cake with 5 distinct flavor cluminating in a one of a kind taste experience, topped with a butter glaze. (Flavor ingredients includes butter, vanilla, rum, almond, and coconut)",25,R.drawable.poundcake,2,R.drawable.fvtp));

        mShopAdapter = new ShopAdapter(this,springCakes);
        mViewPager.setAdapter(mShopAdapter);
        mViewPager.setPadding(160,0,160,0);
        //What i will do is, creat the list for each array list of cake.
        //Then I will set the current cake based on what the user click on the menu list.
        //I will so use the (position)to open the preview oage with the cake information.
        //for this, I will use a page listener and jsut like we were able to set the background and action bar based on which was clicked.

    }
    private void loadFall() {
        fallCakes = new ArrayList<Cake>();


        fallCakes.add(new Cake("Carrot Cake","Our decadent carrot cake is studded with raisins, freshly grated carrots, pineapple and coconut with a luscious smooth cream cheese filling filling and finish.",30,R.drawable.carootcakecur,2,R.drawable.carrocake));
        fallCakes.add(new Cake("Double Chocolate Cake","A triple layer chocolate dream, filled with a dense chocolate filling and covered with a rich, chocolate buttercream.",30,R.drawable.chocletcake,1,R.drawable.dctp));
        fallCakes.add(new Cake("New York Cheesecake","A class cheesecake with the decadent twist of lemon and sour cream garnished with fresh strawberries. 9&quot Round - 16 Servings.",30,R.drawable.nycakeone,2,R.drawable.nytp));
        fallCakes.add(new Cake("Red Velvet Cake","This dramatic cake has mild chocolate flavor with a moist tender crumb and a white soft creamy frosting",30,R.drawable.redvalvetcake,1,R.drawable.rvtp));
        fallCakes.add(new Cake("Sweet Potato Cheesecake","Mashed sweet potatoes and spices lend unique flavor to this blend of two classic treats. 9&quot Round - 16 Servings.",40,R.drawable.sweetpotatocake,2,R.drawable.sptp));
//        fallCakes.add(new Cake("Banana Cake","",15,R.drawable.bananacake,1));
//        fallCakes.add(new Cake("Red Velvet Cheesecake","",40,R.drawable.redvelvetcheescake,2));
//        fallCakes.add(new Cake("Bacardi Rum Cake","",30,R.drawable.bascardirumcake,1));


        mShopAdapter = new ShopAdapter(this,fallCakes);
        mViewPager.setAdapter(mShopAdapter);
        mViewPager.setPadding(160,0,160,0);
        //What i will do is, creat the list for each array list of cake.
        //Then I will set the current cake based on what the user click on the menu list.
        //I will so use the (position)to open the preview oage with the cake information.
        //for this, I will use a page listener and jsut like we were able to set the background and action bar based on which was clicked.

    }
    private void loadSummer() {
        summerCakes = new ArrayList<Cake>();
        summerCakes.add(new Cake("Banana Cake","Don't let this bread's simple flavor fool you. Our Banana bread's moist texture will have your mouth watering.",15,R.drawable.bananacake,1,R.drawable.bntbone));
        summerCakes.add(new Cake("Red Velvet Cheesecake","A luscious three layered cake, a silky smooth layer of cheesecake nestled between two layers of delectable Red Velvet Cake. Icing and toppings optional.",40,R.drawable.redvelvetcheescake,2,R.drawable.rvctp));
        summerCakes.add(new Cake("Bacardi Rum Cake","This Bacardi rum cake is lovely and moist tasting rich and wonderful.",30,R.drawable.bascardirumcake,1,R.drawable.brtp));


        mShopAdapter = new ShopAdapter(this,summerCakes);
        mViewPager.setAdapter(mShopAdapter);
        mViewPager.setPadding(160,0,160,0);
        //What i will do is, creat the list for each array list of cake.
        //Then I will set the current cake based on what the user click on the menu list.
        //I will so use the (position)to open the preview oage with the cake information.
        //for this, I will use a page listener and jsut like we were able to set the background and action bar based on which was clicked.

    }
}