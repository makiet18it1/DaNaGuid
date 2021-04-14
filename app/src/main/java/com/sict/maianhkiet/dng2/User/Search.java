package com.sict.maianhkiet.dng2.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

public class Search extends AppCompatActivity {

    RecyclerView allviewrecyclerview;
    MostViewedAdapter adapter1;
    ImageView backPress;
    EditText edts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        backPress=findViewById(R.id.back_pressed);
        backPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Search.this,UserDashboard.class);
                startActivity(i);
            }
        });

        edts = findViewById(R.id.etd_search);
//        edts.setKeyListener(null);

        allviewrecyclerview = findViewById(R.id.search_recycler);
        allviewrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        FirebaseDatabase.getInstance().getReference("View").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<AllviewM> allView = new ArrayList<>();
                for (DataSnapshot dataSnapshot :
                    snapshot.getChildren()){
                    allView.add(dataSnapshot.getValue(AllviewM.class));
                }
                adapter1 = new MostViewedAdapter(allView, Search.this);
                allviewrecyclerview.setAdapter(adapter1);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}






