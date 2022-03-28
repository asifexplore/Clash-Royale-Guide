package com.example.a15017498.clashroyale2ndtime;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class choosing_card extends AppCompatActivity {

    private GridLayoutManager lLayout;
    Toolbar toolbar;
    RecyclerViewAdapterDeck rcAdapter;
    RecyclerView rView;
    List<ItemObject> rowListItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosing_card);

        rowListItem = getAllItemList();
        lLayout = new GridLayoutManager(getApplicationContext(), 4);

        //For the toolbar codes
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //Allow toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimaryDark)));
        getSupportActionBar().setTitle("Select a Card");

        Intent intentReceived4=getIntent();
        String imgName = intentReceived4.getStringExtra("imgNumber");


        rView = (RecyclerView) findViewById(R.id.recycler_viewDeckCr8);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        rcAdapter = new RecyclerViewAdapterDeck(getApplicationContext(),rowListItem, imgName);
        rView.setAdapter(rcAdapter);

    }

    //List of characters in the game
    private List<ItemObject> getAllItemList(){

        ArrayList<ItemObject> allItems = new ArrayList<ItemObject>();
        // 1 Elixir
        allItems.add(new ItemObject("Mirror", R.drawable.mirror,1));
        allItems.add(new ItemObject("Ice Spirit", R.drawable.icespirit,2));
        allItems.add(new ItemObject("Skeletons", R.drawable.skeletons,3));
        // 2 Elixir
        allItems.add(new ItemObject("Fire Spirits", R.drawable.spirits_of_fire,4));
        allItems.add(new ItemObject("Log", R.drawable.log,5));
        allItems.add(new ItemObject("Goblin", R.drawable.goblins,6));
        allItems.add(new ItemObject("Rage Spell", R.drawable.rage,7));
        allItems.add(new ItemObject("Ice Golem", R.drawable.ice_golem,8));
        allItems.add(new ItemObject("Spear Goblin", R.drawable.spear_goblins,9));
        allItems.add(new ItemObject("Zap", R.drawable.zap,10));
        // 3 Elixir
        allItems.add(new ItemObject("Ice Wizard", R.drawable.ice_wizard,11));
        allItems.add(new ItemObject("Archers", R.drawable.archers,11));
        allItems.add(new ItemObject("Minions", R.drawable.minions,12));
        allItems.add(new ItemObject("Clone", R.drawable.clone,13));
        allItems.add(new ItemObject("Mega Minion", R.drawable.mega_minion,14));
        allItems.add(new ItemObject("Tornado", R.drawable.tornado,15));
        allItems.add(new ItemObject("Skeleton Army", R.drawable.skeleton_army,16));
        allItems.add(new ItemObject("Bomber", R.drawable.bomber,17));
        allItems.add(new ItemObject("Knight", R.drawable.knight,18));
        allItems.add(new ItemObject("Goblin Barrel", R.drawable.goblin_barrel,19));
        allItems.add(new ItemObject("Arrow", R.drawable.arrows,20));
        allItems.add(new ItemObject("Tombstone", R.drawable.tombstone,21));
        allItems.add(new ItemObject("Cannon", R.drawable.cannon,22));
        allItems.add(new ItemObject("Goblin Gang", R.drawable.goblin_gng,23));
        allItems.add(new ItemObject("Dart Goblin", R.drawable.darts,24));
        allItems.add(new ItemObject("Miner", R.drawable.miner,25));
        allItems.add(new ItemObject("Princess", R.drawable.princesse,26));
        allItems.add(new ItemObject("Guards", R.drawable.guardes,27));
        // 4 Elixir
        allItems.add(new ItemObject("Lumberjack", R.drawable.lumberjack,28));
        allItems.add(new ItemObject("Electro Wizard", R.drawable.electro,29));
        allItems.add(new ItemObject("Fireball", R.drawable.fireball,30));
        allItems.add(new ItemObject("Dark Prince", R.drawable.dark_prince,31));
        allItems.add(new ItemObject("Valkyrie", R.drawable.valkyrie,32));
        allItems.add(new ItemObject("Poison", R.drawable.poison,33));
        allItems.add(new ItemObject("Musketeer", R.drawable.musketeer,34));
        allItems.add(new ItemObject("Hog Rider", R.drawable.hog_rider,35));
        allItems.add(new ItemObject("Freeze Spell", R.drawable.freeze,36));
        allItems.add(new ItemObject("Baby Dragon", R.drawable.baby_dragon,37));
        allItems.add(new ItemObject("Battle Ram", R.drawable.battle_ram,38));
        allItems.add(new ItemObject("Inferno Dragon", R.drawable.inferno_drag,39));
        allItems.add(new ItemObject("Furnace", R.drawable.fournaise,40));
        allItems.add(new ItemObject("Tesla", R.drawable.tesla,41));
        allItems.add(new ItemObject("Mortar", R.drawable.mortar,42));
        allItems.add(new ItemObject("Mini P.E.K.K.A", R.drawable.minipekka,43));
        // 5 Elixir
        allItems.add(new ItemObject("Executioner", R.drawable.executioner,44));
        allItems.add(new ItemObject("Witch", R.drawable.witch,45));
        allItems.add(new ItemObject("Graveyard", R.drawable.graveyard,46));
        allItems.add(new ItemObject("Goblin Hut", R.drawable.goblin_hut,47));
        allItems.add(new ItemObject("Inferno Tower", R.drawable.inferno_tower,48));
        allItems.add(new ItemObject("Bomb Tower", R.drawable.bomb_tower,49));
        allItems.add(new ItemObject("Minion Horde", R.drawable.minion_horde,50));
        allItems.add(new ItemObject("Wizard", R.drawable.wizard,51));
        allItems.add(new ItemObject("Prince", R.drawable.prince,52));
        allItems.add(new ItemObject("Giant", R.drawable.giant,53));
        allItems.add(new ItemObject("Bowler", R.drawable.bowler,54));
        allItems.add(new ItemObject("Balloon", R.drawable.balloon,55));
        allItems.add(new ItemObject("Barbarians", R.drawable.barbarians,56));
        // 6 Elixir
        allItems.add(new ItemObject("Royal Giant", R.drawable.royal_giant,57));
        allItems.add(new ItemObject("Sparky", R.drawable.sparky,58));
        allItems.add(new ItemObject("Elite Barbarians", R.drawable.elite_barb,59));
        allItems.add(new ItemObject("Giant Skeleton", R.drawable.giant_skeleton,60));
        allItems.add(new ItemObject("Elixir Collector", R.drawable.elixir_collector,61));
        allItems.add(new ItemObject("X-Bow", R.drawable.x_bow,62));
        allItems.add(new ItemObject("Rocket", R.drawable.rocket,63));
        allItems.add(new ItemObject("Lightning", R.drawable.lightning,64));
        // 7 Elixir
        allItems.add(new ItemObject("Barbarian Hut", R.drawable.barbarian_hut,65));
        allItems.add(new ItemObject("P.E.K.K.A", R.drawable.pekka_,66));
        allItems.add(new ItemObject("Lava Hound", R.drawable.lava_hound,67));
        // 8 Elixir
        allItems.add(new ItemObject("Golem", R.drawable.golem,68));
        // 9 Elixir
        allItems.add(new ItemObject("Three Musketeers", R.drawable.three_masketeer,69));

        return allItems;
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
