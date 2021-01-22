package com.telynet.viewExamples.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.telynet.viewExamples.Model.Product;
import com.telynet.viewExamples.Util.ProductSimulator;
import com.telynet.viewExamples.View.Utility.ProductAdapter;
import com.telynet.viewExamples.R;

import java.util.LinkedList;
import java.util.List;

public class GridActivity extends AppCompatActivity {
    private RecyclerView dataList;
    private ProductAdapter productAdapter;
    private List<Product> productsList;
    private ProductSimulator productSimulator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataList = findViewById(R.id.dataList);

        ProductSimulator productSimulator = new ProductSimulator();
        productsList = productSimulator.createProductoList();

        productAdapter = new ProductAdapter(this, productsList);

        int numberColumns = calculateNumberOfColumns(this, 200);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,numberColumns,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(productAdapter);
    }

    public static int calculateNumberOfColumns(Context context, float columnWidthDp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float screenWidthDp = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (screenWidthDp / columnWidthDp + 0.5); // +0.5 for correct rounding to int.
        return noOfColumns;
    }
}
