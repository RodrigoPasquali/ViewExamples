package com.telynet.viewExamples.View.CarouselAndActualItem;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.telynet.viewExamples.Model.Product;
import com.telynet.viewExamples.R;

//public class CarouselListProductActivity extends AppCompatActivity implements CarouselFragment.CarouselFragmentListener {
public class CarouselListProductActivity extends AppCompatActivity {
    private CarouselFragment carouselFragment;
    private ActualProductFragment actualProductFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carousel_list_product);

        actualProductFragment = new ActualProductFragment();
//        carouselFragment = new CarouselFragment(actualProductFragment);

//        carouselFragment.setActualProductFragment(actualProductFragment);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.actual_product_fragment_cotainer, actualProductFragment)
                .commit();

        carouselFragment = new CarouselFragment(actualProductFragment);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.carousel_fragment_container, carouselFragment)
                .commit();
    }

    public ActualProductFragment getActualProductFragment(){
        return actualProductFragment;
    }

    public void updateActualProductFragment(Product product){
        actualProductFragment.updateActualProduct(product);
    }

//    @Override
//    public void onProductSelected(Product product) {
//        actualProductFragment.updateActualProduct(product);
//    }
}
