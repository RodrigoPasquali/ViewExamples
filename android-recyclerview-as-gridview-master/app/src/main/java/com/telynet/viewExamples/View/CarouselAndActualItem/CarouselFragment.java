package com.telynet.viewExamples.View.CarouselAndActualItem;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.telynet.viewExamples.Model.Product;
import com.telynet.viewExamples.R;
import com.telynet.viewExamples.Util.ProductSimulator;
import com.telynet.viewExamples.View.Utility.GridProductAdapter;

import java.util.List;

public class CarouselFragment extends Fragment {
//    private CarouselFragmentListener listener;
    private ActualProductFragment actualProductFragment;
    private GridProductAdapter gridProductAdapter;

    public interface CarouselFragmentListener {
        void onProductSelected(Product product);
    }

    public CarouselFragment(){};

    public CarouselFragment(ActualProductFragment actualProductFragment) {
        actualProductFragment = actualProductFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carousel, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);

        ProductSimulator productSimulator = new ProductSimulator();
        List<Product> productsList = productSimulator.createProductoList();

        CarouselListProductActivity carouselListProductActivity = (CarouselListProductActivity) getActivity();
        gridProductAdapter = new GridProductAdapter(getContext(), productsList, carouselListProductActivity.getActualProductFragment());

//        gridProductAdapter.setCarouselFragmentListener(listener);
//        gridProductAdapter.setActualProductFragment(actualProductFragment);

        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(gridProductAdapter);

        return view;
    }

//    public void setActualProductFragment(Fragment actualProductFragment){
////        actualProductFragment = actualProductFragment;
//        gridProductAdapter.setActualProductFragment(actualProductFragment);
//    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof CarouselFragmentListener) {
//            listener = (CarouselFragmentListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement FragmentAListener");
//        }
//    }
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        listener = null;
//    }


}