package com.sict.maianhkiet.dng2.HomeAdapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sict.maianhkiet.dng2.Model.Category;
import com.sict.maianhkiet.dng2.R;
import com.sict.maianhkiet.dng2.ViewHolder.CategoryViewHolder;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    private List<Category> category;
    private Context context;

    public CategoryAdapter(List<Category> category, Context context) {
        this.category = category;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_carddesign, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.title.setText(category.get(position).getTitle());
        Glide.with(holder.itemView.getContext()).load(category.get(position
        ).getImage()).into(holder.image);
        Log.d("","Title"+category.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return category.size();
    }
}
