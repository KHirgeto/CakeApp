package com.kingstech_app.cakeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.InvalidMarkException;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class MyAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<PopularCake> modelArrayList;

    public MyAdapter(Context context, ArrayList<PopularCake> modelArrayList) {
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
        PopularCake pCake = modelArrayList.get(position);
        final String title = pCake.getName();
        int image = pCake.getImage();
        int cakeNum = pCake.getCakeNum();

        cakeImage.setImageResource(image);
        cakeTitle.setText(title);
        if(cakeNum == 1)
        {
            cakeLayout.setBackgroundResource(R.drawable.homecakeone);
        }
        else if(cakeNum ==2)
        {
            cakeLayout.setBackgroundResource(R.drawable.homecaketwo);
        }
        //handel card click

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,title,Toast.LENGTH_SHORT).show();
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
