package com.sict.maianhkiet.dng2.HomeAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sict.maianhkiet.dng2.Model.AllviewM;
import com.sict.maianhkiet.dng2.Model.Feature;
import com.sict.maianhkiet.dng2.R;
import com.sict.maianhkiet.dng2.User.DetailView;
import com.sict.maianhkiet.dng2.ViewHolder.FeatudedViewHolder;
import com.sict.maianhkiet.dng2.ViewHolder.ViewViewHolder;

import java.util.ArrayList;
import java.util.List;

public class FeaturedAdapter extends RecyclerView.Adapter<FeatudedViewHolder> {
    private List<Feature> features;
    private Context context;

    public FeaturedAdapter(List<Feature> features, Context context) {
        this.features = features;
        this.context = context;
    }

    @NonNull
    @Override
    public FeatudedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FeatudedViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_carddesign,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FeatudedViewHolder holder, final int position) {
        holder.titlef.setText(features.get(position).getTitlef());
        Glide.with(holder.itemView.getContext()).load(features.get(position
        ).getImagef()).into(holder.imagef);
        holder.ratef.setRating(features.get(position).getRatef());
        holder.descriptionf.setText(features.get(position).getDescriptionf());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailView.class);
                intent.putExtra("key", features.get(position).getKey());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return features.size();
    }
}




