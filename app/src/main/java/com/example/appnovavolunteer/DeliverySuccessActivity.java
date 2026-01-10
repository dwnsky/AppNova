package com.example.appnovavolunteer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class DeliverySuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliverysuccess);

        Button btnBackHome = findViewById(R.id.btnBackHome);

        btnBackHome.setOnClickListener(v -> {
            // Aliran: Delivery Success -> Activity Success
            Intent intent = new Intent(this, SuccessfulActivity.class);
            startActivity(intent);
            finish(); // Tutup skrin ini
        });
    }
}