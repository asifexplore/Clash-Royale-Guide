package com.example.a15017498.clashroyale2ndtime;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class cardFragment extends Fragment implements SearchView.OnQueryTextListener {

    private GridLayoutManager lLayout;
    Toolbar toolbar;
    RecyclerViewAdapter rcAdapter;
    RecyclerView rView;
    List<ItemObject> rowListItem;


    public cardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card, container, false);

        rowListItem = getAllItemList();
        lLayout = new GridLayoutManager(getActivity().getApplicationContext(), 4);

        //For the toolbar codes
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        //Allow toolbar
        setHasOptionsMenu(true);

        rView = (RecyclerView) view.findViewById(R.id.recycler_view);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        rcAdapter = new RecyclerViewAdapter(getContext(),rowListItem);
        rView.setAdapter(rcAdapter);

        return view;
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
        allItems.add(new ItemObject("Archers", R.drawable.archers,12));
        allItems.add(new ItemObject("Minions", R.drawable.minions,13));
        allItems.add(new ItemObject("Clone", R.drawable.clone,14));
        allItems.add(new ItemObject("Mega Minion", R.drawable.mega_minion,15));
        allItems.add(new ItemObject("Tornado", R.drawable.tornado,16));
        allItems.add(new ItemObject("Skeleton Army", R.drawable.skeleton_army,17));
        allItems.add(new ItemObject("Bomber", R.drawable.bomber,18));
        allItems.add(new ItemObject("Knight", R.drawable.knight,19));
        allItems.add(new ItemObject("Goblin Barrel", R.drawable.goblin_barrel,20));
        allItems.add(new ItemObject("Arrow", R.drawable.arrows,21));
        allItems.add(new ItemObject("Tombstone", R.drawable.tombstone,22));
        allItems.add(new ItemObject("Cannon", R.drawable.cannon,23));
        allItems.add(new ItemObject("Goblin Gang", R.drawable.goblin_gng,24));
        allItems.add(new ItemObject("Dart Goblin", R.drawable.darts,25));
        allItems.add(new ItemObject("Miner", R.drawable.miner,26));
        allItems.add(new ItemObject("Princess", R.drawable.princesse,27));
        allItems.add(new ItemObject("Guards", R.drawable.guardes,28));
        // 4 Elixir
        allItems.add(new ItemObject("Lumberjack", R.drawable.lumberjack,29));
        allItems.add(new ItemObject("Electro Wizard", R.drawable.electro,30));
        allItems.add(new ItemObject("Fireball", R.drawable.fireball,31));
        allItems.add(new ItemObject("Dark Prince", R.drawable.dark_prince,32));
        allItems.add(new ItemObject("Valkyrie", R.drawable.valkyrie,33));
        allItems.add(new ItemObject("Poison", R.drawable.poison,34));
        allItems.add(new ItemObject("Musketeer", R.drawable.musketeer,35));
        allItems.add(new ItemObject("Hog Rider", R.drawable.hog_rider,36));
        allItems.add(new ItemObject("Freeze Spell", R.drawable.freeze,37));
        allItems.add(new ItemObject("Baby Dragon", R.drawable.baby_dragon,38));
        allItems.add(new ItemObject("Battle Ram", R.drawable.battle_ram,39));
        allItems.add(new ItemObject("Inferno Dragon", R.drawable.inferno_drag,40));
        allItems.add(new ItemObject("Furnace", R.drawable.fournaise,41));
        allItems.add(new ItemObject("Tesla", R.drawable.tesla,42));
        allItems.add(new ItemObject("Mortar", R.drawable.mortar,43));
        allItems.add(new ItemObject("Mini P.E.K.K.A", R.drawable.minipekka,44));
        // 5 Elixir
        allItems.add(new ItemObject("Executioner", R.drawable.executioner,45));
        allItems.add(new ItemObject("Witch", R.drawable.witch,46));
        allItems.add(new ItemObject("Graveyard", R.drawable.graveyard,47));
        allItems.add(new ItemObject("Goblin Hut", R.drawable.goblin_hut,48));
        allItems.add(new ItemObject("Inferno Tower", R.drawable.inferno_tower,49));
        allItems.add(new ItemObject("Bomb Tower", R.drawable.bomb_tower,50));
        allItems.add(new ItemObject("Minion Horde", R.drawable.minion_horde,51));
        allItems.add(new ItemObject("Wizard", R.drawable.wizard,52));
        allItems.add(new ItemObject("Prince", R.drawable.prince,53));
        allItems.add(new ItemObject("Giant", R.drawable.giant,54));
        allItems.add(new ItemObject("Bowler", R.drawable.bowler,55));
        allItems.add(new ItemObject("Balloon", R.drawable.balloon,56));
        allItems.add(new ItemObject("Barbarians", R.drawable.barbarians,57));
        // 6 Elixir
        allItems.add(new ItemObject("Royal Giant", R.drawable.royal_giant,58));
        allItems.add(new ItemObject("Sparky", R.drawable.sparky,59));
        allItems.add(new ItemObject("Elite Barbarians", R.drawable.elite_barb,60));
        allItems.add(new ItemObject("Giant Skeleton", R.drawable.giant_skeleton,61));
        allItems.add(new ItemObject("Elixir Collector", R.drawable.elixir_collector,62));
        allItems.add(new ItemObject("X-Bow", R.drawable.x_bow,63));
        allItems.add(new ItemObject("Rocket", R.drawable.rocket,64));
        allItems.add(new ItemObject("Lightning", R.drawable.lightning,65));
        // 7 Elixir
        allItems.add(new ItemObject("Barbarian Hut", R.drawable.barbarian_hut,66));
        allItems.add(new ItemObject("P.E.K.K.A", R.drawable.pekka_,67));
        allItems.add(new ItemObject("Lava Hound", R.drawable.lava_hound,68));
        // 8 Elixir
        allItems.add(new ItemObject("Golem", R.drawable.golem,69));
        // 9 Elixir
        allItems.add(new ItemObject("Three Musketeers", R.drawable.three_masketeer,70));

        return allItems;
    }

    //Creates the Search Icon
    @Override
    public void onCreateOptionsMenu(Menu menu,MenuInflater inflater) {

        inflater.inflate(R.menu.menu_main,menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint("Enter first letter only");

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        newText = newText.toLowerCase();
        ArrayList<ItemObject> newList = new ArrayList<>();
        for(ItemObject itemObject : rowListItem)
        {
            String name = itemObject.toString().toLowerCase();
            if(name.contains(newText)){
                newList.add(itemObject);
            }
        }

        rcAdapter.getFilter().filter(newText);
        return true;
    }


}
