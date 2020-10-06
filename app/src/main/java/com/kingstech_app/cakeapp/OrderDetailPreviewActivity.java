package com.kingstech_app.cakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class OrderDetailPreviewActivity extends AppCompatActivity {

    TextView nameTV,phoneTV,emailTV,addressTV,cakenameTV,cakecostTV,timeTV;
    ImageView cakeIV;
    Button backOD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail_preview);
        nameTV = (TextView) findViewById(R.id.odusername);
        phoneTV = (TextView) findViewById(R.id.odphone);
        emailTV = (TextView) findViewById(R.id.odemail);
        addressTV = (TextView) findViewById(R.id.odaddress);
        cakenameTV = (TextView) findViewById(R.id.odcakename);
        cakecostTV = (TextView) findViewById(R.id.odcakecost);
        timeTV = (TextView) findViewById(R.id.odtime);
        cakeIV = (ImageView) findViewById(R.id.odIV);
        backOD = (Button) findViewById(R.id.backOD);

        backOD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        final TinyDB tinyDB = new TinyDB(this);
        nameTV.setText(tinyDB.getString("nameOD"));
        phoneTV.setText(tinyDB.getString("phoneOD"));
        emailTV.setText(tinyDB.getString("emailOD"));
        addressTV.setText(tinyDB.getString("addressOD"));
        cakenameTV.setText(tinyDB.getString("cakeNameOD"));
        cakecostTV.setText(tinyDB.getString("cakeCostOD"));
        timeTV.setText(tinyDB.getString("timeOD"));
        cakeIV.setBackgroundResource(tinyDB.getInt("imageOD"));
    }
}