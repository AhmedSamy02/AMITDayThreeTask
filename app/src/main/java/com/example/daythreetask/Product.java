package com.example.daythreetask;

import android.graphics.drawable.Drawable;

public class Product {
    public String productName;
    public String productDescribtion;

    public Product(String productName, String productDescribtion, String productDetails, Drawable productPicture) {
        this.productName = productName;
        this.productDescribtion = productDescribtion;
        this.productDetails = productDetails;
        this.productPicture = productPicture;
    }

    public String productDetails;

    public String getPrice() {
        return Double.toString(price)+"$";
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private double price;
    public Drawable productPicture;
}
