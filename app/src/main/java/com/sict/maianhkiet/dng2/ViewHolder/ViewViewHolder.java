package com.sict.maianhkiet.dng2.ViewHolder;


import android.annotation.SuppressLint;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import com.sict.maianhkiet.dng2.R;

public class ViewViewHolder extends RecyclerView.ViewHolder {

    public ImageView imagev;
    public TextView titlev;
    public RatingBar ratev;
    public TextView descriptionv;


    @SuppressLint("WrongViewCast")
    public ViewViewHolder(@NonNull View itemView) {
        super(itemView);

        imagev = (ImageView) itemView.findViewById(R.id.most_image);
        titlev = (TextView) itemView.findViewById(R.id.most_title);
        ratev = (RatingBar) itemView.findViewById(R.id.most_ratingbar);
        descriptionv = (TextView) itemView.findViewById(R.id.most_description);


    }



}
