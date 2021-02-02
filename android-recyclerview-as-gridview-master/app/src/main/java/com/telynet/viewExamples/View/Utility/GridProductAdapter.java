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
//    private CarouselFragment.CarouselFragmentListener carouselFragmentListener;
    private Product actualProduct;
    private ActualProductFragment actualProductFragment;

    public GridProductAdapter(Context context, List<Product> products, ActualProductFragment actualProductFragment){
        this.productsList = products;
        this.inflater = LayoutInflater.from(context);
        this.actualProductFragment = actualProductFragment;

    }

    public GridProductAdapter(Context context, List<Product> products){
        this.productsList = products;
        this.inflater = LayoutInflater.from(context);
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

//    public void setCarouselFragmentListener(CarouselFragment.CarouselFragmentListener carouselFragmentListener){
//        carouselFragmentListener = carouselFragmentListener;
//    }

//    public void setActualProductFragment(Fragment actualProductFragment){
//        this.actualProductFragment = (ActualProductFragment) actualProductFragment;
//    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        TextView tvCode;
        ImageView gridIcon;
//        ActualProductFragment fragment = actualProductFragment;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvCode = itemView.findViewById(R.id.tv_code);
            gridIcon = itemView.findViewById(R.id.iv_product);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int a = getAdapterPosition();
                    Toast.makeText(v.getContext(), "Item: " + getAdapterPosition() + " presionado.", Toast.LENGTH_SHORT).show();
                    actualProduct = productsList.get(getAdapterPosition());
//                    fragment.updateActualProduct(actualProduct);

//                    actualProductFragment.updateActualProduct(actualProduct);
                    CarouselListProductActivity carouselListProductActivity = (CarouselListProductActivity) itemView.getContext();
                    carouselListProductActivity.updateActualProductFragment(actualProduct);
//                    fragment.updateActualProduct(actualProduct);
//                    carouselFragmentListener.onProductSelected(productsList.get(getAdapterPosition()));
                }
            });
        }

//        public void setActualProductFragment(Fragment actualProductFragmetn){
//            fragment = actualProductFragment;
//        }
    }
}
