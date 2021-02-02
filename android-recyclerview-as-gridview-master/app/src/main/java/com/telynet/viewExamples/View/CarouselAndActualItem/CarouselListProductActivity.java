package com.telynet.viewExamples.View.CarouselAndActualItem;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.telynet.viewExamples.Model.Product;
import com.telynet.viewExamples.R;

//public class CarouselListProductActivity extends AppCompatActivity implements CarouselFragment.CarouselFragmentListener {
public class CarouselListProductActivity extends AppCompatActivity implements CarouselFragment.CarouselFragmentListener {
    private CarouselFragment carouselFragment;
    private ActualProductFragment actualProductFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carousel_list_product);

        actualProductFragment = new ActualProductFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.actual_product_fragment_cotainer, actualProductFragment)
                .commit();

        carouselFragment = new CarouselFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.carousel_fragment_container, carouselFragment)
                .commit();
    }



    @Override
    public void onProductSelected(Product product) {
        actualProductFragment = new ActualProductFragment(product);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.actual_product_fragment_cotainer, actualProductFragment)
                .commit();
    }
}
