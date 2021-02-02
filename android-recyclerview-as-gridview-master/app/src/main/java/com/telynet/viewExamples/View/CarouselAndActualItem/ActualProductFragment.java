package com.telynet.viewExamples.View.CarouselAndActualItem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.telynet.viewExamples.Model.Product;
import com.telynet.viewExamples.R;

public class ActualProductFragment extends Fragment {
    private ImageView productImage;
    private TextView tvTitle;
    private TextView tvCode;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.custom_carousel_layout, container, false);
        productImage = view.findViewById(R.id.iv_product);
        tvTitle = view.findViewById(R.id.tv_title);
        tvCode = view.findViewById(R.id.tv_code);

        return view;
    }

    public void updateActualProduct(Product actualProduct) {
        productImage.setImageResource(actualProduct.getImage());
        tvTitle.setText(actualProduct.getTitle());
        tvCode.setText(actualProduct.getCode());

    }
}