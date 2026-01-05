package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class WelcomePageActivity extends AppCompatActivity {

    AppCompatButton btnNext, getStartedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);

        // 2. Get the root view of your layout
        View rootView = findViewById(android.R.id.content);
        if (rootView == null) {
            // Fallback for some edge cases
            rootView = getWindow().getDecorView().findViewById(android.R.id.content);
        }
        final View finalRootView = rootView;


        // 3. Listen for insets and apply padding ONLY to the top of the root view
        ViewCompat.setOnApplyWindowInsetsListener(finalRootView, (v, insets) -> {
            androidx.core.graphics.Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());

            // Apply the top inset as top padding to the whole view
            v.setPadding(
                    systemBars.left,   // Also respect left inset for cutouts
                    systemBars.top,
                    systemBars.right,  // Also respect right inset for cutouts
                    v.getPaddingBottom() // Keep the original bottom padding
            );

            // Return the insets so other views (like the keyboard) can use them
            return insets;
        });

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