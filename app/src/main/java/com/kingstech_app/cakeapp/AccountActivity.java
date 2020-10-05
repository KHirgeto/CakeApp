package com.kingstech_app.cakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;

public class AccountActivity extends AppCompatActivity {
    Button back,upload,update;
    EditText nameET,passwordET,phoneET,emailET,addressET;
    ImageView mImageView;
    Uri imageValue;
    Context context;
    private static final int PICK_IMAGE_REGUEST = 1;
    private static final String TAG = "AAAAAAAA";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        back = (Button) findViewById(R.id.aback);
        update = (Button) findViewById(R.id.updateBTN);
        upload = (Button) findViewById(R.id.uploadPhotoBTN);
        mImageView = (ImageView) findViewById(R.id.userPhoto);
        nameET = (EditText) findViewById(R.id.aNameET);
        passwordET = (EditText) findViewById(R.id.aPassWordET);
        phoneET = (EditText) findViewById(R.id.aPhoneET);
        emailET = (EditText) findViewById(R.id.aEmailET);
        addressET = (EditText) findViewById(R.id.aAddressET);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFileChooser();

            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namee = nameET.getText().toString();
                String passwordd = passwordET.getText().toString();
                String phonee = phoneET.getText().toString();
                String emaill = emailET.getText().toString();
                String addresss = addressET.getText().toString();


//                SharedPreferences mPrefs = getSharedPreferences("NamePref", Context.MODE_PRIVATE);
//                SharedPreferences.Editor prefsEditor = mPrefs.edit();
                TinyDB tinyDB = new TinyDB(getApplicationContext());
                if(!namee.isEmpty())
                {
//                    prefsEditor.remove(mPrefs.getString("name",""));
//                    prefsEditor.putString("name",namee);
                   // tinyDB.remove("username");
                    tinyDB.putString("username",namee);
                }
                if(!passwordd.isEmpty())
                {
//                    prefsEditor.remove(mPrefs.getString("password",""));
//                    prefsEditor.putString("password",passwordd);
                   // tinyDB.remove("password");
                    tinyDB.putString("password",passwordd);
                }
                if(!phonee.isEmpty())
                {
//                    prefsEditor.remove(mPrefs.getString("phone",""));
//                    prefsEditor.putString("phone",phonee);
                   // tinyDB.remove("phone");
                    tinyDB.putString("phone",phonee);
                }
                if(!emaill.isEmpty())
                {
//                    prefsEditor.remove(mPrefs.getString("email",""));
//                    prefsEditor.putString("email",emaill);
                    //tinyDB.remove("email");
                    tinyDB.putString("email",emaill);
                }
                if(!addresss.isEmpty())
                {
//                    prefsEditor.remove(mPrefs.getString("address",""));
//                    prefsEditor.putString("address",addresss);
                   // tinyDB.remove("address");
                    tinyDB.putString("address",addresss);
                }
            //    prefsEditor.commit();
                Toast.makeText(AccountActivity.this, "Information Updated", Toast.LENGTH_SHORT).show();
//                SharedPreferences mPrefsS = getSharedPreferences("NamePref", Context.MODE_PRIVATE);
//                Log.d(TAG,mPrefsS.getString("name",""));
            }
        });
    }
    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REGUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REGUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            imageValue = data.getData();
//            SharedPreferences shre = getSharedPreferences("picPref", Context.MODE_PRIVATE);
//            SharedPreferences.Editor edit=shre.edit();
            TinyDB tinyDB = new TinyDB(getApplicationContext());
            tinyDB.putString("imagepath", Environment.getExternalStorageDirectory().getPath()+imageValue);
            Log.d("imagepath",imageValue.toString());
            Picasso.get().load(imageValue).into(mImageView);
           //File fileLocation = new File(String.valueOf(imageValue));
            //Picasso.with(this).load(fileLocation).into(mImageView);
        }
    }


}