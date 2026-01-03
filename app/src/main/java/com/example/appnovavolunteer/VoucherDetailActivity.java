package com.example.appnovavolunteer;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.appnovavolunteer.databinding.ActivityVoucherDetailBinding;

public class VoucherDetailActivity extends AppCompatActivity {

    private ActivityVoucherDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVoucherDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Butang Back
        binding.btnBack.setOnClickListener(v -> finish());

        // Butang Redeem Now
        binding.btnRedeemNow.setOnClickListener(v -> {
            Toast.makeText(this, "Voucher successfully redeemed!", Toast.LENGTH_SHORT).show();
        });
    }
}