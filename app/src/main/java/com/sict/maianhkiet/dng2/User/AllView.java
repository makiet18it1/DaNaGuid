package com.sict.maianhkiet.dng2.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sict.maianhkiet.dng2.HomeAdapter.MostViewedAdapter;
import com.sict.maianhkiet.dng2.Model.AllviewM;
import com.sict.maianhkiet.dng2.R;

import java.util.ArrayList;
import java.util.List;


public class AllView extends AppCompatActivity  {

    RecyclerView allviewrecyclerview;
    MostViewedAdapter adapter1;
    ImageView backPress, searchIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_view);

        backPress=findViewById(R.id.back_pressed);
        backPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AllView.this,UserDashboard.class);
                startActivity(i);
            }
        });

        searchIcon = findViewById(R.id.image_searchv);
        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent is = new Intent(AllView.this,Search.class);
                startActivity(is);
            }
        });

        allviewrecyclerview = findViewById(R.id.all_viewed_recycler);
        allviewrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        FirebaseDatabase.getInstance().getReference("View").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<AllviewM> allView = new ArrayList<>();
                for (DataSnapshot dataSnapshot :
                snapshot.getChildren()){
                    allView.add(dataSnapshot.getValue(AllviewM.class));
                }
                adapter1 = new MostViewedAdapter(allView, AllView.this);
                allviewrecyclerview.setAdapter(adapter1);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}




