package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class ForgotPasswordPage2 extends AppCompatActivity {
    EditText etPassword, etConfirmPassword;
    Button saveBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password_page2);

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

        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        saveBtn = findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(v -> {
            // Optional: validate inputs
            String password = etPassword.getText().toString();
            String confirmPassword = etConfirmPassword.getText().toString();

            if(password.isEmpty() || confirmPassword.isEmpty()){
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            if(!password.equals(confirmPassword)){
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                return;
            }

            // After validation, go to next page
            Intent intent = new Intent(ForgotPasswordPage2.this, ForgotPasswordPage3.class); // replace with actual next page
            startActivity(intent);
        });
    }}