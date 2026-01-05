package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ItemCustomer extends AppCompatActivity {

    // Top Bar Views
    private ImageView menuIcon;
    private TextView tvShopName;
    private ImageView imgPlaceholder;

    // Product Views
    private ImageView imgProduct;
    private TextView tvDetails;
    private Button btConfirm;

    // Bottom Navigation Views
    private TextView tvHomeCustomer;
    private TextView tvShopCustomer;
    private TextView tvOrderCustomer;
    private TextView tvChatCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_customer);

        // Initialize views
        initializeViews();

        // Set up click listeners
        setupClickListeners();
    }

    private void initializeViews() {
        // Top Bar
        menuIcon = findViewById(R.id.menuIcon);
        tvShopName = findViewById(R.id.tvShopName);
        imgPlaceholder = findViewById(R.id.imgPlaceholder);

        // Product Details
        imgProduct = findViewById(R.id.imgProduct53);
        tvDetails = findViewById(R.id.tvDetails53);
        btConfirm = findViewById(R.id.btConfirm);

        // Bottom Navigation
        tvHomeCustomer = findViewById(R.id.tvHomeCustomer);
        tvShopCustomer = findViewById(R.id.tvShopCustomer);
        tvOrderCustomer = findViewById(R.id.tvOrderCustomer);
        tvChatCustomer = findViewById(R.id.tvChatCustomer);
    }

    private void setupClickListeners() {
        // Menu Icon Click
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Open menu/drawer
                Toast.makeText(ItemCustomer.this, "Menu clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Confirm Button Click
        btConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Handle confirm action (add to cart, purchase, etc.)
                Toast.makeText(ItemCustomer.this, "Order confirmed!", Toast.LENGTH_SHORT).show();
            }
        });

        // Bottom nav (TextViews as buttons)
        findViewById(R.id.tvHomeCustomer).setOnClickListener(v -> {
            Intent intent = new Intent(ItemCustomer.this, ItemCustomer.class);
            startActivity(intent);
        });

        findViewById(R.id.tvShopCustomer).setOnClickListener(v -> {
            Intent intent = new Intent(ItemCustomer.this, ShopCustomer.class);
            startActivity(intent);
        });

        findViewById(R.id.tvOrderCustomer).setOnClickListener(v -> {
            Intent intent = new Intent(ItemCustomer.this, OrderCustomer.class);
            startActivity(intent);
        });

        findViewById(R.id.tvChatCustomer).setOnClickListener(v -> {
            Intent intent = new Intent(ItemCustomer.this, ChatCustomer.class);
            startActivity(intent);
        });
    }

}