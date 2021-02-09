package com.telynet.viewExamples.View.CarouselWithActualItem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.telynet.viewExamples.Model.Product;
import com.telynet.viewExamples.R;
import com.telynet.viewExamples.View.CarouselWithActualItem.Utility.CarouselWithActualItemAdapter;

import java.util.List;

public class CarouselFragment extends Fragment {
    private CarouselWithActualItemAdapter carouselWithActualItemAdapter;
    CarouselFragmentListener mCallback;
    private List<Product> productsList;

    public interface CarouselFragmentListener {
        void onProductSelected(Product product);
    }

    public CarouselFragment(List<Product> products, Fragment fragment) {
        this.productsList = products;

        mCallback = (CarouselFragmentListener) fragment;
    }

    public CarouselFragment() {
    }

//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        try {
//            mCallback = (CarouselFragmentListener) activity;
//        } catch (ClassCastException e) {
////            throw new ClassCastException(activity.toString()
////                    + " must implement OnHeadlineSelectedListener");
//            throw new ClassCastException(activity.toString()
//                    + " estalle en CarouselFragment");
//        }
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carousel, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);

//        ProductSimulator productSimulator = new ProductSimulator();
//        List<Product> productsList = productSimulator.createProductoList();

        carouselWithActualItemAdapter = new CarouselWithActualItemAdapter(getContext(), productsList,this);

        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(carouselWithActualItemAdapter);

        return view;
    }

    public void updateMainProduct(Product product){
        mCallback.onProductSelected(product);
    }
}