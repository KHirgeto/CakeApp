package com.kingstech_app.cakeapp;

import android.content.Context;
import android.content.Intent;
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
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_cake,container,false);

        ImageView cakeImage = view.findViewById(R.id.shopCakeIV);
        final TextView cakeTitle = view.findViewById(R.id.shopCakeTitle);
      //  RatingBar cakeRate = view.findViewById(R.id.shopRating);
        TextView cakeCost = view.findViewById(R.id.shopCakeCostTV);
        LinearLayout cakeLayout = view.findViewById(R.id.shopCakeLLayout);
        ImageView rateIV = view.findViewById(R.id.blackRateIV);

        final Cake sCake = cakes.get(position);
        final String cakeName = sCake.getName();
        final String cost = "$"+sCake.getCost()+"";
        int image = sCake.getImage();
        int cakeNum = sCake.getCakeNum();
        int rate = sCake.getCakeRate();

        cakeImage.setImageResource(image);
        cakeTitle.setText(cakeName);
        cakeCost.setText(cost);
        if(rate==5)
        {
            rateIV.setBackgroundResource(R.drawable.bfivestar);
        }
        else if(rate==4)
        {
            rateIV.setBackgroundResource(R.drawable.bfourstar);
        }
        else if(rate==3)
        {
            rateIV.setBackgroundResource(R.drawable.bthreestar);
        }
        else if(rate==2)
        {
            rateIV.setBackgroundResource(R.drawable.bttwostar);
        }
        else if(rate==1)
        {
            rateIV.setBackgroundResource(R.drawable.bonestar);
        }
        if(cakeNum == 1)
        {
            cakeTitle.setTextColor(context.getResources().getColor(R.color.white));
            cakeCost.setTextColor(context.getResources().getColor(R.color.darkAc));
            cakeLayout.setBackgroundResource(R.color.colorPrimaryDark);
        }
        else if(cakeNum ==2)
        {
            cakeTitle.setTextColor(context.getResources().getColor(R.color.background));
            cakeCost.setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
            cakeLayout.setBackgroundResource(R.color.colortwo);
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,cakeName,Toast.LENGTH_SHORT).show();
                TinyDB tinydbCake = new TinyDB(context);
                tinydbCake.putString("cakeName",sCake.getName());
                tinydbCake.putString("cakeDisc",sCake.getDiscription());
                tinydbCake.putString("cakeCost",sCake.getCost()+"");
                tinydbCake.putInt("cakeImage",sCake.getCakeTransImage());
                Intent intent = new Intent(context,CakePreview.class);
                v.getContext().startActivity(intent);
                //This is where we will write the code to open a new activity which will have the prview of the cake and where the costumer can order cake.
                //We will have to save the object with current data(position) to shared perefernces and access it later on the preview page.
            }
        });

        container.addView(view,position-1);
        return view;

    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
