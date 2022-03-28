package com.example.a15017498.clashroyale2ndtime;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by 15017498 on 21/3/2017.
 */

public class RecyclerViewAdapterDeck extends RecyclerView.Adapter<RecyclerViewHoldersDeck> {

        //public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> implements Filterable {
        private List<ItemObject> itemList; //List // this contains the whole list
        private Context context;
        private List<ItemObject> itemList2; //Original List, this contains the filtered results
        String imgName;

    public RecyclerViewAdapterDeck(Context context,List<ItemObject> itemList,String imgName) {
            this.itemList2 = itemList;
            this.itemList = itemList;
            this.context = context;
            this.imgName = imgName;
        }

        @Override
        public RecyclerViewHoldersDeck onCreateViewHolder(ViewGroup parent, int viewType) {

            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list, null);
            RecyclerViewHoldersDeck rcv = new RecyclerViewHoldersDeck(layoutView,imgName);
            return rcv;
        }

    @Override
    public void onBindViewHolder(RecyclerViewHoldersDeck holder, int position) {
        holder.countryPhoto.setImageResource(itemList.get(position).getPhoto());
    }

        @Override
        public int getItemCount() {
            return this.itemList.size();
        }




    }

