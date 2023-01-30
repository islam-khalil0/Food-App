package com.example.foodappandroiddesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity implements View.OnClickListener {

    ImageView img_food ;
    TextView name_food ;
    TextView counter , salary ;
    ImageView plus , minus , back;

   int counterMain = 0 ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        img_food = (ImageView) findViewById(R.id.img_food_page_2);
        plus = (ImageView) findViewById(R.id.plus_img);
        minus = (ImageView) findViewById(R.id.minus_img);
        back = (ImageView) findViewById(R.id.back);

        name_food = (TextView) findViewById(R.id.name_food_page_2);
        counter = (TextView) findViewById(R.id.Counter_tv);
        salary = (TextView) findViewById(R.id.salary_0_0);



        String name_food_Main = getIntent().getStringExtra("title");
        int img_food_Main = getIntent().getIntExtra("img_two",0);

        img_food.setImageResource(img_food_Main);
        name_food.setText(name_food_Main);


        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        back.setOnClickListener(this);





    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.plus_img:
                plus_btn();
                break;

            case R.id.minus_img:
                minus_btn();
                break;
            case R.id.back:
                Intent intent = new Intent(MainActivity4.this,MainActivity2.class);
                startActivity(intent);
                finish();
        }
    }



    public void plus_btn () {
        counterMain++;
        counter.setText(counterMain + "");
        salary.setText(30 +"");
    }

    public void minus_btn (){
        if (counterMain>0) {
            counterMain--;
            counter.setText(counterMain + "");
        }
    }


}