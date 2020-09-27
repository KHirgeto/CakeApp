package com.kingstech_app.cakeapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
import android.widget.TextView;
import android.widget.Toast;

public class CakeOrderList extends AppCompatActivity {
    Button logout;
    ListView cakeLV;

    String cakeName[] = {"Carrot Cake","Strawberry Cake","Key Lime Cake", "Red Velvet Cake"};
    String name[] = {"K Hirgeto","Chappy","Lilly", "Luoxin"};
    String time[] = {"12:15 PM","2:00 PM","10:30 AM", "4:20 PM"};
    int images[] = {R.drawable.strawcake,R.drawable.carrocake,R.drawable.redcake,R.drawable.keylimecake};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake_order_list);

        logout = (Button) findViewById(R.id.logoutBTN);
        cakeLV = (ListView) findViewById(R.id.cakeListView);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CakeOrderList.this,LogInActivity.class);
                startActivity(intent);
            }
        });

        MyAdapter adapter = new MyAdapter(this,cakeName,name,time,images);
        cakeLV.setAdapter(adapter);
        cakeLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Toast.makeText(CakeOrderList.this, "Cake1 Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(CakeOrderList.this, "Cake2 Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(CakeOrderList.this, "Cake3 Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(CakeOrderList.this, "Cake4 Description", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
        class MyAdapter extends ArrayAdapter<String>{
            Context context;
            String cakeName[];
            String name[];
            String time[];
            int rImgs[];

            MyAdapter (Context c,String cakeNameList[],String nameList[],String timeList[],int imgs[]){
                super(c,R.layout.row,R.id.cakenameTV,cakeNameList);
                this.context = c;
                this.cakeName = cakeNameList;
                this.name = nameList;
                this.time = timeList;
                this.rImgs = imgs;
            }

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View row = layoutInflater.inflate(R.layout.row,parent,false);
                ImageView images = row.findViewById(R.id.cakeIV);
                TextView cakeNamee = row.findViewById(R.id.cakenameTV);
                TextView namee = row.findViewById(R.id.nameTV);
                TextView timee = row.findViewById(R.id.timeTV);

                images.setImageResource(rImgs[position]);
                cakeNamee.setText(cakeName[position]);
                namee.setText(name[position]);
                timee.setText(time[position]);




                return row;
            }
        }
}
