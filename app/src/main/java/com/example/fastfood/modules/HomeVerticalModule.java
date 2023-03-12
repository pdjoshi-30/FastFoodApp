package com.example.fastfood.modules;

public class HomeVerticalModule {
    int image;
    String product_name;
    String delivery;
    String rating;
    String price;

    public HomeVerticalModule( int image,String delivery,String product_name,String rating,String price) {
        this.image = image;
        this.product_name = product_name;
        this.delivery = delivery;
        this.rating = rating;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
