package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChatSeller extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        // Enable edge-to-edge display BEFORE super.onCreate() or setContentView()
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_seller);

        // --- Window Inset Logic ---
        // Find your topBar from the layout
        // --- Window Inset Logic ---
        // Find your topBar from the layout
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


        // Bottom nav (TextViews as buttons)
        findViewById(R.id.tvShop).setOnClickListener(v -> {
            Intent intent = new Intent(ChatSeller.this, ShopSeller.class);
            startActivity(intent);
        });

        findViewById(R.id.tvUpload).setOnClickListener(v -> {
            Intent intent = new Intent(ChatSeller.this, UploadRegularSeller.class);
            startActivity(intent);
        });

        findViewById(R.id.tvHome).setOnClickListener(v -> {
            Intent intent = new Intent(ChatSeller.this, HomeSellerActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.tvChat).setOnClickListener(v -> {
            Intent intent = new Intent(ChatSeller.this, ChatSeller.class);
            startActivity(intent);
        });

        findViewById(R.id.tvDonate).setOnClickListener(v -> {
            Intent intent = new Intent(ChatSeller.this, UploadBulkSeller.class);
            startActivity(intent);
        });

    }


}
