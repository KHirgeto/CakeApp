package com.kingstech_app.cakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Setting extends AppCompatActivity {
    Button home,account,shop,followUs,logOut,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
//        home = (Button) findViewById(R.id.homeBTN);
//        account = (Button) findViewById(R.id.accountBTN);
//        shop = (Button) findViewById(R.id.shopBTN);
//        followUs = (Button) findViewById(R.id.followBTN);
//        logOut = (Button) findViewById(R.id.logoutBTN);
        back = (Button) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setting.this, LogInActivity.class);
                startActivity(intent);
            }
        });
    }
}