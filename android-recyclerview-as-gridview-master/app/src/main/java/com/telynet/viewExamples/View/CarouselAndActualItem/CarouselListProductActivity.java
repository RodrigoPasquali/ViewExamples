package com.telynet.viewExamples.View.CarouselAndActualItem;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.telynet.viewExamples.Model.Product;
import com.telynet.viewExamples.R;

public class CarouselListProductActivity extends AppCompatActivity implements CarouselFragment.CarouselFragmentListener {
    private CarouselFragment carouselFragment;
    private ImageView productImage;
    public TextView tvTitle;
    private TextView tvCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carousel_list_product);

        carouselFragment = new CarouselFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.carousel_fragment_container, carouselFragment)
                .commit();

        productImage = findViewById(R.id.iv_product);
        tvTitle = findViewById(R.id.tv_title);
        tvCode = findViewById(R.id.tv_code);
    }

    @Override
    public void onProductSelected(Product p) {
        productImage.setImageResource(p.getImage());
        tvTitle.setText(p.getTitle());
        tvCode.setText(p.getCode());
    }
}
