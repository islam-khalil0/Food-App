package com.example.foodappandroiddesign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapterOne extends RecyclerView.Adapter<RecyclerViewAdapterOne.viewHolder> {

    Context context ;
    ArrayList<Categories> categoriesArrayList = new ArrayList<>();
    CategoriesClickListener categoriesClickListener ;

    public RecyclerViewAdapterOne(Context context, ArrayList<Categories> categoriesArrayList, CategoriesClickListener categoriesClickListener) {
        this.context = context;
        this.categoriesArrayList = categoriesArrayList;
        this.categoriesClickListener = categoriesClickListener;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterOne.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.item_rv_one,parent,false);
       viewHolder viewHolder = new viewHolder(view);
       return viewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterOne.viewHolder holder, int position) {
        Categories categories =categoriesArrayList.get(position);

        holder.textView.setText(categories.getName_food());
        holder.imageView.setImageResource(categories.getImg_food());

    }

    @Override
    public int getItemCount() {
        return categoriesArrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView ;
        TextView textView ;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.item_img_food);
            textView = (TextView) itemView.findViewById(R.id.item_name_food);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    categoriesClickListener.onCategoriesClick(categoriesArrayList.get(getAdapterPosition()),imageView);

                }
            });

        }
    }
}
