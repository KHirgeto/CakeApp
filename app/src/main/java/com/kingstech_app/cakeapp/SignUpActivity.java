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
import android.widget.Toast;

import com.google.gson.Gson;


public class SignUpActivity extends AppCompatActivity {
    public static final String TAG = "BBBBBBB2";
    public static final String TAG2 = "CCCCCCCCCC";
   // Context context;
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
//        if(check())
//        {
////          Toast.makeText(this,"Already have an account",Toast.LENGTH_SHORT).show();
////            Intent intent = new Intent(SignUpActivity.this,SettingActivity.class);
////            startActivity(intent);
////            finish();
//        }

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
                    store();
                    Intent intent = new Intent(SignUpActivity.this,HomeActivity.class);
                    startActivity(intent);
                }
            });





    }
    public void store()
    {
        User user;
        user = new User(nameET.getText().toString().trim(),passwordET.getText().toString().trim(),phoneET.getText().toString().trim(),emailET.getText().toString().trim(),adressET.getText().toString().trim());
        TinyDB tinydbCake = new TinyDB(this);
        //tinydbCake.putObject("user",user);
        tinydbCake.putString("username",user.getName());
        tinydbCake.putString("password",user.getPassword());
        tinydbCake.putString("phone",user.getPhone());
        tinydbCake.putString("email",user.getEmail()+"");
        tinydbCake.putString("address",user.getAddress());


    }

}