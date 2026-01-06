package com.example.madappnova;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.madappnova.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> productList;
    private Context context;

    public ProductAdapter(Context context) {
        this.context = context;
        this.productList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_card, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);

        holder.tvProductName.setText(product.getName());

        String details = "Uploaded: " + product.getUploadedDate() + "\n" +
                "Best before: " + product.getBestBeforeDate() + "\n" +
                "RM" + String.format("%.2f", product.getOriginalPrice()) +
                " RM" + String.format("%.2f", product.getDiscountedPrice()) + "\n" +
                product.getDiscountPercentage() + "% OFF!" + "\n" +
                "Quantity: " + product.getQuantityAvailable();

        holder.tvProductDetails.setText(details);

        // Load image from drawable resources
        String imageName = product.getImageUrl();

        // 2. Check if the image name is not null and not empty
        if (imageName != null && !imageName.isEmpty()) {
            // 3. Get the resource ID only if the name is valid
            int imageResId = context.getResources().getIdentifier(
                    imageName,
                    "drawable",
                    context.getPackageName()
            );

            // 4. Set the image if the resource was found, otherwise set a placeholder
            if (imageResId != 0) {
                holder.imgProduct.setImageResource(imageResId);
            } else {
                // Optional but recommended: set a default "image not found" placeholder
                holder.imgProduct.setImageResource(R.drawable.dona_bakery); // Use a generic placeholder drawable
            }
        } else {
            // Handle the case where the image URL is null or empty
            holder.imgProduct.setImageResource(R.drawable.dona_bakery); // Use a generic placeholder drawable
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void setProducts(List<Product> products) {
        this.productList = products;
        notifyDataSetChanged();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView tvProductName;
        TextView tvProductDetails;
        ImageView imgProduct;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvProductDetails = itemView.findViewById(R.id.tvProductDetails);
            imgProduct = itemView.findViewById(R.id.imgProduct);
        }
    }
}