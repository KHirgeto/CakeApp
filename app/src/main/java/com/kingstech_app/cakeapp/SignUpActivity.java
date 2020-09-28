package com.kingstech_app.cakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
//import com.google.gson.Gson;

public class SignUpActivity extends AppCompatActivity {
    public static final String TAG = "BBBBBBB2";
    public static final String TAG2 = "CCCCCCCCCC";
    Button signup, login;
    EditText nameET,passwordET, phoneET,emailET,adressET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signup = (Button) findViewById(R.id.ssignupBTN);
        login = (Button) findViewById(R.id.loginBTN);
        nameET = (EditText) findViewById(R.id.snameET);
        passwordET = (EditText) findViewById(R.id.spasswordET);
        phoneET = (EditText) findViewById(R.id.sphoneET);
        emailET = (EditText) findViewById(R.id.semailET);
        adressET = (EditText) findViewById(R.id.saddressET);
        if(check())
        {
            Intent intent = new Intent(SignUpActivity.this,SettingActivity.class);
            startActivity(intent);
            finish();
        }
        else
        {
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SignUpActivity.this,LogInActivity.class);
                    startActivity(intent);
                }
            });
            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    User user;
                    user = new User(nameET.getText().toString(),passwordET.getText().toString(),phoneET.getText().toString(),emailET.getText().toString(),adressET.getText().toString());

                    String name = user.getName();
                    String password = user.getPassword();
                    String phone = user.getPhone();
                    String email = user.getEmail();
                    String address = user.getAddress();

                    SharedPreferences mPrefs = getSharedPreferences("NamePref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor prefsEditor = mPrefs.edit();
                  //  Gson gson = new Gson();
                 //   String json = gson.toJson(user);
                    prefsEditor.putString("name",name);
                    prefsEditor.putString("password",password);
                    prefsEditor.putString("phone",phone);
                    prefsEditor.putString("email",email);
                    prefsEditor.putString("address",address);
                    prefsEditor.commit();


                    Intent intent = new Intent(SignUpActivity.this,SettingActivity.class);
                    startActivity(intent);
                }
            });

        }



    }
    public boolean check()
    {
        SharedPreferences mPrefs = getSharedPreferences("NamePref", Context.MODE_PRIVATE);
//        Gson gson = new Gson();
//        String json = mPrefs.getString("Key", "");
//        User obj = gson.fromJson(json, User.class);
        String name = mPrefs.getString("name","");

        if(name.equals(""))
        {

            return false;
        }
        else
        {
            return true;
        }

    }
}