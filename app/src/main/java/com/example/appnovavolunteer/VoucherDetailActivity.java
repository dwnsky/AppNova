package com.example.appnovavolunteer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class VoucherDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voucher_detail);

        // Inisialisasi butang sedia ada
        ImageButton btnBack = findViewById(R.id.btnBack);
        Button btnRedeemNow = findViewById(R.id.btnRedeemNow);

        if (btnBack != null) btnBack.setOnClickListener(v -> finish());

        if (btnRedeemNow != null) {
            btnRedeemNow.setOnClickListener(v ->
                    Toast.makeText(this, "Voucher Redeemed Successfully!", Toast.LENGTH_SHORT).show());
        }

        // Setup Navigasi Bawah
        setupNavClick(R.id.btnHomeNav, HomeActivity.class);
        setupNavClick(R.id.btnNotifNav, ChatActivity.class);
        setupNavClick(R.id.btnProfileNav, AccountActivity.class);
    }

    private void setupNavClick(int viewId, Class<?> target) {
        View v = findViewById(viewId);
        if (v != null) {
            v.setOnClickListener(view -> {
                Intent intent = new Intent(this, target);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            });
        }
    }
}