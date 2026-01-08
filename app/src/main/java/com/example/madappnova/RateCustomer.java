    package com.example.madappnova;

    import android.content.Intent;
    import android.os.Bundle;
    import android.widget.Button;
    import android.widget.ImageView;
    import android.widget.TextView;
    import android.widget.Toast;
    import androidx.appcompat.app.AppCompatActivity;

    public class RateCustomer extends AppCompatActivity {

        // Top Bar Views
        private ImageView menuIcon;

        // Content Views
        private Button btSubmit;

        // Bottom Navigation Views
        private TextView tvHomeCustomer;
        private TextView tvShopCustomer;
        private TextView tvOrderCustomer;
        private TextView tvChatCustomer;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.rate_customer);

            initializeViews();
            setupClickListeners();
        }

        private void initializeViews() {
            // Top Bar
            menuIcon = findViewById(R.id.menuIcon);

            // Content
            btSubmit = findViewById(R.id.btSubmit);

            // Bottom Navigation
            tvHomeCustomer = findViewById(R.id.tvHomeCustomer);
            tvShopCustomer = findViewById(R.id.tvShopCustomer);
            tvOrderCustomer = findViewById(R.id.tvOrderCustomer);
            tvChatCustomer = findViewById(R.id.tvChatCustomer);
        }

        private void setupClickListeners() {
            // Menu Icon Click
            if (menuIcon != null) {
                menuIcon.setOnClickListener(v -> Toast.makeText(RateCustomer.this, "Menu clicked", Toast.LENGTH_SHORT).show());
            }

            // Submit Button Click
            if (btSubmit != null) {
                btSubmit.setOnClickListener(v -> {
                    Toast.makeText(RateCustomer.this, "Rating submitted!", Toast.LENGTH_SHORT).show();
                    // Navigate back to orders or home
                    finish();
                });
            }

            // Bottom nav
            if (tvHomeCustomer != null) {
                tvHomeCustomer.setOnClickListener(v -> navigateToActivity(ItemCustomer.class));
            }
            if (tvShopCustomer != null) {
                tvShopCustomer.setOnClickListener(v -> navigateToActivity(ShopCustomer.class));
            }
            if (tvOrderCustomer != null) {
                tvOrderCustomer.setOnClickListener(v -> navigateToActivity(OrderCustomer.class));
            }
            if (tvChatCustomer != null) {
                tvChatCustomer.setOnClickListener(v -> navigateToActivity(ChatCustomer.class));
            }
        }

        private void navigateToActivity(Class<?> targetActivity) {
            Intent intent = new Intent(RateCustomer.this, targetActivity);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }
