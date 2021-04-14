package com.sict.maianhkiet.dng2.ViewHolder;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sict.maianhkiet.dng2.R;


public class CategoryViewHolder extends RecyclerView.ViewHolder {

    public ImageView image;
    public TextView title;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);

        image = (ImageView) itemView.findViewById(R.id.category_image);
        title = (TextView) itemView.findViewById(R.id.category_title);


    }
}
