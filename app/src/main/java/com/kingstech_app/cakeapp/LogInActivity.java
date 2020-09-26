package com.kingstech_app.cakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.Button;

public class LogInActivity extends AppCompatActivity {
    Button logIn, signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        logIn = (Button) findViewById(R.id.loginBTN);
        signUp = (Button) findViewById(R.id.newBTN);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}