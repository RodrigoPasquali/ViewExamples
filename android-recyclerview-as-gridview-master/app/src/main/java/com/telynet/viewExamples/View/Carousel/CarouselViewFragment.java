package com.telynet.viewExamples.View.Carousel;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.telynet.viewExamples.Model.Product;
import com.telynet.viewExamples.R;
import com.telynet.viewExamples.View.Carousel.Utility.CarouselAdapter;
import com.telynet.viewExamples.View.Carousel.Utility.CarouselProductAdapter;

import java.util.List;

public class CarouselViewFragment extends Fragment {
    private List<Product> productsList;
    private CarouselAdapter carouselAdapter;
    private CarouselView carouselView;

    public CarouselViewFragment(List<Product> products) {
        this.productsList = products;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carousel_view, container, false);

        carouselView = view.findViewById(R.id.carousel_view);
        carouselAdapter = new CarouselProductAdapter(getContext(), productsList);
        carouselView.setAdapter(carouselAdapter);

        return view;
    }
}