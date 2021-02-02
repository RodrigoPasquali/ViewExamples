package com.telynet.viewExamples.View.CarouselAndActualItem;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.telynet.viewExamples.Model.Product;
import com.telynet.viewExamples.R;
import com.telynet.viewExamples.Util.ProductSimulator;
import com.telynet.viewExamples.View.Utility.GridProductAdapter;

import java.util.List;

public class CarouselFragment extends Fragment {
//    private CarouselFragmentListener listener;
    private ActualProductFragment actualProductFragment;
    private GridProductAdapter gridProductAdapter;
    CarouselFragmentListener mCallback;

    public interface CarouselFragmentListener {
        void onProductSelected(Product product);
    }

    public CarouselFragment(){};

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (CarouselFragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carousel, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);

        ProductSimulator productSimulator = new ProductSimulator();
        List<Product> productsList = productSimulator.createProductoList();

        CarouselListProductActivity carouselListProductActivity = (CarouselListProductActivity) getActivity();
        gridProductAdapter = new GridProductAdapter(getContext(), productsList,this);


        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(gridProductAdapter);

        return view;
    }

    public void updateMainProduct(Product p){
        mCallback.onProductSelected(p);
    }

}