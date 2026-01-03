package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class WelcomePageActivity extends AppCompatActivity {

    AppCompatButton btnNext, getStartedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);

        btnNext = findViewById(R.id.btnNext);
        getStartedButton = findViewById(R.id.get_started_button);

        // btnNext click
        btnNext.setOnClickListener(v -> openLoadingPage());

        // get started button click
        getStartedButton.setOnClickListener(v -> openLoadingPage());
    }

    private void openLoadingPage() {
        Intent intent = new Intent(WelcomePageActivity.this, LoadingPageActivity.class);
        startActivity(intent);
        finish(); // optional: prevents going back to welcome page
    }
}

