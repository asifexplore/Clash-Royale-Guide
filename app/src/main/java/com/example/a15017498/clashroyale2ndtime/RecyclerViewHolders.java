package com.example.a15017498.clashroyale2ndtime;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15017498 on 12/3/2017.
 */

public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{

    List<ItemObject> itemList31;

    public ImageView countryPhoto;

    public RecyclerViewHolders(View itemView,List<ItemObject> itemList3) {
        super(itemView);
        itemList31 = itemList3;
        itemView.setOnClickListener(this);
        countryPhoto = (ImageView)itemView.findViewById(R.id.country_photo);
    }

    @Override
    public void onClick(View view) {
       Intent intent = new Intent(view.getContext(),cardDetails.class);

        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(itemView.getContext());

        if(itemList31 == null){
            int itemPosition = getAdapterPosition();
            intent.putExtra("position",itemPosition);
        }else{
            int number = itemList31.get(getAdapterPosition()).getNumber();
            number = number - 1;
            intent.putExtra("location",number);
        }

        view.getContext().startActivity(intent);

    }

}

