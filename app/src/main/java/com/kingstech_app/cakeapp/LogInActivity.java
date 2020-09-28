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

public class LogInActivity extends AppCompatActivity {
    Button logIn, signUp;
    EditText nameET, passwordET;
    private static final String TAG = "PNPNPNPNPNPNPN";
    private static final String TAG2 = "PNPNPNPNPNPNPN";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        logIn = (Button) findViewById(R.id.loginBTN);
        signUp = (Button) findViewById(R.id.newBTN);
        nameET = (EditText) findViewById(R.id.nameET);
        passwordET = (EditText) findViewById(R.id.passwordET);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences mPrefs = getSharedPreferences("Name", Context.MODE_PRIVATE);
                Gson gson = new Gson();
                String json = mPrefs.getString("Key", "");
                User obj = gson.fromJson(json, User.class);

                if(nameET.getText().toString().equals("Admin")&& passwordET.getText().toString().equals("123"))
                {
                    Intent intent = new Intent(LogInActivity.this,CakeOrderList.class);
                    startActivity(intent);
                }
                else if(check())
                {
                    Intent intent = new Intent(LogInActivity.this,SettingActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),R.string.loginERROR,Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
    public boolean check()
    {
        SharedPreferences mPrefs = getSharedPreferences("NamePref", Context.MODE_PRIVATE);

        String name = nameET.getText().toString();
        String password = passwordET.getText().toString();
        String nameP = mPrefs.getString("name","");
        String passwordP = mPrefs.getString("password","");
        if(name.equals(nameP)&&password.equals(passwordP))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}