package com.example.a15017498.clashroyale2ndtime;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class deckDetailsConfirmed extends AppCompatActivity {
    Toolbar toolbar;
    ImageView img1,img2,img3,img4,img5,img6,img7,img8;
    FragmentManager fm;
    String c1,c2,c3,c4,c5,c6,c7,c8;
    DatabaseReference mDatabase;
    String index_name;
    Button btn6,btn7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_details_confirmed);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        Intent intentReceived4 = getIntent();
        String deck_id = intentReceived4.getStringExtra("blog_id");
        index_name = deck_id;
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Deck").child(index_name);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimaryDark)));
        getSupportActionBar().setTitle(deck_id);


        img1 = (ImageView) findViewById(R.id.imageView2);
        img2 = (ImageView) findViewById(R.id.imageView3);
        img3 = (ImageView) findViewById(R.id.imageView4);
        img4 = (ImageView) findViewById(R.id.imageView5);
        img5 = (ImageView) findViewById(R.id.imageView6);
        img6 = (ImageView) findViewById(R.id.imageView7);
        img7 = (ImageView) findViewById(R.id.imageView8);
        img8 = (ImageView) findViewById(R.id.imageView9);

        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);

        fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        CardTips empty = new CardTips();

        transaction.add(R.id.fragmentPlaceholder,empty);
        transaction.commit();


    }

    @Override
    protected void onStart() {
        super.onStart();

        // Read from the database
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                c1 = (String) dataSnapshot.child("c1").getValue();
                c2 = (String) dataSnapshot.child("c2").getValue();
                 c3 = (String) dataSnapshot.child("c3").getValue();
                 c4 = (String) dataSnapshot.child("c4").getValue();
                 c5 = (String) dataSnapshot.child("c5").getValue();
                 c6 = (String) dataSnapshot.child("c6").getValue();
                 c7 = (String) dataSnapshot.child("c7").getValue();
                 c8 = (String) dataSnapshot.child("c8").getValue();

                //String value = dataSnapshot.getValue(String.class);
                Log.d("Error", "Value is: " + c1);

                int id1 = getResources().getIdentifier(c1,"drawable",getPackageName());
                img1.setImageResource(id1);

                int id2 = getResources().getIdentifier(c2, "drawable", getPackageName());
                img2.setImageResource(id2);

                int id3 = getResources().getIdentifier(c3, "drawable",getPackageName());
                img3.setImageResource(id3);

                int id4 = getResources().getIdentifier(c4, "drawable", getPackageName());
                img4.setImageResource(id4);

                int id5 = getResources().getIdentifier(c5, "drawable",getPackageName());
                img5.setImageResource(id5);

                int id6 = getResources().getIdentifier(c6, "drawable", getPackageName());
                img6.setImageResource(id6);

                int id7 = getResources().getIdentifier(c7, "drawable", getPackageName());
                img7.setImageResource(id7);

                int id8 = getResources().getIdentifier(c8, "drawable", getPackageName());
                img8.setImageResource(id8);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Error", "Failed to read value.", error.toException());
            }
        });
    }
    public void onSelectFragment(View view){
        Log.d("OTW", "This is my message");
        Fragment newFragment;

        if(view ==  findViewById(R.id.button6)){
            //Setting the fragment to be the respective
            newFragment = new CardTips();
            // Creating argument, to send the "name" of the character
            Bundle  arguments = new Bundle();
            arguments.putString("index_name" ,index_name);
            newFragment.setArguments(arguments);

        }else if(view == findViewById(R.id.button7)){
            //Setting the fragment to be the respective
            newFragment = new cardGamePlay();
            // Creating argument, to send the "name" of the character
            Bundle  arguments = new Bundle();
            arguments.putString("index_name" ,index_name);
            newFragment.setArguments(arguments);

        }else{
            newFragment = new CardTips();
        }
        FragmentTransaction transactions = getSupportFragmentManager().beginTransaction();
        transactions.replace(R.id.fragmentPlaceholder,newFragment);
        transactions.addToBackStack(null);
        transactions.commit();
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
