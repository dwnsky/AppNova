package com.example.madappnova;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class HomeSellerActivity extends AppCompatActivity {

    Button add_item_button, order_button;
    private ProductAdapter productAdapter;
    private ProductRepository productRepository;
    private SessionManager sessionManager;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_seller);

        View topBar = findViewById(R.id.topBar);

        // Listen for insets and apply padding only to the top
        ViewCompat.setOnApplyWindowInsetsListener(topBar, (v, insets) -> {
            // Get the insets for the system bars (status bar, navigation bar)
            // THIS IS THE CORRECTED LINE:
            androidx.core.graphics.Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());

            // Apply the top inset as top padding to the topBar, keeping original L/R/B padding
            v.setPadding(v.getPaddingLeft(), systemBars.top, v.getPaddingRight(), v.getPaddingBottom());

            // Return the insets so other views can use them if needed
            return insets;
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
        }
        // Bottom nav (TextViews as buttons)
        findViewById(R.id.tvShop).setOnClickListener(v -> {
            Intent intent = new Intent(HomeSellerActivity.this, ShopSeller.class);
            startActivity(intent);
        });

        findViewById(R.id.tvUpload).setOnClickListener(v -> {
            Intent intent = new Intent(HomeSellerActivity.this, UploadRegularSeller.class);
            startActivity(intent);
        });

        findViewById(R.id.tvHome).setOnClickListener(v -> {
            Intent intent = new Intent(HomeSellerActivity.this, HomeSellerActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.tvChat).setOnClickListener(v -> {
            Intent intent = new Intent(HomeSellerActivity.this, ChatSeller.class);
            startActivity(intent);
        });

        findViewById(R.id.tvOrder).setOnClickListener(v -> {
            Intent intent = new Intent(HomeSellerActivity.this, CurrentOrderSeller.class);
            startActivity(intent);
        });

        ImageView account = findViewById(R.id.imgPlaceholder);

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeSellerActivity.this, AccountActivity.class);
                startActivity(intent);
            }
        });

    }
}

