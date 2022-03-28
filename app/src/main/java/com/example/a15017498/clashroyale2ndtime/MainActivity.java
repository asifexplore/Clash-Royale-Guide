package com.example.a15017498.clashroyale2ndtime;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.a15017498.clashroyale2ndtime.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity    {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // This toolbar is used for the FinalStudentPlanner header
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        This 1 to initalize drawerLayout
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        // Action bar for the hamburger sign
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);

        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        // Need this line, it is something like linking (Where we use findViewById(R.id.  ))
        fragmentTransaction =getSupportFragmentManager().beginTransaction();
        // This is linking the fragmentTransaction to Task Fragment
        fragmentTransaction.add(R.id.main_container,new cardFragment());
        fragmentTransaction.commit();
        // Changes the header of the app in the phone
        getSupportActionBar().setTitle("Cards");
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Task:


                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new cardFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Cards");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;


                    case R.id.Class:

                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new deckFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Decks");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.Schedule:


                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new tipsFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Tips");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;



                case R.id.About_Us:


                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_container,new aboutUs());
                fragmentTransaction.commit();
                getSupportActionBar().setTitle("About Us");
                item.setChecked(true);
                drawerLayout.closeDrawers();
                break;

            }
                return true;

            }
        });
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
//        Check if the side menu is closed or open once the activity is restored
        actionBarDrawerToggle.syncState();
    }

}
