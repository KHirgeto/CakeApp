package com.kingstech_app.cakeapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class PopularShopAdapeter extends PagerAdapter {

    private Context context;
    private ArrayList<Cake> modelArrayList;

    public PopularShopAdapeter(Context context, ArrayList<Cake> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @Override
    public int getCount() {
        return modelArrayList.size();
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //inflate layout card_item.xml
        View view = LayoutInflater.from(context).inflate(R.layout.card_item,container, false);

        //init uid views from card_iten.xml
        ImageView cakeImage = view.findViewById(R.id.curveCakeIV);
        TextView cakeTitle = view.findViewById(R.id.cakeTitle);
        LinearLayout cakeLayout = view.findViewById(R.id.cakeLL);

        //get data
        final Cake pCake = modelArrayList.get(position);
        final String title = pCake.getName();
        int image = pCake.getImage();
        int cakeNum = pCake.getCakeNum();

        cakeImage.setImageResource(image);
        cakeTitle.setText(title);
        //handel card click

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,title,Toast.LENGTH_SHORT).show();
                TinyDB tinydbCake = new TinyDB(context);
                tinydbCake.putString("cakeName",pCake.getName());
                tinydbCake.putString("cakeDisc",pCake.getDiscription());
                tinydbCake.putString("cakeCost",pCake.getCost()+"");
                tinydbCake.putInt("cakeImage",pCake.getCakeTransImage());
                Intent intent = new Intent(context,CakePreview.class);
                view.getContext().startActivity(intent);
                //This is where we will write the code to open a new activity which will have the prview of the cake and where the costumer can order cake.
                //We will have to save the object with current data(position) to shared perefernces and access it later on the preview page.
            }
        });

        //add view to container

        container.addView(view, position);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
