package com.example.a15017498.clashroyale2ndtime;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class CardTips extends Fragment {
    TextView textviewPros;
    TextView textviewCons;
    String index_name;
    DatabaseReference myRef;
    String pos;
    String cons;
    String[] card_names = {"Mirror","Ice Spirit","Skeletons","Fire Spirits","Log","Goblin","Rage Spell","Ice Golem","Spear Goblin","Zap"
            ,"Ice Wizard", "Archers","Minions","Clone","Mega Minion","Tornado","Skeleton Army","Bomber","Knight","Goblin Barrel","Arrow"
            ,"Tombstone","Cannon","Goblin Gang","Dart Goblin","Miner","Princess","Guards","Lumberjack","Electro Wizard","Fireball",
            "Dark Prince","Valkyrie","Poison","Musketeer","Hog Rider","Freeze Spell","Baby Dragon","Battle Ram","Inferno Dragon",
            "Furnace","Tesla","Mortar","Mini P.E.K.K.A","Executioner","Witch","Graveyard","Goblin Hut","Inferno Tower","Bomb Tower",
            "Minion Horde","Wizard","Prince","Giant","Bowler","Balloon","Barbarians","Royal Giant","Sparky","Elite Barbarians",
            "Giant Skeleton","Elixir Collector","X-Bow","Rocket","Lightning","Barbarian Hut","P.E.K.K.A","Lava Hound","Golem",
            "Three Musketeers"};
    int index_num;
    String desired_string;

    public CardTips() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card_tips, container, false);

        textviewPros = (TextView) view.findViewById(R.id.textviewPros);
        textviewCons = (TextView) view.findViewById(R.id.textviewCons);

        myRef = FirebaseDatabase.getInstance().getReference().child("Deck");

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Intent intentReceived4 = getActivity().getIntent();
        index_name = intentReceived4.getStringExtra("blog_id");

        myRef.child(index_name).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                pos = (String) dataSnapshot.child("Push").getValue();
                textviewPros.setText(pos);
//                cons = (String) dataSnapshot.child("Defence").getValue();
//                textviewCons.setText(cons);
                Log.d("rip", "Value is: " + pos + " And value of Cons: "+cons);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("rip", "Failed to read value.", error.toException());
            }
        });

    }
}
