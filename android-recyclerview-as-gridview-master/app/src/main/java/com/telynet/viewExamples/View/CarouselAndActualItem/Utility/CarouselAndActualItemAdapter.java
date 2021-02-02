package com.telynet.viewExamples.View.CarouselAndActualItem.Utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.telynet.viewExamples.Model.Product;
import com.telynet.viewExamples.R;
import com.telynet.viewExamples.View.CarouselAndActualItem.CarouselFragment;

import java.util.List;

public class CarouselAndActualItemAdapter extends RecyclerView.Adapter<CarouselAndActualItemAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<Product> productsList;
    private Product actualProduct;
    private CarouselFragment carouselFragment;

    public CarouselAndActualItemAdapter(Context context, List<Product> products, CarouselFragment carouselFragment){
        this.productsList = products;
        this.inflater = LayoutInflater.from(context);
        this.carouselFragment = carouselFragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_carousel_item_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(productsList.get(position).getTitle());
        holder.tvCode.setText(productsList.get(position).getCode());
        holder.gridIcon.setImageResource(productsList.get(position).getImage());
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
