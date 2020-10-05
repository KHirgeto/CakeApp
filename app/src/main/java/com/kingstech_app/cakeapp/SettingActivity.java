package com.kingstech_app.cakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class SettingActivity extends AppCompatActivity {
    Button home,account,shop,followUs,logOut,back;
    ImageView userPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        home = (Button) findViewById(R.id.homeBTN);
        account = (Button) findViewById(R.id.accountBTN);
        shop = (Button) findViewById(R.id.shopBTN);
        followUs = (Button) findViewById(R.id.followBTN);
        logOut = (Button) findViewById(R.id.settinglogouttBTN);
        back = (Button) findViewById(R.id.back);
        userPic = (ImageView) findViewById(R.id.userPicc);
        //imageSetter();

        TinyDB tinyDB = new TinyDB(getApplicationContext());

        Uri myUri = Uri.parse(tinyDB.getString("imagepath"));
        //userPic.setImageURI(null);
        //userPic.setImageURI(myUri);

        Log.d("Imagepath2",myUri.toString());

       // userPic.setImageBitmap(imageValue);
        Picasso.get().load(myUri).into(userPic);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, LogInActivity.class);
                startActivity(intent);
            }
        });
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this,AccountActivity.class);
                startActivity(intent);
            }
        });
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this,LogInActivity.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this,ShopActivity.class);
                startActivity(intent);
            }
        });
    }
    public void imageSetter()
    {
//        SharedPreferences shre = getSharedPreferences("picPref", Context.MODE_PRIVATE);
//        String imageUri = shre.getString("imagepath","");
        TinyDB tinyDB = new TinyDB(getApplicationContext());

        Uri myUri = Uri.parse(tinyDB.getString("imagepath"));
        Picasso.get().load(myUri.toString()).into(userPic);
        Log.d("Imagepath2",myUri.toString());
      //  Picasso.get().load(myUri).into(userPic);


       // File fileLocation = new File(imageUri); //file path, which can be String, or Uri
        //Picasso.with(this).load(fileLocation).into(userPic);
    }



}