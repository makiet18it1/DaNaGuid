package com.sict.maianhkiet.dng2.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sict.maianhkiet.dng2.R;

public class FeatudedViewHolder extends RecyclerView.ViewHolder {

    public ImageView imagef;
    public TextView titlef;
    public RatingBar ratef;
    public TextView descriptionf;

    public FeatudedViewHolder(@NonNull View itemView) {
        super(itemView);
        imagef = (ImageView) itemView.findViewById(R.id.featured_image);
        titlef = (TextView) itemView.findViewById(R.id.featured_title);
        ratef = (RatingBar) itemView.findViewById(R.id.featured_rate);
        descriptionf = (TextView) itemView.findViewById(R.id.featured_description);
    }

}
