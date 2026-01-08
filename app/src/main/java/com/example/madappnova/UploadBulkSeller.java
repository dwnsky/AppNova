package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class UploadBulkSeller extends AppCompatActivity {
    private ProductRepository productRepository;
    private SessionManager sessionManager;
    protected void onCreate(Bundle savedInstanceState) {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_bulk_seller);

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

        // Top buttons
        findViewById(R.id.order_button).setOnClickListener(v -> {
            Intent intent = new Intent(UploadBulkSeller.this, CurrentOrderSeller.class);
            startActivity(intent);
        });

        findViewById(R.id.add_item_button).setOnClickListener(v -> {
            Intent intent = new Intent(UploadBulkSeller.this, UploadRegularSeller.class);
            startActivity(intent);
        });

        // Top buttons
        findViewById(R.id.regular_product).setOnClickListener(v -> {
            Intent intent = new Intent(UploadBulkSeller.this, UploadRegularSeller.class);
            startActivity(intent);
        });

        findViewById(R.id.bulk_amount).setOnClickListener(v -> {
            Intent intent = new Intent(UploadBulkSeller.this, UploadBulkSeller.class);
            startActivity(intent);
        });

        productRepository = new ProductRepository(getApplication());
        sessionManager = new SessionManager(this);

        TextInputEditText etProductName = findViewById(R.id.etProductName);
        TextInputEditText etOriginalPrice = findViewById(R.id.etOriginalPrice);
        TextInputEditText etDiscountedPrice = findViewById(R.id.etDiscountedPrice);
        TextInputEditText etDiscountPercent = findViewById(R.id.etDiscountPercent);
        EditText etImageName = findViewById(R.id.etImageName);
        TextInputEditText etUploadDate = findViewById(R.id.etUploadDate);
        TextInputEditText etBestBefore = findViewById(R.id.etBestBefore);
        TextInputEditText etQuantity = findViewById(R.id.etQuantity);

        findViewById(R.id.btnSubmit).setOnClickListener(v -> {
            // Get data from fields
            String name = etProductName.getText().toString().trim();
            String priceStr = etOriginalPrice.getText().toString().trim();
            String discPriceStr = etDiscountedPrice.getText().toString().trim();
            String percentStr = etDiscountPercent.getText().toString().trim();
            String imageName = etImageName.getText().toString().trim();
            String uploadDate = etUploadDate.getText().toString().trim();
            String bestBefore = etBestBefore.getText().toString().trim();
            String quantity = etQuantity.getText().toString().trim();


            // Simple Validation
            if (name.isEmpty() || priceStr.isEmpty()) {
                Toast.makeText(this, "Product Name and Price are required", Toast.LENGTH_SHORT).show();
                return;
            }

            // Get Current Seller ID from Session
            int currentSellerId = sessionManager.getUserId();

            // 4. Create Product Object and Link Data
            Product product = new Product();
            product.setSellerId(currentSellerId);
            product.setName(name);

            // Convert Strings to Numbers safely
            try {
                product.setOriginalPrice(Double.parseDouble(priceStr));
                product.setDiscountedPrice(discPriceStr.isEmpty() ? 0 : Double.parseDouble(discPriceStr));
                product.setDiscountPercentage(percentStr.isEmpty() ? 0 : Integer.parseInt(percentStr));
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Please enter valid numbers for price", Toast.LENGTH_SHORT).show();
                return;
            }

            product.setUploadedDate(uploadDate);
            product.setBestBeforeDate(bestBefore);
            // Use the name from imageNameLayout for the image URL
            // If empty, use a default placeholder
            product.setImageUrl(imageName.isEmpty() ? "dona_bakery" : imageName);

            product.setActive(true);
            //product.setUploadedDate(System.currentTimeMillis());

            // 5. Save to Database
            productRepository.addProduct(product);

            Toast.makeText(this, "Success: Product added to your shop!", Toast.LENGTH_SHORT).show();

            // 6. Redirect to Shop to view the list
            Intent intent = new Intent(UploadBulkSeller.this, ShopSeller.class);
            startActivity(intent);
            finish();
        });

        // Bottom nav (TextViews as buttons)
        findViewById(R.id.tvShop).setOnClickListener(v -> {
            Intent intent = new Intent(UploadBulkSeller.this, ShopSeller.class);
            startActivity(intent);
        });

        findViewById(R.id.tvUpload).setOnClickListener(v -> {
            Intent intent = new Intent(UploadBulkSeller.this, UploadRegularSeller.class);
            startActivity(intent);
        });

        findViewById(R.id.tvHome).setOnClickListener(v -> {
            Intent intent = new Intent(UploadBulkSeller.this, HomeSellerActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.tvChat).setOnClickListener(v -> {
            Intent intent = new Intent(UploadBulkSeller.this, ChatSeller.class);
            startActivity(intent);
        });

        findViewById(R.id.tvOrder).setOnClickListener(v -> {
            Intent intent = new Intent(UploadBulkSeller.this, CurrentOrderSeller.class);
            startActivity(intent);
        });


        ImageView account = findViewById(R.id.imgPlaceholder);

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UploadBulkSeller.this, AccountActivity.class);
                startActivity(intent);
            }
        });
    }
}
