package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UploadRegularSeller extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_regular_seller);

        // Top buttons
        findViewById(R.id.order_button).setOnClickListener(v -> {
            Intent intent = new Intent(UploadRegularSeller.this, CurrentOrderSeller.class);
            startActivity(intent);
        });

        findViewById(R.id.add_item_button).setOnClickListener(v -> {
            Intent intent = new Intent(UploadRegularSeller.this, UploadRegularSeller.class);
            startActivity(intent);
        });

        // Top buttons
        findViewById(R.id.regular_product).setOnClickListener(v -> {
            Intent intent = new Intent(UploadRegularSeller.this, UploadRegularSeller.class);
            startActivity(intent);
        });

        findViewById(R.id.bulk_amount).setOnClickListener(v -> {
            Intent intent = new Intent(UploadRegularSeller.this, UploadBulkSeller.class);
            startActivity(intent);
        });

        // Submit
        findViewById(R.id.btnSubmit).setOnClickListener(v -> {
            if (!findViewById(R.id.btnSubmit).isPressed()) {
                Toast.makeText(this, "You must pressed submit button", Toast.LENGTH_SHORT).show();
                return;
            }

            // After validation, go to next page
            Intent intent = new Intent(UploadRegularSeller.this, UploadRegularSeller.class); // replace with actual next page
            startActivity(intent);
        });

        // Bottom nav (TextViews as buttons)
        findViewById(R.id.tvShop).setOnClickListener(v -> {
            Intent intent = new Intent(UploadRegularSeller.this, ShopSeller.class);
            startActivity(intent);
        });

        findViewById(R.id.tvUpload).setOnClickListener(v -> {
            Intent intent = new Intent(UploadRegularSeller.this, UploadRegularSeller.class);
            startActivity(intent);
        });

        findViewById(R.id.tvHome).setOnClickListener(v -> {
            Intent intent = new Intent(UploadRegularSeller.this, HomeSellerActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.tvChat).setOnClickListener(v -> {
            Intent intent = new Intent(UploadRegularSeller.this, ChatSeller.class);
            startActivity(intent);
        });

        findViewById(R.id.tvDonate).setOnClickListener(v -> {
            Intent intent = new Intent(UploadRegularSeller.this, UploadBulkSeller.class);
            startActivity(intent);
        });








}}
