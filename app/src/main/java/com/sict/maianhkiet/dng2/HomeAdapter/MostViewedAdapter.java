package com.sict.maianhkiet.dng2.HomeAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sict.maianhkiet.dng2.Model.AllviewM;
import com.sict.maianhkiet.dng2.R;
import com.sict.maianhkiet.dng2.User.DetailViewAllView;
import com.sict.maianhkiet.dng2.ViewHolder.ViewViewHolder;

import java.util.List;

public class MostViewedAdapter extends RecyclerView.Adapter<ViewViewHolder> {

    private List<AllviewM> allviewMs;
    private Context context;

    public MostViewedAdapter(List<AllviewM> allviewMs, Context context) {
        this.allviewMs = allviewMs;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewes_carddesign,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewViewHolder holder, final int position) {
        holder.titlev.setText(allviewMs.get(position).getTitlev());
        Glide.with(holder.itemView.getContext()).load(allviewMs.get(position
        ).getImagev()).into(holder.imagev);
        holder.ratev.setRating(allviewMs.get(position).getRatev());
        holder.descriptionv.setText(allviewMs.get(position).getDescriptionv());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(context, DetailViewAllView.class);
                Intent i = intent1.putExtra("keyv", allviewMs.get(position).getKeyv());
                context.startActivity(intent1);
            }
        });
    }


    @Override
    public int getItemCount() {
        return allviewMs.size();
    }

}
