package com.telynet.viewExamples.View.CarouselAndActualItem.Utility;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
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
    private int itemPosition;

    public CarouselAndActualItemAdapter(Context context, List<Product> products, CarouselFragment carouselFragment){
        this.productsList = products;
        this.inflater = LayoutInflater.from(context);
        this.carouselFragment = carouselFragment;

        //Inicializa vista de item actual con el primer producto de la lista
        itemPosition = 0;
        carouselFragment.updateMainProduct(productsList.get(itemPosition));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_carousel_item_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tvTitle.setText(productsList.get(position).getTitle());
        holder.tvCode.setText(productsList.get(position).getCode());
        holder.gridIcon.setImageResource(productsList.get(position).getImage());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemPosition = position;
                actualProduct = productsList.get(position);
                carouselFragment.updateMainProduct(actualProduct);

                notifyDataSetChanged();
            }
        });

        if(itemPosition == position){
            holder.cardView.setBackgroundColor(Color.parseColor("#008577"));
            holder.constraintLayout.setBackgroundColor(Color.WHITE);
        } else {
            holder.constraintLayout.setBackgroundColor(Color.parseColor("#ffffff"));
            holder.cardView.setBackgroundColor(Color.parseColor("#ffffff"));
        }
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        TextView tvCode;
        ImageView gridIcon;
        CardView cardView;
        ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvCode = itemView.findViewById(R.id.tv_code);
            gridIcon = itemView.findViewById(R.id.iv_product);
            cardView = itemView.findViewById(R.id.card_view);
            constraintLayout = itemView.findViewById(R.id.constrain_layout);
        }
    }
}
