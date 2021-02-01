package com.telynet.viewExamples.View.CarouselAndActualItem;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_carousel, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);

        ProductSimulator productSimulator = new ProductSimulator();
        List<Product> productsList = productSimulator.createProductoList();

        GridProductAdapter gridProductAdapter = new GridProductAdapter(getContext(), productsList);

        int numberColumns = calculateNumberOfColumns(getContext(), 200);

//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext() ,3 ,GridLayoutManager.HORIZONTAL,false);
//        gridLayoutManager.setSpanCount(5);


        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
//        LinearLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3, GridLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(gridProductAdapter);

        return view;
    }

    public static int calculateNumberOfColumns(Context context, float columnWidthDp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float screenWidthDp = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (screenWidthDp / columnWidthDp + 0.5); // +0.5 for correct rounding to int.
        return noOfColumns;
    }
}