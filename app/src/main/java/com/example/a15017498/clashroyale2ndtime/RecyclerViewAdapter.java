package com.example.a15017498.clashroyale2ndtime;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

/**
 * Created by 15017498 on 12/3/2017.
 */
// Need to implement Filterable
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> implements Filterable  {
    //public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> implements Filterable {
    private List<ItemObject> itemList; //List // this contains the whole list
    private Context context;
    private List<ItemObject> itemList2; //Original List, this contains the filtered results
    private List<ItemObject> itemList3;


    public RecyclerViewAdapter(Context context,List<ItemObject> itemList) {
        this.itemList2 = itemList;
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView,itemList3);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.countryPhoto.setImageResource(itemList.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                //After getting the results, then it displays the results
                itemList = (List<ItemObject>) results.values;
                itemList3 = itemList;

                RecyclerViewAdapter.this.notifyDataSetChanged();

            }



            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List<ItemObject> filteredResults = null;
                if (constraint.length() == 0) {
                    // If the search is empty, it displays the entire list
                    filteredResults = itemList2;
                } else {
                    // Gets the name then it searches throughout the list
                    filteredResults = getFilteredResults(constraint.toString().toLowerCase());
                }

                FilterResults results = new FilterResults();
                results.values = filteredResults;

                return results;
            }
        };
    }
    protected List<ItemObject> getFilteredResults(String constraint) {
        List<ItemObject> results = new ArrayList<>();
        // Loop through to search for the name written
        for (ItemObject item : itemList2) {
            if (item.getName().toLowerCase().contains(constraint)) {
                results.add(item);
            }
        }
        return results;
    }


}
