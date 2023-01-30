package com.example.foodappandroiddesign;

public class Popular {

    public String title ;
    public  String price ;
    public int img_pop ;

    public Popular(String title, String price, int img_pop) {
        this.title = title;
        this.price = price;
        this.img_pop = img_pop;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImg_pop() {
        return img_pop;
    }

    public void setImg_pop(int img_pop) {
        this.img_pop = img_pop;
    }
}
