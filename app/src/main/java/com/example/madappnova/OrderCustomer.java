package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class OrderCustomer extends AppCompatActivity {

    // Assuming the same bottom navigation IDs as other customer screens
    private TextView tvHomeCustomer;
    private TextView tvShopCustomer;
    private TextView tvOrderCustomer;
    private TextView tvChatCustomer;
    private ImageButton rateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_customer); // Set the layout for this activity

        initializeViews();
        setupNavigationListeners();
    }

    private void initializeViews() {
        tvHomeCustomer = findViewById(R.id.tvHomeCustomer);
        tvShopCustomer = findViewById(R.id.tvShopCustomer);
        tvOrderCustomer = findViewById(R.id.tvOrderCustomer);
        tvChatCustomer = findViewById(R.id.tvChatCustomer);
        rateBtn = findViewById(R.id.imageButton); // Assuming this is the ID of your rate button
    }

    private void setupNavigationListeners() {
        if (tvHomeCustomer != null) {
            tvHomeCustomer.setOnClickListener(v -> navigateToActivity(ItemCustomer.class));
        }

        if (tvShopCustomer != null) {
            tvShopCustomer.setOnClickListener(v -> navigateToActivity(ShopCustomer.class));
        }

        // Order is the current screen, so no listener needed for the bottom nav.

        if (tvChatCustomer != null) {
            tvChatCustomer.setOnClickListener(v -> navigateToActivity(ChatCustomer.class));
        }

        if (rateBtn != null) {
            rateBtn.setOnClickListener(v -> navigateToActivity(RateCustomer.class));
        }
    }

    private void navigateToActivity(Class<?> targetActivity) {
        Intent intent = new Intent(OrderCustomer.this, targetActivity);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Highlight the current tab
        if (tvOrderCustomer != null) {
            tvOrderCustomer.setTextColor(getResources().getColor(android.R.color.black));
        }
    }
}
