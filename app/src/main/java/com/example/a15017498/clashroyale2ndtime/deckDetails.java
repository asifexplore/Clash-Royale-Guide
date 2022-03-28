package com.example.a15017498.clashroyale2ndtime;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class deckDetails extends AppCompatActivity {

    Toolbar toolbar;
    FragmentManager fm;
    String index_name;
    DatabaseReference mDatabase;
    String card1,card2,card3,card4,card5,card6,card7,card8;
    ImageView img1,img2,img3,img4,img5,img6,img7,img8;
    RecyclerView DeckList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_details);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        Intent intentReceived4 = getIntent();
        String deck_id = intentReceived4.getStringExtra("blog_id");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimaryDark)));
        getSupportActionBar().setTitle(deck_id);

        index_name = deck_id;
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Deck").child(index_name);

        // Read from the database
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String c1 = (String) dataSnapshot.child("c1").getValue();
                String c2 = (String) dataSnapshot.child("c2").getValue();
                String c3 = (String) dataSnapshot.child("c3").getValue();
                String c4 = (String) dataSnapshot.child("c4").getValue();
                String c5 = (String) dataSnapshot.child("c5").getValue();
                String c6 = (String) dataSnapshot.child("c6").getValue();
                String c7 = (String) dataSnapshot.child("c7").getValue();
                String c8 = (String) dataSnapshot.child("c8").getValue();

                //String value = dataSnapshot.getValue(String.class);
                Log.d("Error", "Value is: " + c1);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Error", "Failed to read value.", error.toException());
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch ((item.getItemId())){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
