package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PastOrderSeller extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.past_order_seller);

        // Top buttons
        findViewById(R.id.order_button).setOnClickListener(v -> {
            Intent intent = new Intent(PastOrderSeller.this, CurrentOrderSeller.class);
            startActivity(intent);
        });

        findViewById(R.id.add_item_button).setOnClickListener(v -> {
            Intent intent = new Intent(PastOrderSeller.this, UploadRegularSeller.class);
            startActivity(intent);
        });

        // Top buttons
        findViewById(R.id.current_order).setOnClickListener(v -> {
            Intent intent = new Intent(PastOrderSeller.this, CurrentOrderSeller.class);
            startActivity(intent);
        });

        findViewById(R.id.past_order).setOnClickListener(v -> {
            Intent intent = new Intent(PastOrderSeller.this, PastOrderSeller.class);
            startActivity(intent);
        });

        // Submit
        findViewById(R.id.btnChat).setOnClickListener(v -> {
            if (!findViewById(R.id.btnChat).isPressed()) {
                Toast.makeText(this, "You must pressed submit button", Toast.LENGTH_SHORT).show();
                return;
            }

            // After validation, go to next page
            Intent intent = new Intent(PastOrderSeller.this, ChatSeller.class); // replace with actual next page
            startActivity(intent);
        });
        // Bottom nav (TextViews as buttons)
        findViewById(R.id.tvShop).setOnClickListener(v -> {
            Intent intent = new Intent(PastOrderSeller.this, ShopSeller.class);
            startActivity(intent);
        });

        findViewById(R.id.tvUpload).setOnClickListener(v -> {
            Intent intent = new Intent(PastOrderSeller.this, UploadRegularSeller.class);
            startActivity(intent);
        });

        findViewById(R.id.tvHome).setOnClickListener(v -> {
            Intent intent = new Intent(PastOrderSeller.this, HomeSellerActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.tvChat).setOnClickListener(v -> {
            Intent intent = new Intent(PastOrderSeller.this, ChatSeller.class);
            startActivity(intent);
        });

        findViewById(R.id.tvDonate).setOnClickListener(v -> {
            Intent intent = new Intent(PastOrderSeller.this, UploadBulkSeller.class);
            startActivity(intent);
        });

    }
}
