package com.example.finalprojict;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.categoryViewHolder> {
        ArrayList<category> categories;
        Context context;

public CategoryAdapter(ArrayList<category> categories) {
        this.categories = categories;
        }

    @NonNull
    @Override
    public CategoryAdapter.categoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_category_item,null,false) ;

        CategoryAdapter.categoryViewHolder c = new categoryViewHolder(v) ;
        return c;
    }
    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.categoryViewHolder holder, int position) {
        category r = categories.get(position);
        holder.name.setText(r.getName());
        holder.img.setImageResource(r.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context , Info.class);
                i.putExtra("name", categories.get(position).getName());
                i.putExtra("image", categories.get(position).getImage());
                i.putExtra("rating", categories.get(position).getRating());
                i.putExtra("desc" , categories.get(position).getDesc());
                i.putExtra("price", categories.get(position).getPrice());

                context.startActivity(i);
            }

        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class categoryViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;

        public categoryViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            name = itemView.findViewById(R.id.categoryname);
            img = itemView.findViewById(R.id.categoryimg);
        }
    }
}