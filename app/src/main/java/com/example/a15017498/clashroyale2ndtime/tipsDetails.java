package com.example.a15017498.clashroyale2ndtime;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class tipsDetails extends AppCompatActivity {

    Toolbar toolbar;
    DatabaseReference mDatabase;
    TextView textViewTitle;
    TextView textViewBody;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_details);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        Intent intentReceived4=getIntent();
        String intentName = intentReceived4.getStringExtra("btnName");

        imgView = (ImageView) findViewById(R.id.imgTips);

        if (intentName.equalsIgnoreCase("Gems")){
            int id = getResources().getIdentifier("gems", "drawable", getPackageName());
            imgView.setImageResource(id);
        }else{

        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimaryDark)));
        getSupportActionBar().setTitle(intentName);

        textViewTitle = (TextView) findViewById(R.id.TipsTitle);
        textViewBody = (TextView) findViewById(R.id.TipsDetails);




        mDatabase = FirebaseDatabase.getInstance().getReference().child("Tip").child(intentName);

        // Read from the database
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String title = (String) dataSnapshot.child("Title").getValue();
                String body = (String) dataSnapshot.child("Body").getValue();

                textViewTitle.setText(title);
                textViewBody.setText(body);
                Log.d("Success", "Value is: " + title);
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
