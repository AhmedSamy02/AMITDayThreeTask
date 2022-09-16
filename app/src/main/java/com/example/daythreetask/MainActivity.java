package com.example.daythreetask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daythreetask.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    int counter = 0;
    boolean added=false;
    TextView txt;
    TextView txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Product apples = new Product(
                "Natural Red Apples",
                "1kg, Price",
                "Apples are an incredibly nutritious fruit that offers multiple health benefits.They’re rich in fiber and antioxidants. Eating them is linked to a lower risk of many chronic conditions, including diabetes, heart disease, and cancer.Apples may also promote weight loss and improve gut and brain health.",
                getResources().getDrawable(R.drawable.apples));
        apples.setPrice(4.99);
        binding.setProduct(apples);
        binding.setNumberOfProducts("0");
        binding.removeFromFavourites.setVisibility(View.GONE);
        txt2 = findViewById(R.id.excess_amount);
        txt = findViewById(R.id.numberOfProducts);
        if(binding.getNumberOfProducts()!="21")
        {        binding.excessAmount.setVisibility(View.GONE);}
    }



    public void Increase(View view) {
        counter = Integer.parseInt((String) txt.getText());
        if (counter == 20) {
            txt2.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Excess Amount", Toast.LENGTH_SHORT).show();
        }
        else {
            counter++;
            txt.setText(Integer.toString(counter));
        }
    }
    public void decrease(View view)
    {
        if(counter==20)
            txt2.setVisibility(View.GONE);
        if(counter!=0) {
            counter--;
            txt.setText(Integer.toString(counter));
        }
        else {
            Toast.makeText(this, "Value Can't be less than zero", Toast.LENGTH_LONG).show();
        }
    }
    public void addToFavourits(View view)
    {
        if(!added)
        {
            binding.removeFromFavourites.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Added to favourites", Toast.LENGTH_SHORT).show();
            added=true;
        }
        else {
            added=false;
            Toast.makeText(this, "Removed from favourites", Toast.LENGTH_SHORT).show();
            binding.removeFromFavourites.setVisibility(View.GONE);
        }
    }

    public void AddToBasket(View view) {
        Toast.makeText(this, "Added to basket successfully", Toast.LENGTH_SHORT).show();
    }
}