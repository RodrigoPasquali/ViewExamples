package com.telynet.viewExamples.View.Grid;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.telynet.viewExamples.Model.Product;
import com.telynet.viewExamples.R;
import com.telynet.viewExamples.View.Grid.Utility.GridProductAdapter;

import java.util.List;

public class GridViewFragment extends Fragment {
    private RecyclerView recyclerView;
    private GridProductAdapter gridProductAdapter;
    private List<Product> productsList;

    public GridViewFragment() {
    }

    public GridViewFragment(List<Product> products) {
        this.productsList = products;
    }

//    public static GridViewFragment newInstance(String param1, String param2) {
//        GridViewFragment fragment = new GridViewFragment();
//
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grid_view, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        int numberColumns = calculateNumberOfColumns(getContext(), 200);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),numberColumns,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);

        gridProductAdapter = new GridProductAdapter(getContext(), productsList);
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