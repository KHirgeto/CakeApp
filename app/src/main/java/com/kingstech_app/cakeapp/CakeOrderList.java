package com.kingstech_app.cakeapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CakeOrderList extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");
    //FirebaseStorage storage = FirebaseStorage.getInstance();
    private static final String TAG2 = "ZZZZZZZZZZZZZ";
    Button logout;
    ListView cakeLV;
    // Order order;
    // ArrayList<Order> mOrders;
    //ArrayList<String> name;


    ArrayList<String> cakeNames = new ArrayList<String>();
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<Integer> images = new ArrayList<Integer>();
    ArrayList<String> time = new ArrayList<String>();
    //int images[] = {R.drawable.carrocake, R.drawable.dctp, R.drawable.nytp, R.drawable.rvtp, R.drawable.rvtp, R.drawable.bntbone, R.drawable.redvelvetcheescake, R.drawable.brtp, R.drawable.upsidedown_t, R.drawable.keylimecake, R.drawable.carootcakecur, R.drawable.dctp};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake_order_list);
        logout = (Button) findViewById(R.id.logoutBTN);
        cakeLV = (ListView) findViewById(R.id.cakeListView);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CakeOrderList.this, LogInActivity.class);
                startActivity(intent);
            }
        });

        final ArrayList<Order> mOrders = new ArrayList<Order>();
        MyAdapter adapter = new MyAdapter(this, cakeNames, names, images,time);
        cakeLV.setAdapter(adapter);
        for(Order k:mOrders)
        {
            cakeNames.add(k.getCakeName());
            names.add(k.getCakeName());
            images.add(k.getImage());
            time.add(k.getCurrentTime());
        }

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    Order order;
                    order = new Order("", "", "", "", "", "", "",0,"");
                    for (DataSnapshot shot : dataSnapshot.getChildren()) {
                        try {
                            order = (Order) shot.getValue(Order.class);
                            mOrders.add(order);

//                            ArrayList<Object> orderListObject = new ArrayList<Object>();
//
//                            for(Order m : mOrders){
//                                orderListObject.add((Object)m);
//                            }
//                            TinyDB tinydb = new TinyDB(getApplicationContext());
//                            tinydb.putListObject("orderlist", orderListObject);
                        } catch (Exception ex) {
                            Log.e(TAG2, ex.toString());
                        }
                    }
                }
                for (Order o : mOrders) {
                    cakeNames.add(o.getCakeName());
                    names.add(o.getName());
                    images.add(o.getImage());
                    time.add(o.getCurrentTime());

                }
//                ArrayList<String> savedCakeNames = new ArrayList<String>();
//                for(String m : cakeNames){
//                    savedCakeNames.add((String) m);
////                }
//                TinyDB tinydb = new TinyDB(getApplicationContext());
//                tinydb.remove("cakenames");
//                tinydb.putListString("cakenames",cakeNames);
//                Log.d("TOSAVEDORDER",cakeNames.toString());

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG2, "Failed to read value.", error.toException());
            }
        });

//        TinyDB tinydb = new TinyDB(this);
//        final ArrayList<String> savednames = tinydb.getListString("cakenames");
//        cakeNames.clear();
//        cakeNames.addAll(savednames);
//        Log.d("NEWSAVEDORDER", cakeNames.toString());

//        MyAdapter adapter = new MyAdapter(this,cakeName,name,time,images);
//        cakeLV.setAdapter(adapter);
        cakeLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(CakeOrderList.this, "Cake1 Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(CakeOrderList.this, "Cake2 Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(CakeOrderList.this, "Cake3 Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(CakeOrderList.this, "Cake4 Description", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
       ArrayList<String> cakeName;
        ArrayList<String> name;
        ArrayList<Integer> rImgs;
        ArrayList<String> time;

        MyAdapter(Context c, ArrayList<String> cakeNameList, ArrayList<String> nameList, ArrayList<Integer> imgs,ArrayList<String>timeList) {
            super(c, R.layout.row, R.id.cakenameTV, cakeNameList);
            this.context = c;
            this.cakeName = cakeNameList;
            this.name = nameList;
            this.rImgs = imgs;
            this.time = timeList;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.cakeIV);
            TextView cakeNamee = row.findViewById(R.id.cakenameTV);
            TextView namee = row.findViewById(R.id.nameTV);
            TextView timee = row.findViewById(R.id.timeTV);

            images.setImageResource(rImgs.get(position));
            cakeNamee.setText(cakeName.get(position));
            namee.setText(name.get(position));
            timee.setText(time.get(position));


            return row;
        }


    }
}
