package com.telynet.viewExamples.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.telynet.viewExamples.Model.Product;
import com.telynet.viewExamples.Util.ProductSimulator;
import com.telynet.viewExamples.R;
import com.telynet.viewExamples.View.Utility.CarouselAdapter;
import com.telynet.viewExamples.View.Utility.PageAdapter;

import java.util.List;

public class CarouselActivity extends AppCompatActivity {
    private CarouselAdapter carouselAdapter;
    private List<Product> productsList;
    private ProductSimulator productSimulator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R .layout.activity_carousel);

        CarouselView carouselView = findViewById(R.id.carousel_view);

        ProductSimulator productSimulator = new ProductSimulator();
        productsList = productSimulator.createProductoList();

        if(carouselAdapter == null){
            carouselAdapter = new PageAdapter(this, productsList);
            carouselView.setAdapter(carouselAdapter);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        carouselAdapter.notifyDataSetChanged();
    }
}