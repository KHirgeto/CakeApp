package com.kingstech_app.cakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AccountActivity extends AppCompatActivity {
    Button back,upload,update;
    EditText nameET,passwordET,phoneET,emailET,addressET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        back = (Button) findViewById(R.id.aback);
        update = (Button) findViewById(R.id.updateBTN);
        upload = (Button) findViewById(R.id.uploadPhotoBTN);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

    }
}