package com.telynet.viewExamples.View.Utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.telynet.viewExamples.Model.Product;
import com.telynet.viewExamples.R;
import com.telynet.viewExamples.View.CarouselAndActualItem.ActualProductFragment;
import com.telynet.viewExamples.View.CarouselAndActualItem.CarouselFragment;
import com.telynet.viewExamples.View.CarouselAndActualItem.CarouselListProductActivity;

import java.util.List;

public class GridProductAdapter extends RecyclerView.Adapter<GridProductAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<Product> productsList;
    private  Context ctx;
//    private CarouselFragment.CarouselFragmentListener carouselFragmentListener;
    private Product actualProduct;
    private CarouselFragment carouselFragment;

    public GridProductAdapter(Context context, List<Product> products){
        this.productsList = products;
        this.inflater = LayoutInflater.from(context);
     //   this.carouselFragment = carouselFragment;
//        this.actualProductFragment = actualProductFragment;
    }


    public GridProductAdapter(Context context, List<Product> products, CarouselFragment carouselFragment){
        this.productsList = products;
        this.inflater = LayoutInflater.from(context);
        this.carouselFragment = carouselFragment;
//        this.actualProductFragment = actualProductFragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_carousel_item_layout,parent,false);
//        View view = inflater.inflate(R.layout.custom_grid_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(productsList.get(position).getTitle());
        holder.tvCode.setText(productsList.get(position).getCode());
        holder.gridIcon.setImageResource(productsList.get(position).getImage());
//        holder.setActualProductFragment(actualProductFragment);
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        TextView tvCode;
        ImageView gridIcon;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvCode = itemView.findViewById(R.id.tv_code);
            gridIcon = itemView.findViewById(R.id.iv_product);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    actualProduct = productsList.get(getAdapterPosition());
                    carouselFragment.updateMainProduct(actualProduct);
                }
            });
        }
    }
}
