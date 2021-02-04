package com.telynet.viewExamples.View.Grid.Utility;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.telynet.viewExamples.Model.Product;
import com.telynet.viewExamples.R;
import com.telynet.viewExamples.View.Carousel.CarouselActivity;
import com.telynet.viewExamples.View.CarouselAndActualItem.CarouselFragment;
import com.telynet.viewExamples.View.CarouselAndActualItem.CarouselListProductActivity;
import com.telynet.viewExamples.View.Grid.GridActivity;
import com.telynet.viewExamples.View.ViewTypeLayout;

import java.util.List;

import static com.telynet.viewExamples.View.ViewTypeLayout.GRID_VIEW;

//public class GridProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements CarouselFragment.CarouselFragmentListener {
public class GridProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private LayoutInflater inflater;
    private List<Product> productsList;
    private Context context;
    private ViewTypeLayout viewTypeLayout;
//    private CarouselFragment carouselFragment;

    public GridProductAdapter(Context context, List<Product> products){
        productsList = products;
        inflater = LayoutInflater.from(context);
        viewTypeLayout = GRID_VIEW;

//        carouselFragment = new CarouselFragment();

//        FragmentManager fragmentManager = ((GridActivity) context).getSupportFragmentManager();
//
//        fragmentManager.beginTransaction().replace(R.id.carousel_fragment_container, carouselFragment)
//                        .commit();
    }

    public void setViewTypeLayout(ViewTypeLayout viewTypeLayout) {
        viewTypeLayout = viewTypeLayout;
        notifyDataSetChanged();
    }

    public ViewTypeLayout getViewTypeLayout(){
        return viewTypeLayout;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;

        switch (getViewTypeLayout()) {
            case GRID_VIEW:
                System.out.println("11111111111111111111111111111111111111111111");
                view = inflater.inflate(R.layout.custom_grid_layout,parent,false);

                break;

//            case CAROUSEL_VIEW:
//                System.out.println("22222222222222222222222222222222222222222222");
//
////                view = inflater.inflate(R.layout.activity_carousel, parent, false);
////                view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//
//                break;

            case CAROUSEL_WITH_ACTUAL_ITEM_VIEW:
                view = inflater.inflate(R.layout.activity_carousel_list_product,parent,false);

                System.out.println("3333333333333333333333333333333333333333333");

                break;
        }

//        View view = inflater.inflate(R.layout.custom_grid_layout,parent,false);

        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getViewTypeLayout()) {
            case GRID_VIEW:
                GridViewHolder gridViewHolder = (GridViewHolder) holder;
                gridViewHolder.tvTitle.setText(productsList.get(position).getTitle());
                gridViewHolder.tvCode.setText(productsList.get(position).getCode());
                gridViewHolder.gridIcon.setImageResource(productsList.get(position).getImage());

                break;

            case CAROUSEL_VIEW:
//                CarouselViewHolder carouselViewHolder = (CarouselViewHolder) holder;
//                carouselViewHolder.tvTitle.setText(productsList.get(position).getTitle());
//                carouselViewHolder.tvCode.setText(productsList.get(position).getCode());
//                carouselViewHolder.image.setImageResource(productsList.get(position).getImage());

                break;

            case CAROUSEL_WITH_ACTUAL_ITEM_VIEW:
//                carouselWithActualItemViewHolder = (CarouselWithActualItemViewHolder) holder;
//                carouselWithActualItemViewHolder.tvTitle.setText(productsList.get(position).getTitle());
//                carouselWithActualItemViewHolder.tvCode.setText(productsList.get(position).getCode());
//                carouselWithActualItemViewHolder.image.setImageResource(productsList.get(position).getImage());

                break;
        }
    }


    @Override
    public int getItemCount() {
        return productsList.size();
    }

//    @Override
//    public void onProductSelected(Product product) {
//        carouselWithActualItemViewHolder.tvTitle.setText(product.getTitle());
//        carouselWithActualItemViewHolder.tvCode.setText(product.getCode());
//        carouselWithActualItemViewHolder.image.setImageResource(product.getImage());
//    }

    public class GridViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        TextView tvCode;
        ImageView gridIcon;

        public GridViewHolder(@NonNull final View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvCode = itemView.findViewById(R.id.tv_code);
            gridIcon = itemView.findViewById(R.id.iv_product);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Item: " + getAdapterPosition() + " presionado.", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

//    class CarouselViewHolder extends RecyclerView.ViewHolder {
//        TextView tvTitle;
//        TextView tvCode;
//        ImageView image;
//
//        public CarouselViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            tvTitle = itemView.findViewById(R.id.tv_title);
//            tvCode = itemView.findViewById(R.id.tv_code);
//            image = itemView.findViewById(R.id.iv_product);
//
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(v.getContext(), "Item: " + getAdapterPosition() + " presionado.", Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
//    }

//    class CarouselWithActualItemViewHolder extends RecyclerView.ViewHolder {
//        TextView tvTitle;
//        TextView tvCode;
//        ImageView image;
//
//        public CarouselWithActualItemViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            tvTitle = itemView.findViewById(R.id.tv_title);
//            tvCode = itemView.findViewById(R.id.tv_code);
//            image = itemView.findViewById(R.id.iv_product);
//
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(v.getContext(), "Item: " + getAdapterPosition() + " presionado.", Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
//    }
}
