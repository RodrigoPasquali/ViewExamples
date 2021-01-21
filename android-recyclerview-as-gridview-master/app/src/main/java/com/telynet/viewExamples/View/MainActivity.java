package com.telynet.viewExamples.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.telynet.viewExamples.Model.Product;
import com.telynet.viewExamples.View.Utility.ProductAdapter;
import com.telynet.viewExamples.R;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView dataList;
    private ProductAdapter productAdapter;
    private List<Product> productsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataList = findViewById(R.id.dataList);

        productsList = new LinkedList<Product>();
        createProductoList();

        productAdapter = new ProductAdapter(this, productsList);

        int numberColumns = calculateNumberOfColumns(this, 200);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,numberColumns,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(productAdapter);
    }

    public static int calculateNumberOfColumns(Context context, float columnWidthDp) { // For example columnWidthdp=180
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float screenWidthDp = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (screenWidthDp / columnWidthDp + 0.5); // +0.5 for correct rounding to int.
        return noOfColumns;
    }

    private void createProductoList(){
        productsList.add(new Product("Fanta botella 1 lt", "4000030", R.mipmap.fanta_botella_foreground));
        productsList.add(new Product("Coca lata", "4000031", R.mipmap.coca_lata_foreground));
        productsList.add(new Product("Sprite botella 1 lt", "4000032", R.mipmap.sprite_botella_foreground));
        productsList.add(new Product("Coca Botella light", "4000033", R.mipmap.coca_botella_light_foreground));
        productsList.add(new Product("Coca Botellita", "4000034", R.mipmap.coca_botellita_foreground));
        productsList.add(new Product("Refresco botella 1 lt", "4000035", R.mipmap.refresco_litro_foreground));
        productsList.add(new Product("Soda lata", "4000036", R.mipmap.soda_lata_foreground));
        productsList.add(new Product("Fanta botella 1 lt", "4000030", R.mipmap.fanta_botella_foreground));
        productsList.add(new Product("Coca lata", "4000031", R.mipmap.coca_lata_foreground));
        productsList.add(new Product("Sprite botella 1 lt", "4000032", R.mipmap.sprite_botella_foreground));
        productsList.add(new Product("Coca Botella light", "4000033", R.mipmap.coca_botella_light_foreground));
        productsList.add(new Product("Coca Botellita", "4000034", R.mipmap.coca_botellita_foreground));
        productsList.add(new Product("Refresco botella 1 lt", "4000035", R.mipmap.refresco_litro_foreground));
        productsList.add(new Product("Soda lata", "4000036", R.mipmap.soda_lata_foreground));
        productsList.add(new Product("Fanta botella 1 lt", "4000030", R.mipmap.fanta_botella_foreground));
        productsList.add(new Product("Coca lata", "4000031", R.mipmap.coca_lata_foreground));
        productsList.add(new Product("Sprite botella 1 lt", "4000032", R.mipmap.sprite_botella_foreground));
        productsList.add(new Product("Coca Botella light", "4000033", R.mipmap.coca_botella_light_foreground));
        productsList.add(new Product("Coca Botellita", "4000034", R.mipmap.coca_botellita_foreground));
        productsList.add(new Product("Refresco botella 1 lt", "4000035", R.mipmap.refresco_litro_foreground));
        productsList.add(new Product("Soda lata", "4000036", R.mipmap.soda_lata_foreground));
        productsList.add(new Product("Fanta botella 1 lt", "4000030", R.mipmap.fanta_botella_foreground));
        productsList.add(new Product("Coca lata", "4000031", R.mipmap.coca_lata_foreground));
        productsList.add(new Product("Sprite botella 1 lt", "4000032", R.mipmap.sprite_botella_foreground));
        productsList.add(new Product("Coca Botella light", "4000033", R.mipmap.coca_botella_light_foreground));
        productsList.add(new Product("Coca Botellita", "4000034", R.mipmap.coca_botellita_foreground));
        productsList.add(new Product("Refresco botella 1 lt", "4000035", R.mipmap.refresco_litro_foreground));
        productsList.add(new Product("Soda lata", "4000036", R.mipmap.soda_lata_foreground));
        productsList.add(new Product("Fanta botella 1 lt", "4000030", R.mipmap.fanta_botella_foreground));
        productsList.add(new Product("Coca lata", "4000031", R.mipmap.coca_lata_foreground));
        productsList.add(new Product("Sprite botella 1 lt", "4000032", R.mipmap.sprite_botella_foreground));
        productsList.add(new Product("Coca Botella light", "4000033", R.mipmap.coca_botella_light_foreground));
        productsList.add(new Product("Coca Botellita", "4000034", R.mipmap.coca_botellita_foreground));
        productsList.add(new Product("Refresco botella 1 lt", "4000035", R.mipmap.refresco_litro_foreground));
        productsList.add(new Product("Soda lata", "4000036", R.mipmap.soda_lata_foreground));
        productsList.add(new Product("Fanta botella 1 lt", "4000030", R.mipmap.fanta_botella_foreground));
        productsList.add(new Product("Coca lata", "4000031", R.mipmap.coca_lata_foreground));
        productsList.add(new Product("Sprite botella 1 lt", "4000032", R.mipmap.sprite_botella_foreground));
        productsList.add(new Product("Coca Botella light", "4000033", R.mipmap.coca_botella_light_foreground));
        productsList.add(new Product("Coca Botellita", "4000034", R.mipmap.coca_botellita_foreground));
        productsList.add(new Product("Refresco botella 1 lt", "4000035", R.mipmap.refresco_litro_foreground));
        productsList.add(new Product("Soda lata", "4000036", R.mipmap.soda_lata_foreground));
        productsList.add(new Product("Fanta botella 1 lt", "4000030", R.mipmap.fanta_botella_foreground));
        productsList.add(new Product("Coca lata", "4000031", R.mipmap.coca_lata_foreground));
        productsList.add(new Product("Sprite botella 1 lt", "4000032", R.mipmap.sprite_botella_foreground));
        productsList.add(new Product("Coca Botella light", "4000033", R.mipmap.coca_botella_light_foreground));
        productsList.add(new Product("Coca Botellita", "4000034", R.mipmap.coca_botellita_foreground));
        productsList.add(new Product("Refresco botella 1 lt", "4000035", R.mipmap.refresco_litro_foreground));
        productsList.add(new Product("Soda lata", "4000036", R.mipmap.soda_lata_foreground));
        productsList.add(new Product("Fanta botella 1 lt", "4000030", R.mipmap.fanta_botella_foreground));
        productsList.add(new Product("Coca lata", "4000031", R.mipmap.coca_lata_foreground));
        productsList.add(new Product("Sprite botella 1 lt", "4000032", R.mipmap.sprite_botella_foreground));
        productsList.add(new Product("Coca Botella light", "4000033", R.mipmap.coca_botella_light_foreground));
        productsList.add(new Product("Coca Botellita", "4000034", R.mipmap.coca_botellita_foreground));
        productsList.add(new Product("Refresco botella 1 lt", "4000035", R.mipmap.refresco_litro_foreground));
        productsList.add(new Product("Soda lata", "4000036", R.mipmap.soda_lata_foreground));
        productsList.add(new Product("Fanta botella 1 lt", "4000030", R.mipmap.fanta_botella_foreground));
        productsList.add(new Product("Coca lata", "4000031", R.mipmap.coca_lata_foreground));
        productsList.add(new Product("Sprite botella 1 lt", "4000032", R.mipmap.sprite_botella_foreground));
        productsList.add(new Product("Coca Botella light", "4000033", R.mipmap.coca_botella_light_foreground));
        productsList.add(new Product("Coca Botellita", "4000034", R.mipmap.coca_botellita_foreground));
        productsList.add(new Product("Refresco botella 1 lt", "4000035", R.mipmap.refresco_litro_foreground));
        productsList.add(new Product("Soda lata", "4000036", R.mipmap.soda_lata_foreground));
        productsList.add(new Product("Fanta botella 1 lt", "4000030", R.mipmap.fanta_botella_foreground));
        productsList.add(new Product("Coca lata", "4000031", R.mipmap.coca_lata_foreground));
        productsList.add(new Product("Sprite botella 1 lt", "4000032", R.mipmap.sprite_botella_foreground));
        productsList.add(new Product("Coca Botella light", "4000033", R.mipmap.coca_botella_light_foreground));
        productsList.add(new Product("Coca Botellita", "4000034", R.mipmap.coca_botellita_foreground));
        productsList.add(new Product("Refresco botella 1 lt", "4000035", R.mipmap.refresco_litro_foreground));
        productsList.add(new Product("Soda lata", "4000036", R.mipmap.soda_lata_foreground));
        productsList.add(new Product("Fanta botella 1 lt", "4000030", R.mipmap.fanta_botella_foreground));
        productsList.add(new Product("Coca lata", "4000031", R.mipmap.coca_lata_foreground));
        productsList.add(new Product("Sprite botella 1 lt", "4000032", R.mipmap.sprite_botella_foreground));
        productsList.add(new Product("Coca Botella light", "4000033", R.mipmap.coca_botella_light_foreground));
        productsList.add(new Product("Coca Botellita", "4000034", R.mipmap.coca_botellita_foreground));
        productsList.add(new Product("Refresco botella 1 lt", "4000035", R.mipmap.refresco_litro_foreground));
        productsList.add(new Product("Soda lata", "4000036", R.mipmap.soda_lata_foreground));
        productsList.add(new Product("Fanta botella 1 lt", "4000030", R.mipmap.fanta_botella_foreground));
        productsList.add(new Product("Coca lata", "4000031", R.mipmap.coca_lata_foreground));
        productsList.add(new Product("Sprite botella 1 lt", "4000032", R.mipmap.sprite_botella_foreground));
        productsList.add(new Product("Coca Botella light", "4000033", R.mipmap.coca_botella_light_foreground));
        productsList.add(new Product("Coca Botellita", "4000034", R.mipmap.coca_botellita_foreground));
        productsList.add(new Product("Refresco botella 1 lt", "4000035", R.mipmap.refresco_litro_foreground));
        productsList.add(new Product("Soda lata", "4000036", R.mipmap.soda_lata_foreground));
        productsList.add(new Product("Fanta botella 1 lt", "4000030", R.mipmap.fanta_botella_foreground));
        productsList.add(new Product("Coca lata", "4000031", R.mipmap.coca_lata_foreground));
        productsList.add(new Product("Sprite botella 1 lt", "4000032", R.mipmap.sprite_botella_foreground));
        productsList.add(new Product("Coca Botella light", "4000033", R.mipmap.coca_botella_light_foreground));
        productsList.add(new Product("Coca Botellita", "4000034", R.mipmap.coca_botellita_foreground));
        productsList.add(new Product("Refresco botella 1 lt", "4000035", R.mipmap.refresco_litro_foreground));
        productsList.add(new Product("Soda lata", "4000036", R.mipmap.soda_lata_foreground));
        productsList.add(new Product("Fanta botella 1 lt", "4000030", R.mipmap.fanta_botella_foreground));
        productsList.add(new Product("Coca lata", "4000031", R.mipmap.coca_lata_foreground));
        productsList.add(new Product("Sprite botella 1 lt", "4000032", R.mipmap.sprite_botella_foreground));
        productsList.add(new Product("Coca Botella light", "4000033", R.mipmap.coca_botella_light_foreground));
        productsList.add(new Product("Coca Botellita", "4000034", R.mipmap.coca_botellita_foreground));
        productsList.add(new Product("Refresco botella 1 lt", "4000035", R.mipmap.refresco_litro_foreground));
        productsList.add(new Product("Soda lata", "4000036", R.mipmap.soda_lata_foreground));
    }
}
