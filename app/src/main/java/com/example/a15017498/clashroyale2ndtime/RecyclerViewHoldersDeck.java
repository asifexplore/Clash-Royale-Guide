package com.example.a15017498.clashroyale2ndtime;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by 15017498 on 21/3/2017.
 */

    public class RecyclerViewHoldersDeck extends RecyclerView.ViewHolder implements View.OnClickListener{

    public ImageView countryPhoto;
    String imgName;

    public RecyclerViewHoldersDeck(View itemView, String imgName1) {
        super(itemView);
        itemView.setOnClickListener(this);
        countryPhoto = (ImageView) itemView.findViewById(R.id.country_photo);
        imgName = imgName1;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), uploadDeck.class);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(itemView.getContext());
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putInt(imgName,getAdapterPosition());
        prefEdit.commit();

        int itemPosition = getAdapterPosition();
        intent.putExtra(imgName, itemPosition);
        view.getContext().startActivity(intent);
    }
}
