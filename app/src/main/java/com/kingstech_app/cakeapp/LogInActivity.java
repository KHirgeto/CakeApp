package com.kingstech_app.cakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LogInActivity extends AppCompatActivity {
    Button logIn, signUp;
    EditText nameET, passwordET;
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
                if(nameET.getText().toString().equals("Admin")&& passwordET.getText().toString().equals("123"))
                {
                    Intent intent = new Intent(LogInActivity.this,CakeOrderList.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(LogInActivity.this,Setting.class);
                    startActivity(intent);
                }



            }
        });
    }
}