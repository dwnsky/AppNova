package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoadingPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_page);

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

         // Delay 3 seconds (3000ms) then go to next page
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent intent = new Intent(LoadingPageActivity.this, FrameActivity.class);
            startActivity(intent);
            finish(); // prevent going back to loading page
        }, 3000); // 3 seconds
    }
}
