package com.example.a15017498.clashroyale2ndtime;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class cardGamePlay extends Fragment {

    WebView webView;
    String cons;
    TextView textviewCons;
    DatabaseReference myRef;
    String index_name;

    public cardGamePlay() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card_game_play, container, false);

        textviewCons = (TextView) view.findViewById(R.id.textviewCons);

        myRef = FirebaseDatabase.getInstance().getReference().child("Deck");

//        webView = (WebView) view.findViewById(R.id.webView);
//        webView.getSettings().setJavaScriptEnabled(true);
//        String vid1st = "<html><body>Loading Youtube Video<br/>";
//        String last = "</body></html>";
//        String video = vid1st+pos+last;
//        String playVideo ="<html><body>Loading Youtube Video<br/><iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/SZ6odQfu47E\" frameborder=\"0\" allowfullscreen></iframe></body></html>";
//        webView.loadData(playVideo, "text/html", "utf-8");

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
                cons = (String) dataSnapshot.child("Defence").getValue();
                textviewCons.setText(cons);
//                cons = (String) dataSnapshot.child("Defence").getValue();
//                textviewCons.setText(cons);
                Log.d("rip", "Value is: " + cons);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("rip", "Failed to read value.", error.toException());
            }
        });

    }
}
