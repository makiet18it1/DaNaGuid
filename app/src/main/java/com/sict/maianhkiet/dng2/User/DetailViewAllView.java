package com.sict.maianhkiet.dng2.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sict.maianhkiet.dng2.Model.AllviewM;
import com.sict.maianhkiet.dng2.Model.Feature;
import com.sict.maianhkiet.dng2.R;
import com.sict.maianhkiet.dng2.databinding.ActivityDetailViewBinding;

public class DetailViewAllView extends AppCompatActivity {
    private ActivityDetailViewBinding bindingv;
    ImageView backPress, searchIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingv = DataBindingUtil.setContentView(this, R.layout.activity_detail_view);

        final String keyv = getIntent().getStringExtra("keyv");
        FirebaseDatabase.getInstance().getReference("View").child(keyv).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                AllviewM allviewMs = snapshot.getValue(AllviewM.class);
                bindingv.titleDetail.setText(allviewMs.getTitlev());
                bindingv.detailRate.setRating(allviewMs.getRatev());
                Glide
                    .with(bindingv.detailImage)
                    .load(allviewMs.getImagev())
                    .into(bindingv.detailImage);
                bindingv.detailDescription.setText(allviewMs.getDescriptionv());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        bindingv.detailRate.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                FirebaseDatabase.getInstance().getReference("View").child(keyv).child("ratev").setValue(v);
            }
        });

        backPress=findViewById(R.id.back_pressed);
        backPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetailViewAllView.this,AllView.class);
                startActivity(i);
            }
        });

        searchIcon = findViewById(R.id.image_searchd);
        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent is = new Intent(DetailViewAllView.this,Search.class);
                startActivity(is);
            }
        });
    }

}





