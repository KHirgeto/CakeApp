package com.kingstech_app.cakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.gson.Gson;

public class LogInActivity extends AppCompatActivity {
    Button logIn, signUp;
    EditText nameET, passwordET;
    ToggleButton mToggleButton;
    private static final String TAG = "PNPNPNPNPNPNPN";
    private static final String TAG2 = "PNPNPNPNPNPNPN";
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        mToggleButton = (ToggleButton) findViewById(R.id.toggleBTN);
        logIn = (Button) findViewById(R.id.loginBTN);
        signUp = (Button) findViewById(R.id.newBTN);
        nameET = (EditText) findViewById(R.id.nameET);
        passwordET = (EditText) findViewById(R.id.passwordET);
        mToggleButton.setText(null);
        mToggleButton.setTextOn(null);
        mToggleButton.setTextOff(null);
        mToggleButton.setBackgroundResource(R.drawable.toggle);

        if(runLoginAuto())
        {
            Intent intent = new Intent(LogInActivity.this,HomeActivity.class);
            startActivity(intent);
        }
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        mToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    TinyDB tinyDB = new TinyDB(getApplicationContext());
                    if(nameET.getText().toString().trim().equals(tinyDB.getString("username"))&& passwordET.getText().toString().trim().equals(tinyDB.getString("password")))
                    {
                        mToggleButton.setChecked(true);
                        tinyDB.putBoolean("toggle",true);
                    }
                    else if(nameET.getText().toString().equals("")&& passwordET.getText().toString().equals(""))
                    {
                        mToggleButton.setChecked(false);
                        Toast.makeText(getApplicationContext(),"Enter username and password first",Toast.LENGTH_SHORT).show();
                    }

                  //  Boolean value = true;

                } else {
                    // The toggle is disabled
                    TinyDB tinyDB = new TinyDB(getApplicationContext());
                    tinyDB.putBoolean("toggle",false);
                }
            }
        });
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SharedPreferences mPrefs = getSharedPreferences("Name", Context.MODE_PRIVATE);
//                Gson gson = new Gson();
//                String json = mPrefs.getString("Key", "");
//                User obj = gson.fromJson(json, User.class);

              //  TinyDB tinyDB = new TinyDB(context);
                 //tinyDB.getString("username");

                if(nameET.getText().toString().trim().equals("Admin")&& passwordET.getText().toString().trim().equals("123"))
                {
                    Intent intent = new Intent(LogInActivity.this,CakeOrderList.class);
                    startActivity(intent);
                }
                else if(check())
                {
                    Intent intent = new Intent(LogInActivity.this,HomeActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),R.string.loginERROR,Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
//    public boolean check()
//    {
//        SharedPreferences mPrefs = getSharedPreferences("NamePref", Context.MODE_PRIVATE);
//
//        String name = nameET.getText().toString();
//        String password = passwordET.getText().toString();
//        String nameP = mPrefs.getString("name","");
//        String passwordP = mPrefs.getString("password","");
//        if(name.equals(nameP)&&password.equals(passwordP))
//        {
//            return true;
//        }
//        else
//        {
//            return false;
//        }
//    }
    public boolean check()
    {
        TinyDB tinyDB = new TinyDB(this);
        if(nameET.getText().toString().trim().equals(tinyDB.getString("username"))&& passwordET.getText().toString().trim().equals(tinyDB.getString("password")))
        {
            Log.d("AAAAAAAAAA",tinyDB.getString(""));
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean runLoginAuto()
    {
        TinyDB tinyDB = new TinyDB(this);
        if(tinyDB.getBoolean("toggle"))
        {
            return true;
        }
        else{
            return false;
        }
    }



}