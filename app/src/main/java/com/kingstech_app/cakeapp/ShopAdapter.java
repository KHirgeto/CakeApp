package com.kingstech_app.cakeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
        final TextView cakeTitle = view.findViewById(R.id.shopCakeTitleBTN);
      //  RatingBar cakeRate = view.findViewById(R.id.shopRating);
        TextView cakeCost = view.findViewById(R.id.shopCakeCostTV);
        LinearLayout cakeLayout = view.findViewById(R.id.shopCakeLLayout);

        Cake sCake = cakes.get(position);
        final String cakeName = sCake.getName();
        final String cost = "$"+sCake.getCost()+"";
        int image = sCake.getImage();
        int cakeNum = sCake.getCakeNum();

        cakeImage.setImageResource(image);
        cakeTitle.setText(cakeName);
        cakeCost.setText(cost);
        if(cakeNum == 1)
        {
            cakeTitle.setTextColor(context.getResources().getColor(R.color.white));
            cakeTitle.setTextColor(context.getResources().getColor(R.color.exDarkGray));
            cakeLayout.setBackgroundResource(R.color.colorPrimaryDark);
        }
        else if(cakeNum ==2)
        {
            cakeTitle.setTextColor(context.getResources().getColor(R.color.background));
            cakeTitle.setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
            cakeLayout.setBackgroundResource(R.color.colortwo);
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,cakeName,Toast.LENGTH_SHORT).show();
            }
        });

        container.addView(view,position);
        return view;

    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
