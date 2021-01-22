package com.telynet.viewExamples.View.Utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.telynet.viewExamples.Model.Product;
import com.telynet.viewExamples.R;

import java.util.List;

import io.github.vejei.carouselview.CarouselAdapter;

public class PageAdapter extends CarouselAdapter<PageAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<Product> productsList;

    public PageAdapter(Context context, List<Product> products){
        this.productsList = products;
        this.inflater = LayoutInflater.from(context);
    }

//
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = inflater.inflate(R.layout.custom_grid_layout,parent,false);
//        return new ViewHolder(view);
//    }

    @Override
    public ViewHolder onCreatePageViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_carousel_layout, parent,false);
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        return new ViewHolder(view);
    }

    @Override
    public void onBindPageViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(productsList.get(position).getTitle());
        holder.tvCode.setText(productsList.get(position).getCode());
        holder.image.setImageResource(productsList.get(position).getImage());
    }

    @Override
    public int getPageCount() {
        return productsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvCode;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_title);
            tvCode = itemView.findViewById(R.id.tv_codes);
            image = itemView.findViewById(R.id.iv_product);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Item: " + getAdapterPosition() + " presionado.", Toast.LENGTH_SHORT).show();
                }
            });
        }
//private val backgroundImageView = itemView.findViewById<ImageView>(R.id.view_background)
//private val contentTextView = itemView.findViewById<TextView>(R.id.text_view_content)
//
//        fun bind(page: Page) {
//        backgroundImageView.clipToOutline = true
//        backgroundImageView.setImageResource(page.imageRes)
//        contentTextView.text = page.content
//        }
        }
}
