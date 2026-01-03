package com.example.madappnova;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class HomeSellerActivity extends AppCompatActivity {

    Button add_item_button,order_button;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_seller);



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

        findViewById(R.id.tvDonate).setOnClickListener(v -> {
            Intent intent = new Intent(HomeSellerActivity.this, UploadBulkSeller.class);
            startActivity(intent);
        });



    }}

