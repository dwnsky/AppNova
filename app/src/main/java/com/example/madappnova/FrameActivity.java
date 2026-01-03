package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FrameActivity extends AppCompatActivity {

    Button sellerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame);

        sellerBtn = findViewById(R.id.sellerBtn);

        sellerBtn.setOnClickListener(v -> {
            Intent intent = new Intent(FrameActivity.this, RegisterPageActivity.class);
            startActivity(intent);
        });
    }
}
