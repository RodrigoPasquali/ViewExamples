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

import com.telynet.viewExamples.Model.Product;
import com.telynet.viewExamples.Util.ProductSimulator;
import com.telynet.viewExamples.View.Carousel.CarouselView;
import com.telynet.viewExamples.View.Carousel.Utility.CarouselAdapter;
import com.telynet.viewExamples.View.Carousel.Utility.CarouselProductAdapter;
import com.telynet.viewExamples.View.CarouselAndActualItem.CarouselListProductActivity;
import com.telynet.viewExamples.View.Grid.Utility.MainProductAdapter;
import com.telynet.viewExamples.R;
import com.telynet.viewExamples.View.ViewTypeLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MainProductAdapter mainProductAdapter;
    private List<Product> productsList;
    private CarouselView carouselView;
    private CarouselAdapter carouselAdapter;
    private FrameLayout recyclerViewContainer;
    private FrameLayout carouselContainer;
    private GridLayoutManager gridLayoutManager;
    private static final int COLUMN_GRID_WIDTH = 200;
    private ViewTypeLayout viewTypeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initProductList();

        initGridView();

        initCarouselView();
        
        initRecyclerView(mainProductAdapter, gridLayoutManager);

        initFirstTimeViewLayout();
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
                viewTypeLayout = ViewTypeLayout.GRID_VIEW;
                break;

            case R.id.carouselViewOption:
                viewTypeLayout = ViewTypeLayout.CAROUSEL_VIEW;
                break;

            case R.id.carouselWithActualItemOption:
                viewTypeLayout = ViewTypeLayout.CAROUSEL_WITH_ACTUAL_ITEM_VIEW;
                break;
        }

        initViewLayout(viewTypeLayout);

        return super.onOptionsItemSelected(item);
    }

    private void initFirstTimeViewLayout() {
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            viewTypeLayout = (ViewTypeLayout) bundle.getSerializable("viewTypeLayout");
        }

        if(viewTypeLayout == null) {
            viewTypeLayout = viewTypeLayout.GRID_VIEW;
        }

        initViewLayout(viewTypeLayout);
    }

    private int calculateNumberOfColumns(Context context, float columnWidthDp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float screenWidthDp = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (screenWidthDp / columnWidthDp + 0.5); // +0.5 for correct rounding to int.
        return noOfColumns;
    }

    private void initRecyclerView(MainProductAdapter adapter, GridLayoutManager gridLayoutManager) {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerViewContainer = findViewById(R.id.recycler_view_container);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initCarouselView() {
        carouselView = findViewById(R.id.carousel_view);
        carouselContainer = findViewById(R.id.carousel_container);
        carouselContainer.setVisibility(View.GONE);
        carouselAdapter = new CarouselProductAdapter(this, productsList);
        carouselView.setAdapter(carouselAdapter);
    }

    private void initGridView() {
        int numberColumns = calculateNumberOfColumns(this, COLUMN_GRID_WIDTH);
        gridLayoutManager = new GridLayoutManager(this,numberColumns,GridLayoutManager.VERTICAL,false);
        mainProductAdapter = new MainProductAdapter(this, productsList);
    }

    private void initProductList() {
        ProductSimulator productSimulator = new ProductSimulator();
        productsList = productSimulator.createProductoList();
    }

    private void initViewLayout(ViewTypeLayout viewTypeLayout) {
        switch (viewTypeLayout) {
            case GRID_VIEW:
                setGridView();
                break;

            case CAROUSEL_VIEW:
                setCarouselView();
                break;

            case CAROUSEL_WITH_ACTUAL_ITEM_VIEW:
                setCarouselWithActualitemView();
                break;
        }
    }

    private void setGridView() {
        mainProductAdapter.setViewTypeLayout(ViewTypeLayout.GRID_VIEW);
        recyclerViewContainer.setVisibility(View.VISIBLE);
        carouselContainer.setVisibility(View.GONE);

        initGridView();
    }

    private void setCarouselView() {
        mainProductAdapter.setViewTypeLayout(ViewTypeLayout.CAROUSEL_VIEW);

        recyclerViewContainer.setVisibility(View.GONE);
        carouselContainer.setVisibility(View.VISIBLE);
    }

    private void setCarouselWithActualitemView() {
        mainProductAdapter.setViewTypeLayout(ViewTypeLayout.CAROUSEL_WITH_ACTUAL_ITEM_VIEW);

        Intent intent= new Intent (this, CarouselListProductActivity.class);
        intent.addFlags (Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivityForResult(intent, 0);
        overridePendingTransition(0,0);

        finish();
    }
}