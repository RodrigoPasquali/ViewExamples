package com.telynet.viewExamples.View.CarouselAndActualItem;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.telynet.viewExamples.Model.Product;
import com.telynet.viewExamples.R;
import com.telynet.viewExamples.View.Grid.GridActivity;
import com.telynet.viewExamples.View.ViewTypeLayout;

public class CarouselListProductActivity extends AppCompatActivity implements CarouselFragment.CarouselFragmentListener {
    private CarouselFragment carouselFragment;
    private ImageView productImage;
    public TextView tvTitle;
    private TextView tvCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carousel_list_product);

        carouselFragment = new CarouselFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.carousel_fragment_container, carouselFragment)
                .commit();

        productImage = findViewById(R.id.iv_product);
        tvTitle = findViewById(R.id.tv_title);
        tvCode = findViewById(R.id.tv_code);
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
        Intent intent= new Intent (this, GridActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//        intent.addFlags (Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags (Intent.FLAG_ACTIVITY_NEW_TASK);

        switch (item.getItemId()) {
            case R.id.gridViewOption:
//                finish();
                startActivityForResult(intent, 0);
                intent.putExtra("viewType", ViewTypeLayout.GRID_VIEW);
                overridePendingTransition(0,0);

                break;

            case R.id.carouselViewOption:
//                finish();
                intent.putExtra("viewType", ViewTypeLayout.CAROUSEL_VIEW);
                startActivityForResult(intent, 0);
                overridePendingTransition(0,0);

                break;

//            case R.id.carouselWithActualItemOption:
//
//
//                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onProductSelected(Product product) {
        productImage.setImageResource(product.getImage());
        tvTitle.setText(product.getTitle());
        tvCode.setText(product.getCode());
    }
}
