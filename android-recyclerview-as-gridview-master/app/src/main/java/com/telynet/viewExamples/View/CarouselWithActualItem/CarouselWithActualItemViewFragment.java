package com.telynet.viewExamples.View.CarouselWithActualItem;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.telynet.viewExamples.Model.Product;
import com.telynet.viewExamples.R;

import java.util.List;

public class CarouselWithActualItemViewFragment extends Fragment implements CarouselFragment.CarouselFragmentListener {
    private CarouselFragment carouselFragment;
    private ImageView productImage;
    public TextView tvTitle;
    private TextView tvCode;
    private List<Product> productsList;

    public CarouselWithActualItemViewFragment(List<Product> products) {
        this.productsList = products;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        carouselFragment = new CarouselFragment(productsList, this);

        getChildFragmentManager().beginTransaction()
                .replace(R.id.carousel_fragment_container, carouselFragment)
                .commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carousel_with_actual_item_view, container, false);

        productImage = view.findViewById(R.id.iv_product);
        tvTitle = view.findViewById(R.id.tv_title);
        tvCode = view.findViewById(R.id.tv_code);

        return view;
    }

    @Override
    public void onProductSelected(Product product) {
        productImage.setImageResource(product.getImage());
        tvTitle.setText(product.getTitle());
        tvCode.setText(product.getCode());
    }
}