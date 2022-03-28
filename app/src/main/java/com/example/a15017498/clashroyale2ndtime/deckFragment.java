package com.example.a15017498.clashroyale2ndtime;


import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class deckFragment extends Fragment {

    Toolbar toolbar;
    private RecyclerView DeckList;
    private DatabaseReference mDatabase;


    public deckFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_deck, container, false);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Deck");

        //For the toolbar codes
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        //Allow toolbar
        setHasOptionsMenu(true);

        DeckList = (RecyclerView) view.findViewById(R.id.recycler_viewDeck);
        DeckList.setHasFixedSize(true);
        DeckList.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Deck,BlogViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Deck, BlogViewHolder>(
                Deck.class,R.layout.decklist_layout,BlogViewHolder.class,mDatabase
        ) {
            @Override
            protected void populateViewHolder(BlogViewHolder viewHolder, Deck model, int position) {
                final String post_key = getRef(position).getKey();
                viewHolder.setDeckName(model.getDeckName());
                viewHolder.setImage(getActivity().getApplicationContext(),model.getC1(),model.getC2(),model.getC3(),model.getC4(),model.getC5(),model.getC6(),model.getC7(),model.getC8());
                viewHolder.mview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getActivity().getApplicationContext(), deckDetailsConfirmed.class);
                        intent.putExtra("blog_id",post_key);
                        startActivity(intent);
                    }
                });
            }
        };
        DeckList.setAdapter(firebaseRecyclerAdapter);
    }

    public static class BlogViewHolder extends RecyclerView.ViewHolder {

        View mview;

        public BlogViewHolder(View itemView) {
            super(itemView);
            mview = itemView;
        }

        public void setDeckName(String name) {
            TextView textView = (TextView) itemView.findViewById(R.id.textView);
            textView.setText(name);
        }

        public void setImage(Context ctx, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8) {
            ImageView c1I = (ImageView) itemView.findViewById(R.id.c1);
            ImageView c2I = (ImageView) itemView.findViewById(R.id.c2);
            ImageView c3I = (ImageView) itemView.findViewById(R.id.c3);
            ImageView c4I = (ImageView) itemView.findViewById(R.id.c4);
            ImageView c5I = (ImageView) itemView.findViewById(R.id.c5);
            ImageView c6I = (ImageView) itemView.findViewById(R.id.c6);
            ImageView c7I = (ImageView) itemView.findViewById(R.id.c7);
            ImageView c8I = (ImageView) itemView.findViewById(R.id.c8);

            //      Dynamically Set the Image of the character
            int id1 = itemView.getResources().getIdentifier(c1, "drawable", itemView.getContext().getPackageName());
            c1I.setImageResource(id1);

            int id2 = itemView.getResources().getIdentifier(c2, "drawable", itemView.getContext().getPackageName());
            c2I.setImageResource(id2);

            int id3 = itemView.getResources().getIdentifier(c3, "drawable", itemView.getContext().getPackageName());
            c3I.setImageResource(id3);

            int id4 = itemView.getResources().getIdentifier(c4, "drawable", itemView.getContext().getPackageName());
            c4I.setImageResource(id4);

            int id5 = itemView.getResources().getIdentifier(c5, "drawable", itemView.getContext().getPackageName());
            c5I.setImageResource(id5);

            int id6 = itemView.getResources().getIdentifier(c6, "drawable", itemView.getContext().getPackageName());
            c6I.setImageResource(id6);

            int id7 = itemView.getResources().getIdentifier(c7, "drawable", itemView.getContext().getPackageName());
            c7I.setImageResource(id7);

            int id8 = itemView.getResources().getIdentifier(c8, "drawable", itemView.getContext().getPackageName());
            c8I.setImageResource(id8);

        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu,MenuInflater inflater) {
        inflater.inflate(R.menu.uploading,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.action_upload) {
            Intent intent=new Intent(getContext(),uploadDeck.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
