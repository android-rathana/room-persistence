package com.example.ratha.roomdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ratha.roomdemo.R;
import com.example.ratha.roomdemo.entity.Category;

import java.util.List;

/**
 * Created by ratha on 2/2/2018.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private List<Category> categories;
    private Context context;
    public CategoryAdapter (Context context,List<Category> categories){
        this.context=context;
        this.categories=categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(this.categories!=null){
            Category category=this.categories.get(position);
            holder.tvTitle.setText(category.name);
            holder.tvDescription.setText(category.desc);
            holder.thubm.setImageResource(R.drawable.coffee);
        }
    }

    @Override
    public int getItemCount() {
        return this.categories.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView thubm;
        TextView tvTitle;
        TextView tvDescription;
        public ViewHolder(View itemView){
            super(itemView);
            this.thubm=itemView.findViewById(R.id.thubm);
            this.tvTitle=itemView.findViewById(R.id.title);
            this.tvDescription=itemView.findViewById(R.id.description);
        }
    }
}
