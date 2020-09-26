package com.kingstech_app.cakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpActivity extends AppCompatActivity {
    Button signup, login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signup = (Button) findViewById(R.id.signupBTN);
        login = (Button) findViewById(R.id.loginBTN);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this,LogInActivity.class);
                startActivity(intent);
            }
        });
    }
}