package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

public class LoadingPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_page);

         // Delay 3 seconds (3000ms) then go to next page
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent intent = new Intent(LoadingPageActivity.this, FrameActivity.class);
            startActivity(intent);
            finish(); // prevent going back to loading page
        }, 3000); // 3 seconds
    }
}
