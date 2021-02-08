package com.telynet.viewExamples.View.Grid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.telynet.viewExamples.Model.Product;
import com.telynet.viewExamples.Util.ProductSimulator;
import com.telynet.viewExamples.View.Grid.Utility.GridProductAdapter;
import com.telynet.viewExamples.R;

import java.util.List;

public class GridActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private GridProductAdapter gridProductAdapter;
    private List<Product> productsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        recyclerView = findViewById(R.id.dataList);

        ProductSimulator productSimulator = new ProductSimulator();
        productsList = productSimulator.createProductoList();

        int numberColumns = calculateNumberOfColumns(this, 200);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,numberColumns,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);

        gridProductAdapter = new GridProductAdapter(this, productsList);
        recyclerView.setAdapter(gridProductAdapter);
    }

    public static int calculateNumberOfColumns(Context context, float columnWidthDp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float screenWidthDp = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (screenWidthDp / columnWidthDp + 0.5); // +0.5 for correct rounding to int.
        return noOfColumns;
    }
}
