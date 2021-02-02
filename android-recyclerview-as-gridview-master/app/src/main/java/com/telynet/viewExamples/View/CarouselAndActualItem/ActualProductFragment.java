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
    public TextView tvTitle;
    private TextView tvCode;
    private  View v;
    private Product p;

    public ActualProductFragment (){}
    public ActualProductFragment (Product p){
        this.p = p;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.custom_carousel_layout, container, false);
        this.v = view;
        productImage = v.findViewById(R.id.iv_product);
        tvTitle = v.findViewById(R.id.tv_title);
        tvCode = v.findViewById(R.id.tv_code);

        if(p != null){
            productImage.setImageResource(p.getImage());
            tvTitle.setText(p.getTitle());
            tvCode.setText(p.getCode());
        }
        return v;
    }

}