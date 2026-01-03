package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginPageSellerActivity extends AppCompatActivity {

    EditText etEmail2, etPassword2;
    Button btnSignUp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page_seller);

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

        // Find views

        etEmail2 = findViewById(R.id.etEmail2);
        etPassword2 = findViewById(R.id.etPassword2);
        btnSignUp2 = findViewById(R.id.btnSignUp2);

        // Button click
        btnSignUp2.setOnClickListener(v -> {
            // Optional: validate inputs
            String email = etEmail2.getText().toString();
            String password = etPassword2.getText().toString();

            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // After validation, go to next page
            Intent intent = new Intent(LoginPageSellerActivity.this, HomeSellerActivity.class); // replace with actual next page
            startActivity(intent);
        });

        TextView forgotPassword = findViewById(R.id.forgotPassword);

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPageSellerActivity.this, ForgotPasswordPage1.class);
                startActivity(intent);
            }
        });
    }}
