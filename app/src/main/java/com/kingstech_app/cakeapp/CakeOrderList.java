package com.kingstech_app.cakeapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
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

import com.google.firebase.database.ChildEventListener;
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

    int counter;
    ArrayList<String> cakeNames = new ArrayList<String>();
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<Integer> images = new ArrayList<Integer>();
    ArrayList<String> time = new ArrayList<String>();
    ArrayList<String> phones = new ArrayList<String>();
    ArrayList<String> emails = new ArrayList<String>();
    ArrayList<String> adsresses = new ArrayList<String>();
    ArrayList<String> costs = new ArrayList<String>();
    ArrayList<Integer> id = new ArrayList<Integer>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake_order_list);
        logout = (Button) findViewById(R.id.logoutBTN);
        cakeLV = (ListView) findViewById(R.id.cakeListView);
        counter = 0;
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CakeOrderList.this, LogInActivity.class);
                startActivity(intent);
            }
        });

        final ArrayList<Order> mOrders = new ArrayList<Order>();

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
                    phones.add(o.getPhone());
                    emails.add(o.getEmail());
                    adsresses.add(o.getAddress());
                    costs.add(o.getCakeCost());
                    id.add(counter);
                    counter++;
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG2, "Failed to read value.", error.toException());
            }
        });
        final MyAdapter adapter = new MyAdapter(this, cakeNames, names, images,time);
        cakeLV.setAdapter(adapter);
        cakeLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TinyDB tinydbOD = new TinyDB(getApplicationContext());
                tinydbOD.putString("nameOD",names.get(position));
                tinydbOD.putString("cakeNameOD",cakeNames.get(position));
                tinydbOD.putInt("imageOD",images.get(position));
                tinydbOD.putString("timeOD",time.get(position));
                tinydbOD.putString("phoneOD",phones.get(position));
                tinydbOD.putString("emailOD",emails.get(position));
                tinydbOD.putString("addressOD",adsresses.get(position));
                tinydbOD.putString("cakeCostOD",costs.get(position));
                Intent intent = new Intent(CakeOrderList.this,OrderDetailPreviewActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                view.getContext().startActivity(intent);
            }
        });
        cakeLV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Long pressed",Toast.LENGTH_SHORT).show();

                final DatabaseReference child = myRef.child("message");
               // String x=  value.toString();
                myRef.child(String.valueOf(i)).removeValue();
                cakeNames.remove(i);
                costs.remove(i);
                names.remove(i);
                phones.remove(i);
                emails.remove(i);
                adsresses.remove(i);
                images.remove(i);
                time.remove(i);
                adapter.notifyDataSetChanged();
                myRef.child(id.get(i).toString()).removeValue();
                adapter.notifyDataSetChanged();
                return true;
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
