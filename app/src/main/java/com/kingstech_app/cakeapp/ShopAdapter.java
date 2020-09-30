package com.kingstech_app.cakeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ShopAdapter extends PagerAdapter{
    private Context context;
    private ArrayList<Cake> cakes;

    public ShopAdapter(Context context, ArrayList<Cake> cakes) {
        this.context = context;
        this.cakes = cakes;
    }

    @Override
    public int getCount() {
        return cakes.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_cake,container,false);

        ImageView cakeImage = view.findViewById(R.id.shopCakeIV);
        final TextView cakeTitle = view.findViewById(R.id.shopCakeTitle);
      //  RatingBar cakeRate = view.findViewById(R.id.shopRating);
        TextView cakeCost = view.findViewById(R.id.shopCakeCostTV);

        Cake sCake = cakes.get(position);
        final String cakeName = sCake.getName();
        final String cost = sCake.getCost()+"";
        int image = sCake.getImage();

        cakeImage.setImageResource(image);
        cakeTitle.setText(cakeName);
        cakeCost.setText(cost);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,cakeName,Toast.LENGTH_SHORT).show();
            }
        });

        container.addView(view,position);
        return view;

    }
}
