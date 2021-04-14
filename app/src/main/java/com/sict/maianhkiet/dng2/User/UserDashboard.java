package com.sict.maianhkiet.dng2.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sict.maianhkiet.dng2.HomeAdapter.CategoryAdapter;
import com.sict.maianhkiet.dng2.HomeAdapter.FeaturedAdapter;

import com.sict.maianhkiet.dng2.HomeAdapter.MostViewedAdapter;
import com.sict.maianhkiet.dng2.Model.AllviewM;
import com.sict.maianhkiet.dng2.Model.Category;
import com.sict.maianhkiet.dng2.Model.Feature;
import com.sict.maianhkiet.dng2.R;

import java.util.ArrayList;
import java.util.List;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private
    RecyclerView categoryrecyclerView, allviewrecyclerview, featuredrecyclerv ;
    CategoryAdapter adapter;
    MostViewedAdapter adapterv;
    FeaturedAdapter adapterf;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon, searchIcon;
    Button btnMv, btnCv;

    EditText edt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdashboard);


        //hooks
        searchIcon = findViewById(R.id.image_searchu);
        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent is = new Intent(UserDashboard.this,Search.class);
                startActivity(is);
            }
        });


        btnMv = findViewById(R.id.btnMv);
        btnCv = findViewById(R.id.btnCv);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuIcon = findViewById(R.id.menu_icon);
        edt = findViewById(R.id.edit_text);

        edt.setKeyListener(null);

        //Category view

        categoryrecyclerView = findViewById(R.id.category_recycler);
        categoryrecyclerView.setHasFixedSize(true);
        categoryrecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false) );
        FirebaseDatabase.getInstance().getReference("Category").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Category> categories = new ArrayList<>();
                for (DataSnapshot dataSnapshot :
                    snapshot.getChildren()) {
                    categories.add(dataSnapshot.getValue(Category.class));
                }
                adapter = new CategoryAdapter(categories, UserDashboard.this);
                categoryrecyclerView.setAdapter(adapter);

                btnCv = (Button) findViewById(R.id.btnCv);
                btnCv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), AllCategories.class);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        //Most View

        allviewrecyclerview = findViewById(R.id.most_viewed_recycler);
        allviewrecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        FirebaseDatabase.getInstance().getReference("View").limitToFirst(3).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<AllviewM> allView = new ArrayList<>();
                for (DataSnapshot dataSnapshot :
                    snapshot.getChildren()){
                    allView.add(dataSnapshot.getValue(AllviewM.class));
                }
                adapterv = new MostViewedAdapter(allView, UserDashboard.this);
                allviewrecyclerview.setAdapter(adapterv);

                btnMv = (Button) findViewById(R.id.btnMv);
                btnMv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getApplicationContext(), AllView.class);
                        startActivity(i);
                    }
                });
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //Feature view

        featuredrecyclerv = findViewById(R.id.featured_recycler);
        featuredrecyclerv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        FirebaseDatabase.getInstance().getReference("Feature").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Feature> features = new ArrayList<>();
                for (DataSnapshot dataSnapshot :
                    snapshot.getChildren()){
                    features.add(dataSnapshot.getValue(Feature.class));
                }
                adapterf = new FeaturedAdapter(features, UserDashboard.this);
                featuredrecyclerv.setAdapter(adapterf);
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        navigationDrawer();


    }

    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
        drawerLayout.setScrimColor(getResources().getColor(R.color.colorPrimaryDark2));
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }



    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_categories:
                Intent intent = new Intent(getApplicationContext(), AllCategories.class);
                startActivity(intent);
                break;
            case R.id.nav_home:
                Intent intent1 = new Intent(getApplicationContext(), AllView.class);
                startActivity(intent1);
                break;
            case R.id.nav_bus_stops:
                Intent intent2 = new Intent(getApplicationContext(), MapsBusStopActivity.class);
                startActivity(intent2);
                break;
            case R.id.nav_search:
                Intent intent3 = new Intent(getApplicationContext(), Search.class);
                startActivity(intent3);
                break;
            case R.id.nav_share:
                Toast.makeText(this,"Shared" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_rate_us:
                Toast.makeText(this,"Thanks for your rate" , Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

//    Category


    }












