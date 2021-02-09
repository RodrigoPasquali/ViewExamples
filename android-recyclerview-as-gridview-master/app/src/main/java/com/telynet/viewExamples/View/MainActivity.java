package com.telynet.viewExamples.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.telynet.viewExamples.Model.Product;
import com.telynet.viewExamples.Util.ProductSimulator;
import com.telynet.viewExamples.View.Carousel.CarouselViewFragment;
import com.telynet.viewExamples.View.CarouselWithActualItem.CarouselWithActualItemViewFragment;
import com.telynet.viewExamples.R;
import com.telynet.viewExamples.View.Grid.GridViewFragment;
import com.telynet.viewExamples.View.Utility.ViewTypeLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Product> productsList;
    private ViewTypeLayout currentTypeView = ViewTypeLayout.GRID_VIEW;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initProductList();

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        setLayoutView(currentTypeView);
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
                currentTypeView = ViewTypeLayout.GRID_VIEW;
                break;

            case R.id.carouselViewOption:
                currentTypeView = ViewTypeLayout.CAROUSEL_VIEW;
                break;

            case R.id.carouselWithActualItemOption:
                currentTypeView = ViewTypeLayout.CAROUSEL_WITH_ACTUAL_ITEM_VIEW;
                break;
        }

        setLayoutView(currentTypeView);

        return super.onOptionsItemSelected(item);
    }

    private void initProductList() {
        ProductSimulator productSimulator = new ProductSimulator();
        productsList = productSimulator.createProductoList();
    }

    private void setLayoutView(ViewTypeLayout viewTypeLayout) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();

        switch (viewTypeLayout) {
            case GRID_VIEW:
//                setGridView();
                fragmentTransaction.replace(R.id.fragment_container, new GridViewFragment(productsList));
                fragmentTransaction.commit();
                break;

            case CAROUSEL_VIEW:
//                setCarouselView();
                fragmentTransaction.replace(R.id.fragment_container, new CarouselViewFragment(productsList));
                fragmentTransaction.commit();
                break;

            case CAROUSEL_WITH_ACTUAL_ITEM_VIEW:
//                setCarouselWithActualitemView();
                fragmentTransaction.replace(R.id.fragment_container, new CarouselWithActualItemViewFragment(productsList));
                fragmentTransaction.commit();
                break;
        }
    }
}