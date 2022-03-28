package com.example.a15017498.clashroyale2ndtime;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class uploadDeck extends AppCompatActivity {

    ImageView img1,img2,img3,img4,img5,img6,img7,img8;
    TextView textViewTitle;
    TextView textViewBody;
    Toolbar toolbar;
    Button btnSubmit;
    private DatabaseReference mDatabase;

    private ProgressDialog progressDialog;

    String[] card_names2 = {"mirror","icespirit","skeletons","spirits_of_fire","log","goblins",
            "rage","ice_golem","spear_goblins","zap","ice_wizard", "archers","minions",
            "clone","mega_minion","tornado","skeleton_army","bomber","knight","goblin_barrel","arrows",
            "tombstone","cannon","goblin_gng","darts","miner","princesse","guardes","lumberjack","electro","fireball",
            "dark_prince","valkyrie","poison","musketeer","hog_rider","freeze","baby_dragon","battle_ram","inferno_drag",
            "fournaise","tesla","mortar","minipekka","executioner","witch","graveyard","goblin_hut","inferno_tower","bomb_tower",
            "minion_horde","wizard","prince","giant","bowler","balloon","barbarians","royal_giant","sparky","elite_barb",
            "giant_skeleton","elixir_collector","x_bow","rocket","lightning","barbarian_hut","pekka_","lava_hound","golem",
            "three_masketeer"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_deck);

        img1 = (ImageView) findViewById(R.id.upload1);
        img2 = (ImageView) findViewById(R.id.upload2);
        img3 = (ImageView) findViewById(R.id.upload3);
        img4 = (ImageView) findViewById(R.id.upload4);
        img5 = (ImageView) findViewById(R.id.upload5);
        img6 = (ImageView) findViewById(R.id.upload6);
        img7 = (ImageView) findViewById(R.id.upload7);
        img8 = (ImageView) findViewById(R.id.upload8);

        textViewTitle = (TextView) findViewById(R.id.textViewTitle);
        textViewBody = (TextView) findViewById(R.id.textViewBody);
        btnSubmit = (Button) findViewById(R.id.button4);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Upload");

        //For the toolbar codes
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //Allow toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimaryDark)));
        getSupportActionBar().setTitle("Uploading Deck");




        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),choosing_card.class);
                intent.putExtra("imgNumber","img1");
                startActivity(intent);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),choosing_card.class);
                intent.putExtra("imgNumber","img2");
                startActivity(intent);
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),choosing_card.class);
                intent.putExtra("imgNumber","img3");
                startActivity(intent);
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),choosing_card.class);
                intent.putExtra("imgNumber","img4");
                startActivity(intent);
            }
        });

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),choosing_card.class);
                intent.putExtra("imgNumber","img5");
                startActivity(intent);
            }
        });

        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),choosing_card.class);
                intent.putExtra("imgNumber","img6");
                startActivity(intent);
            }
        });

        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),choosing_card.class);
                intent.putExtra("imgNumber","img7");
                startActivity(intent);
            }
        });

        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),choosing_card.class);
                intent.putExtra("imgNumber","img8");
                startActivity(intent);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title = textViewTitle.getText().toString().trim();
                String body = textViewBody.getText().toString().trim();

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                int imgNumber1 = prefs.getInt("img1",0);
                int imgNumber2 = prefs.getInt("img2",0);
                int imgNumber3 = prefs.getInt("img3",0);
                int imgNumber4 = prefs.getInt("img4",0);
                int imgNumber5 = prefs.getInt("img5",0);
                int imgNumber6 = prefs.getInt("img6",0);
                int imgNumber7 = prefs.getInt("img7",0);
                int imgNumber8 = prefs.getInt("img8",0);

                String imgName1 = card_names2[imgNumber1];
                String imgName2 = card_names2[imgNumber2];
                String imgName3 = card_names2[imgNumber3];
                String imgName4 = card_names2[imgNumber4];
                String imgName5 = card_names2[imgNumber5];
                String imgName6 = card_names2[imgNumber6];
                String imgName7 = card_names2[imgNumber7];
                String imgName8 = card_names2[imgNumber8];

                if(!TextUtils.isEmpty(title) && !TextUtils.isEmpty(body)){

                    //adding inside the database
                    DatabaseReference newPost = mDatabase.push();
                    newPost.child("title").setValue(title);
                    newPost.child("body").setValue(body);
                    newPost.child("c1").setValue(imgName1);
                    newPost.child("c2").setValue(imgName2);
                    newPost.child("c3").setValue(imgName3);
                    newPost.child("c4").setValue(imgName4);
                    newPost.child("c5").setValue(imgName5);
                    newPost.child("c6").setValue(imgName6);
                    newPost.child("c7").setValue(imgName7);
                    newPost.child("c8").setValue(imgName8);
                    //after this the adding is completed

                    //Intent back to deckPage
                    Intent intent = new Intent(getBaseContext(),MainActivity.class);
                    startActivity(intent);

                }
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //First image
        int imgNumber1 = prefs.getInt("img1",0);
        //      Dynamically Set the Image of the character
        int id1 = getResources().getIdentifier(card_names2[imgNumber1], "drawable", getPackageName());
        img1.setImageResource(id1);

        //Second image
        int imgNumber2 = prefs.getInt("img2",0);
        //      Dynamically Set the Image of the character
        int id2 = getResources().getIdentifier(card_names2[imgNumber2], "drawable", getPackageName());
        img2.setImageResource(id2);

        //First image
        int imgNumber3 = prefs.getInt("img3",0);
        //      Dynamically Set the Image of the character
        int id3 = getResources().getIdentifier(card_names2[imgNumber3], "drawable", getPackageName());
        img3.setImageResource(id3);

        //First image
        int imgNumber4 = prefs.getInt("img4",0);
        //      Dynamically Set the Image of the character
        int id4 = getResources().getIdentifier(card_names2[imgNumber4], "drawable", getPackageName());
        img4.setImageResource(id4);


        //First image
        int imgNumber5 = prefs.getInt("img5",0);
        //      Dynamically Set the Image of the character
        int id5 = getResources().getIdentifier(card_names2[imgNumber5], "drawable", getPackageName());
        img5.setImageResource(id5);

        //First image
        int imgNumber6 = prefs.getInt("img6",0);
        //      Dynamically Set the Image of the character
        int id6 = getResources().getIdentifier(card_names2[imgNumber6], "drawable", getPackageName());
        img6.setImageResource(id6);

        //First image
        int imgNumber7 = prefs.getInt("img7",0);
        //      Dynamically Set the Image of the character
        int id7 = getResources().getIdentifier(card_names2[imgNumber7], "drawable", getPackageName());
        img7.setImageResource(id7);

        //First image
        int imgNumber8 = prefs.getInt("img8",0);
        //      Dynamically Set the Image of the character
        int id8 = getResources().getIdentifier(card_names2[imgNumber8], "drawable", getPackageName());
        img8.setImageResource(id8);

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
