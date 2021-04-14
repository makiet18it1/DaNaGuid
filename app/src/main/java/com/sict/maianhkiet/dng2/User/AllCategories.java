package com.sict.maianhkiet.dng2.User;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sict.maianhkiet.dng2.HomeAdapter.CategoryAdapter;
import com.sict.maianhkiet.dng2.Model.Category;
import com.sict.maianhkiet.dng2.R;

import java.util.ArrayList;
import java.util.List;


public class AllCategories extends AppCompatActivity {

    RecyclerView categoryrecyclerView;
    CategoryAdapter adapter;
    ImageView backPress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_categories);
        backPress = findViewById(R.id.back_pressed);
        backPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AllCategories.this, UserDashboard.class);
                startActivity(i);
            }
        });

        categoryrecyclerView = findViewById(R.id.category_recycler_all_categories);
        categoryrecyclerView.setHasFixedSize(true);
        categoryrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseDatabase.getInstance().getReference("Category").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Category> categories = new ArrayList<>();
                for (DataSnapshot dataSnapshot :
                    snapshot.getChildren()) {
                    categories.add(dataSnapshot.getValue(Category.class));
                }
                adapter = new CategoryAdapter(categories, AllCategories.this);
                categoryrecyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
