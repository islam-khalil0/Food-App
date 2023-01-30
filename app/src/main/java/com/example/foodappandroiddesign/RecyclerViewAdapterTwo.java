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


public class RecyclerViewAdapterTwo extends RecyclerView.Adapter<RecyclerViewAdapterTwo.ViewHolder> {


    Context context ;
    ArrayList<Popular> popularArrayList = new ArrayList<>();
    PopularClickListener popularClickListener ;

    public RecyclerViewAdapterTwo(Context context, ArrayList<Popular> popularArrayList, PopularClickListener popularClickListener) {
        this.context = context;
        this.popularArrayList = popularArrayList;
        this.popularClickListener = popularClickListener;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterTwo.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv_two,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterTwo.ViewHolder holder, int position) {

        Popular popular = popularArrayList.get(position);

        holder.title.setText(popular.getTitle());
        holder.price.setText(popular.getPrice());
        holder.imageView.setImageResource(popular.getImg_pop());


    }

    @Override
    public int getItemCount() {
        return popularArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title , add;
        ImageView imageView ;
        TextView price ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title =(TextView) itemView.findViewById(R.id.base_name);
            imageView = (ImageView) itemView.findViewById(R.id.item_img_food_two);
            price = (TextView) itemView.findViewById(R.id.price);
            add = (TextView) itemView.findViewById(R.id.tv_add);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    popularClickListener.onClickListenerPop(popularArrayList.get(getAdapterPosition()),imageView);

                }
            });



        }
    }
}
