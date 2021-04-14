package com.sict.maianhkiet.dng2.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sict.maianhkiet.dng2.Model.Feature;
import com.sict.maianhkiet.dng2.R;
import com.sict.maianhkiet.dng2.databinding.ActivityDetailViewBinding;

public class DetailView extends AppCompatActivity {

    ImageView backPress, searchIcon;
    private ActivityDetailViewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_view);

        final String key = getIntent().getStringExtra("key");
        FirebaseDatabase.getInstance().getReference("Feature").child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Feature feature = snapshot.getValue(Feature.class);
                binding.titleDetail.setText(feature.getTitlef());
                binding.detailRate.setRating(feature.getRatef());
                Glide
                    .with(binding.detailImage)
                    .load(feature.getImagef())
                    .into(binding.detailImage);
                binding.detailDescription.setText(feature.getDescriptionf());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        binding.detailRate.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                FirebaseDatabase.getInstance().getReference("Feature").child(key).child("ratef").setValue(v);
            }
        });

        backPress=findViewById(R.id.back_pressed);
        backPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetailView.this,UserDashboard.class);
                startActivity(i);
            }
        });

        searchIcon = findViewById(R.id.image_searchd);
        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent is = new Intent(DetailView.this,Search.class);
                startActivity(is);
            }
        });

    }
}
