package com.example.foodappandroiddesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements CategoriesClickListener , PopularClickListener {

    RecyclerView recyclerView , recyclerView2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = (RecyclerView) findViewById(R.id.rv_one);
        recyclerView2 = (RecyclerView) findViewById(R.id.rv_two);



        ArrayList<Categories> categoriesArrayListMain = new ArrayList<>();

        categoriesArrayListMain.add(new Categories("test", R.drawable.pizza));
        categoriesArrayListMain.add(new Categories("test", R.drawable.cat_2));
        categoriesArrayListMain.add(new Categories("test", R.drawable.cat_1));
        categoriesArrayListMain.add(new Categories("test", R.drawable.cat_3));
        categoriesArrayListMain.add(new Categories("test", R.drawable.cat_5));


        RecyclerViewAdapterOne adapterOne = new RecyclerViewAdapterOne(this, categoriesArrayListMain, this);
        recyclerView.setAdapter(adapterOne);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setHasFixedSize(true);



        ArrayList<Popular> popularArrayListMain = new ArrayList<>();

        popularArrayListMain.add(new Popular("title","price",R.drawable.pop_1));
        popularArrayListMain.add(new Popular("title","price",R.drawable.pop_2));
        popularArrayListMain.add(new Popular("title","price",R.drawable.pop_3));
        popularArrayListMain.add(new Popular("title","price",R.drawable.pop_1));
        popularArrayListMain.add(new Popular("title","price",R.drawable.pop_2));
        popularArrayListMain.add(new Popular("title","price",R.drawable.pop_3));


        RecyclerViewAdapterTwo adapterTwo = new RecyclerViewAdapterTwo(this,popularArrayListMain,this);

        recyclerView2.setAdapter(adapterTwo);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView2.setHasFixedSize(true);


    }

    @Override
    public void onCategoriesClick(Categories categories, ImageView imageView) {

        Intent intent = new Intent(MainActivity2.this,MainActivity3.class);

        intent.putExtra("name_food",categories.getName_food());
        intent.putExtra("img_food",categories.getImg_food());

        startActivity(intent);

    }

    @Override
    public void onClickListenerPop(Popular popular, ImageView imageView) {

        Intent intent = new Intent(MainActivity2.this,MainActivity4.class);

        intent.putExtra("title",popular.getTitle());
        intent.putExtra("price",popular.getPrice());
        intent.putExtra("img_two",popular.getImg_pop());

        startActivity(intent);


    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}










