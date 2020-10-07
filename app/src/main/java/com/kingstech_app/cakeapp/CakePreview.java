package com.kingstech_app.cakeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsManager;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

public class CakePreview extends AppCompatActivity {
    final int SEND_SMS_PERMISSION_REQUEST_CODE = 1;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");
    //FirebaseStorage storage = FirebaseStorage.getInstance();
    private static final String TAG = "DDDDDDDDDDDDD";
    Button backBTN, orderBTN;
    TextView cakeTitle,cakeDisc,cakeCost;
    ImageView cakeIV;
    String cakeCostString;
    Order order;
    ScrollView mScrollView;
    LinearLayout thankyouLL;
    ArrayList<Order> orders = new ArrayList<Order>();
    EditText orderNoteET,qty;
    SmsManager smsManager = SmsManager.getDefault();
    final String numToSend = "4432196888";
    Handler mHandler = new Handler();
    Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            mScrollView.setVisibility(View.GONE);
            thankyouLL.setVisibility(View.VISIBLE);
            backBTN.setVisibility(View.VISIBLE);

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake_preview);
        mScrollView = (ScrollView) findViewById(R.id.scrollLayout);
        thankyouLL = (LinearLayout) findViewById(R.id.thankyouLL);
        backBTN = (Button) findViewById(R.id.cpBackBTN);
        cakeTitle = (TextView) findViewById(R.id.cpCakeNameTV);
        cakeDisc = (TextView) findViewById(R.id.cpCakeDiscTV);
        cakeCost = (TextView) findViewById(R.id.cpCakeCost);
        cakeIV = (ImageView) findViewById(R.id.cpCakeIV);
        orderBTN = (Button) findViewById(R.id.orderBTN);
        orderNoteET = (EditText) findViewById(R.id.orderNoteET);
        qty = (EditText) findViewById(R.id.qty);
        mScrollView.setVisibility(View.VISIBLE);
        thankyouLL.setVisibility(View.GONE);
        backBTN.setVisibility(View.VISIBLE);
        Time time = new Time(Calendar.getInstance().getTimeInMillis());
        final String currentTime;
        currentTime = time.toString();
        String spCh = "&quot";
        String[] sizes = new String[]{"9"+spCh+"x13"+spCh,"13"+spCh+"x18"+spCh,"18"+spCh+"x26"+spCh,};

        final TinyDB tinyDB = new TinyDB(this);
//        int qtyy = Integer.parseInt(qty.getText().toString());
//        int cost = Integer.parseInt(tinyDB.getString("cakeCost"));
//        int newV = cost*qtyy;
        cakeCostString = "$"+tinyDB.getString("cakeCost");
        cakeTitle.setText(tinyDB.getString("cakeName"));
        cakeDisc.setText(tinyDB.getString("cakeDisc"));
        cakeIV.setBackgroundResource(tinyDB.getInt("cakeImage"));
        cakeCost.setText(cakeCostString);
        tinyDB.putString("qty",qty.getText().toString());
        tinyDB.putString("cakeCost",cakeCostString);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                if (dataSnapshot == null) {
                    orders = new ArrayList<Order>();
                } else {
                    Order cakeOrder;
                    cakeOrder = new Order("", "", "", "", "", "", "",0,"",0);
                    for (DataSnapshot shot : dataSnapshot.getChildren()) {
                        try {
                            cakeOrder = (Order) shot.getValue(Order.class);
                        } catch (Exception ex) {
                            Log.e(TAG, ex.toString());
                            continue;
                        }
                        orders.add(cakeOrder);
                    }
                }
                Log.d(TAG, "Value is: " + order);

//                String value = dataSnapshot.getValue(String.class);
//                Log.d(TAG, "Value is: " + value);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
                finish();
            }
        });
        orderBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TinyDB tinyDB1 = new TinyDB(getApplicationContext());
                Order newOrder = null;
                try {
                    int qty = Integer.parseInt(tinyDB1.getString("qty"));
                    newOrder = new Order(tinyDB1.getString("username"),tinyDB1.getString("phone"),tinyDB1.getString("email"),tinyDB1.getString("address"),tinyDB1.getString("cakeName"),tinyDB1.getString("cakeCost"),orderNoteET.getText().toString().trim(),tinyDB1.getInt("cakeImage"),currentTime,qty);
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                Log.d("VALUE",newOrder.toString());
                tinyDB1.putObject("Order",newOrder);
               // String uploadID = myRef.push().getKey();
                orders.add(newOrder);
                myRef.setValue(orders);

                //uncomment the code bellow to be able to send message
//                ActivityCompat.requestPermissions(CakePreview.this,
//                        new String[]{Manifest.permission.SEND_SMS}, SEND_SMS_PERMISSION_REQUEST_CODE);
//                onSend(view);

                mHandler.postDelayed(mRunnable,2000);

               // Toast.makeText(getApplicationContext(),"Order sent",Toast.LENGTH_SHORT).show();

                //use finish(); to stop user form adding arralist to arraylist of value stored on firebase.
            }
        });



    }
    // The two methods commented out bellow might be used in the future to send automatic message.
//    public void onSend(View v){
//        Order orderInfo= new Order();
//        TinyDB tinyDB2 = new TinyDB(this);
//        orderInfo = tinyDB2.getObject("Order",Order.class);
//
//        if(orderInfo.toString().length() == 0){
//            return;
//        }
//
//        if(checkPermission(Manifest.permission.SEND_SMS)){
//            SmsManager smsManager = SmsManager.getDefault();
//            smsManager.sendTextMessage(numToSend, null, orderInfo.toString(), null, null);
//            Log.d("TEXTSENT",orderInfo.toString());
//            Log.d("TEXTSENTttt",orderInfo.getName());
//            Toast.makeText(this, "Message Sent!", Toast.LENGTH_SHORT).show();
//        }else{
//            Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    public boolean checkPermission(String permission){
//        int check = ContextCompat.checkSelfPermission(this, permission);
//        return (check == PackageManager.PERMISSION_GRANTED);
//    }

//
//    public String createTransactionID() throws Exception{ //This method is used to create random unique ids. I will use it in the future
//        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
//    }
}