package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ShopSeller extends AppCompatActivity {
    private ProductAdapter productAdapter;
    private ProductRepository productRepository;
    private SessionManager sessionManager;

    protected void onCreate(Bundle savedInstanceState) {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_seller);

        View topBar = findViewById(R.id.topBar);

        ViewCompat.setOnApplyWindowInsetsListener(topBar, (v, insets) -> {
            androidx.core.graphics.Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(v.getPaddingLeft(), systemBars.top, v.getPaddingRight(), v.getPaddingBottom());
            return insets;
        });

        // Top buttons
        findViewById(R.id.order_button).setOnClickListener(v -> {
            Intent intent = new Intent(ShopSeller.this, CurrentOrderSeller.class);
            startActivity(intent);
        });

        findViewById(R.id.add_item_button).setOnClickListener(v -> {
            Intent intent = new Intent(ShopSeller.this, UploadRegularSeller.class);
            startActivity(intent);
        });


        sessionManager = new SessionManager(this);
        productRepository = new ProductRepository(getApplication());

        // 1. Setup RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerViewOrder);
        productAdapter = new ProductAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(productAdapter);

        // 2. Get current seller ID from session
        int sellerId = sessionManager.getUserId();

        // 3. Load Data from DB linked to this Seller
        if (sellerId != -1) {
            // This method in your Repo returns LiveData<List<Product>>
            productRepository.getProductsBySellerLive(sellerId).observe(this, products -> {
                if (products != null) {
                    productAdapter.setProducts(products);
                }
            });


            // Bottom nav (TextViews as buttons)
            findViewById(R.id.tvShop).setOnClickListener(v -> {
                Intent intent = new Intent(ShopSeller.this, ShopSeller.class);
                startActivity(intent);
            });

            findViewById(R.id.tvUpload).setOnClickListener(v -> {
                Intent intent = new Intent(ShopSeller.this, UploadRegularSeller.class);
                startActivity(intent);
            });

            findViewById(R.id.tvHome).setOnClickListener(v -> {
                Intent intent = new Intent(ShopSeller.this, HomeSellerActivity.class);
                startActivity(intent);
            });

            findViewById(R.id.tvChat).setOnClickListener(v -> {
                Intent intent = new Intent(ShopSeller.this, ChatSeller.class);
                startActivity(intent);
            });

            findViewById(R.id.tvOrder).setOnClickListener(v -> {
                Intent intent = new Intent(ShopSeller.this, CurrentOrderSeller.class);
                startActivity(intent);
            });

            ImageView account = findViewById(R.id.imgPlaceholder);

            account.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ShopSeller.this, AccountActivity.class);
                    startActivity(intent);
                }
            });

        }
    }
}




