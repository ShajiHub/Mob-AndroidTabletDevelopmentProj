package com.shajitha.recipeapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class foodCategoryAdapter extends RecyclerView.Adapter<foodCategoryAdapter.MyViewHolder> {

    Context context;
    ArrayList<foodCategoriesModel> foodCategoriesModels;

    public foodCategoryAdapter(Context context, ArrayList<foodCategoriesModel> foodCategoriesModels){
     this.context = context;
     this.foodCategoriesModels = foodCategoriesModels;
    }

    @NonNull
    @Override
    public foodCategoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.categoryimagelayout,parent, false);
        return new foodCategoryAdapter.MyViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull foodCategoryAdapter.MyViewHolder holder, int position) {
    // assigning value to the views created in categoryimagelayout
        holder.cName.setText(foodCategoriesModels.get(position).getCategoryName());
        String Name = foodCategoriesModels.get(position).getCategoryName();
        holder.imgView.setImageResource(foodCategoriesModels.get(position).getImage());
        holder.imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendPage(Name);
            }
        });
    }
    private void sendPage(String categoryName) {
        switch (categoryName){
            case "SOUPS":
                // context.startActivity(new Intent(this,SOUPS.class));

                Intent soup = new Intent(foodCategoryAdapter.this.context, SOUPS.class);
                context.startActivity(soup);
                break;
            case "SANDWICHES":
                // context.startActivity(new Intent(this,SOUPS.class));

                Intent s = new Intent(foodCategoryAdapter.this.context, SANDWICHES.class);
                context.startActivity(s);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + categoryName);
        }

    }
    @Override
    public int getItemCount() {
        return foodCategoriesModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
    //grab views from categoryimagelayout like onCreate

        ImageView imgView;
        TextView cName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.catImgName);
            cName = itemView.findViewById(R.id.catName);

        }
    }
}
