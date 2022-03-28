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
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static java.security.AccessController.getContext;

public class cardDetails extends AppCompatActivity {

    Toolbar toolbar;
    String gob;
    ImageView imageView;
    TextView textViewDEsc;
    DatabaseReference mDatabase;


    String[] card_names = {"Mirror","Ice Spirit","Skeletons","Fire Spirits","Log","Goblin","Rage Spell","Ice Golem","Spear Goblin","Zap"
            ,"Ice Wizard", "Archers","Minions","Clone","Mega Minion","Tornado","Skeleton Army","Bomber","Knight","Goblin Barrel","Arrow"
            ,"Tombstone","Cannon","Goblin Gang","Dart Goblin","Miner","Princess","Guards","Lumberjack","Electro Wizard","Fireball",
            "Dark Prince","Valkyrie","Poison","Musketeer","Hog Rider","Freeze Spell","Baby Dragon","Battle Ram","Inferno Dragon",
            "Furnace","Tesla","Mortar","Mini P.E.K.K.A","Executioner","Witch","Graveyard","Goblin Hut","Inferno Tower","Bomb Tower",
            "Minion Horde","Wizard","Prince","Giant","Bowler","Balloon","Barbarians","Royal Giant","Sparky","Elite Barbarians",
            "Giant Skeleton","Elixir Collector","X-Bow","Rocket","Lightning","Barbarian Hut","P.E.K.K.A","Lava Hound","Golem",
            "Three Musketeers"};

    String[] card_names2 = {"mirror","icespirit","skeletons","spirits_of_fire","log","goblins",
            "rage","ice_golem","spear_goblins","zap","ice_wizard", "archers","minions",
            "clone","mega_minion","tornado","skeleton_army","bomber","knight","goblin_barrel","arrows",
            "tombstone","cannon","goblin_gng","darts","miner","princesse","guardes","lumberjack","electro","fireball",
            "dark_prince","valkyrie","poison","musketeer","hog_rider","freeze","baby_dragon","battle_ram","inferno_drag",
            "fournaise","tesla","mortar","minipekka","executioner","witch","graveyard","goblin_hut","inferno_tower","bomb_tower",
            "minion_horde","wizard","prince","giant","bowler","balloon","barbarians","royal_giant","sparky","elite_barb",
            "giant_skeleton","elixir_collector","x_bow","rocket","lightning","barbarian_hut","pekka_","lava_hound","golem",
            "three_masketeer"};

    int[] card_pics = {R.drawable.mirror,R.drawable.icespirit,R.drawable.skeletons,R.drawable.spirits_of_fire,R.drawable.log,R.drawable.goblins,
            R.drawable.rage,R.drawable.ice_golem,R.drawable.spear_goblins,R.drawable.zap,R.drawable.ice_wizard,R.drawable.archers,R.drawable.minions,
            R.drawable.clone,R.drawable.mega_minion,R.drawable.tornado,R.drawable.skeleton_army,R.drawable.bomber,R.drawable.knight,R.drawable.goblin_barrel,R.drawable.arrows,
            R.drawable.tombstone,R.drawable.cannon,R.drawable.goblin_gng,R.drawable.darts,R.drawable.miner,R.drawable.princesse,R.drawable.guardes,R.drawable.lumberjack,R.drawable.electro,R.drawable.fireball,
            R.drawable.dark_prince,R.drawable.valkyrie,R.drawable.poison,R.drawable.musketeer,R.drawable.hog_rider,R.drawable.freeze,R.drawable.baby_dragon,R.drawable.battle_ram,R.drawable.inferno_drag,
            R.drawable.fournaise,R.drawable.tesla,R.drawable.mortar,R.drawable.minipekka,R.drawable.executioner,R.drawable.witch,R.drawable.graveyard,R.drawable.goblin_hut,R.drawable.inferno_tower,R.drawable.bomb_tower,
            R.drawable.minion_horde,R.drawable.wizard,R.drawable.prince,R.drawable.giant,R.drawable.bowler,R.drawable.balloon,R.drawable.barbarians,R.drawable.royal_giant,R.drawable.sparky,R.drawable.elite_barb,
            R.drawable.giant_skeleton,R.drawable.elixir_collector,R.drawable.x_bow,R.drawable.rocket,R.drawable.lightning,R.drawable.barbarian_hut,R.drawable.pekka_,R.drawable.lava_hound,R.drawable.golem,
            R.drawable.three_masketeer};

    int position_num = 0;
   int location_num = 0;
    String card_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_details);

        imageView = (ImageView) findViewById(R.id.imageView);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        textViewDEsc = (TextView) findViewById(R.id.textViewDEsc);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Character");

        Intent intentReceived4 = getIntent();
        position_num = intentReceived4.getIntExtra("position",0);
        location_num = intentReceived4.getIntExtra("location",0);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimaryDark)));
        if(position_num == 0){
            getSupportActionBar().setTitle(card_names[location_num]);
            gob = card_names2[location_num];
            card_name = card_names[location_num];
        }else if(location_num == 0){
            //this works fine
            getSupportActionBar().setTitle(card_names[position_num]);
            gob = card_names2[position_num];
            card_name = card_names[position_num];
        }else{

        }

//      Dynamically Set the Image of the character
        int id = getResources().getIdentifier(gob, "drawable", getPackageName());
        imageView.setImageResource(id);

        // Read from the database
        mDatabase.child(card_name).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
              String pros = (String) dataSnapshot.child("Pros").getValue();
                textViewDEsc.setText(pros);

                Log.d("Success", "Value is: " + pros);
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
