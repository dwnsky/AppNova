package com.example.appnovavolunteer;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.appnovavolunteer.databinding.ActivityRewardsBinding;
import java.util.Locale;

public class RewardsActivity extends AppCompatActivity {

    // 1. Pastikan nama ni sebiji macam nama fail XML (ActivityRewardsBinding)
    private ActivityRewardsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 2. Setup Binding
        binding = ActivityRewardsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 3. Countdown Timer (10 Jam)
        // Kalau tvTimer merah, maksudnya ID kat XML tak kena dengan binding
        new CountDownTimer(38722000, 1000) {
            public void onTick(long millisUntilFinished) {
                int hours = (int) (millisUntilFinished / (1000 * 60 * 60));
                int minutes = (int) (millisUntilFinished / (1000 * 60)) % 60;
                int seconds = (int) (millisUntilFinished / 1000) % 60;
                String timeLeft = String.format(Locale.getDefault(), "Time Remaining: %02d:%02d:%02d", hours, minutes, seconds);

                if (binding.tvTimer != null) {
                    binding.tvTimer.setText(timeLeft);
                }
            }
            public void onFinish() {
                binding.tvTimer.setText("Time Remaining: 00:00:00");
            }
        }.start();

        // 4. Button Claim
        binding.btnClaim.setOnClickListener(v -> {
            Toast.makeText(this, "50 Points Claimed!", Toast.LENGTH_SHORT).show();
        });

        // 5. Bottom Navigation
        binding.btnHomeNav.setOnClickListener(v -> {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        });
    }
}