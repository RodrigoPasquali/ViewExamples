package com.telynet.viewExamples.View.Grid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.telynet.viewExamples.Model.Product;
import com.telynet.viewExamples.Util.ProductSimulator;
import com.telynet.viewExamples.View.Carousel.CarouselView;
import com.telynet.viewExamples.View.Carousel.Utility.CarouselAdapter;
import com.telynet.viewExamples.View.Carousel.Utility.CarouselProductAdapter;
import com.telynet.viewExamples.View.CarouselAndActualItem.CarouselListProductActivity;
import com.telynet.viewExamples.View.Grid.Utility.GridProductAdapter;
import com.telynet.viewExamples.R;
import com.telynet.viewExamples.View.ViewTypeLayout;

import java.util.List;

public class GridActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private GridProductAdapter gridProductAdapter;
    private List<Product> productsList;
    private CarouselView carouselView;
    private CarouselAdapter carouselAdapter;
    private FrameLayout recyclerViewContainer;
    private FrameLayout carouselContainer;
    private static final int COLUMN_GRID_WIDTH = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        recyclerView = findViewById(R.id.recyclerView);
        carouselView = findViewById(R.id.carousel_view);
        recyclerViewContainer = findViewById(R.id.recycler_view_container);
        carouselContainer = findViewById(R.id.carousel_container);

        try {
            ViewTypeLayout viewTypeReceived = (ViewTypeLayout) getIntent().getExtras().getSerializable("viewType");
            if(viewTypeReceived == ViewTypeLayout.GRID_VIEW){
                recyclerViewContainer.setVisibility(View.VISIBLE);
                carouselContainer.setVisibility(View.GONE);
            } else {
                recyclerViewContainer.setVisibility(View.GONE);
                carouselContainer.setVisibility(View.VISIBLE);
            }
        } catch (Exception e) {
            carouselContainer.setVisibility(View.GONE);
        }



//        carouselContainer.setVisibility(View.GONE);

        ProductSimulator productSimulator = new ProductSimulator();
        productsList = productSimulator.createProductoList();

        int numberColumns = calculateNumberOfColumns(this, 200);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,numberColumns,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);

        gridProductAdapter = new GridProductAdapter(this, productsList);
        recyclerView.setAdapter(gridProductAdapter);

        carouselAdapter = new CarouselProductAdapter(this, productsList);
        carouselView.setAdapter(carouselAdapter);
    }

    @Override
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_views, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.gridViewOption:
                gridProductAdapter.setViewTypeLayout(ViewTypeLayout.GRID_VIEW);
                recyclerViewContainer.setVisibility(View.VISIBLE);
                carouselContainer.setVisibility(View.GONE);

                int numberColumns = calculateNumberOfColumns(this, COLUMN_GRID_WIDTH);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(this,numberColumns,GridLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(gridLayoutManager);
                recyclerView.setAdapter(gridProductAdapter);

                break;

            case R.id.carouselViewOption:
                recyclerViewContainer.setVisibility(View.GONE);
                carouselContainer.setVisibility(View.VISIBLE);

                break;

            case R.id.carouselWithActualItemOption:
                gridProductAdapter.setViewTypeLayout(ViewTypeLayout.CAROUSEL_WITH_ACTUAL_ITEM_VIEW);

                Intent intent= new Intent (this, CarouselListProductActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//                intent.addFlags (Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags (Intent.FLAG_ACTIVITY_NEW_TASK);
//                finish();
                startActivityForResult(intent, 0);
                overridePendingTransition(0,0);

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public static int calculateNumberOfColumns(Context context, float columnWidthDp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float screenWidthDp = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (screenWidthDp / columnWidthDp + 0.5); // +0.5 for correct rounding to int.
        return noOfColumns;
    }
}