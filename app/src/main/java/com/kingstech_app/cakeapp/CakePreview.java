package com.kingstech_app.cakeapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CakePreview extends AppCompatActivity {
    Button backBTN;
    TextView cakeTitle,cakeDisc,cakeCost;
    ImageView cakeIV;
    String cakeCostString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake_preview);

        backBTN = (Button) findViewById(R.id.cpBackBTN);
        cakeTitle = (TextView) findViewById(R.id.cpCakeNameTV);
        cakeDisc = (TextView) findViewById(R.id.cpCakeDiscTV);
        cakeCost = (TextView) findViewById(R.id.cpCakeCost);
        cakeIV = (ImageView) findViewById(R.id.cpCakeIV);
        String spCh = "&quot";
        String[] sizes = new String[]{"9"+spCh+"x13"+spCh,"13"+spCh+"x18"+spCh,"18"+spCh+"x26"+spCh,};

        TinyDB tinyDB = new TinyDB(this);
        cakeCostString = "$"+tinyDB.getString("cakeCost");
        cakeTitle.setText(tinyDB.getString("cakeName"));
        cakeDisc.setText(tinyDB.getString("cakeDisc"));
        cakeCost.setText(cakeCostString);
        cakeIV.setImageResource(tinyDB.getInt("cakeImage"));

        backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
                finish();
            }
        });



    }
}