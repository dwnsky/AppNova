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
    SessionManager sessionManager;

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


        sessionManager = new SessionManager(this);
        // Find views
        etEmail2 = findViewById(R.id.etEmail2);
        etPassword2 = findViewById(R.id.etPassword2);
        btnSignUp2 = findViewById(R.id.btnSignUp2);

        // Button click
        btnSignUp2.setOnClickListener(v -> {
            String email = etEmail2.getText().toString().trim();
            String password = etPassword2.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // --- THIS IS THE CORRECTED LOGIC ---
            AppDatabase.databaseWriteExecutor.execute(() -> {
                // 1. Find a USER in the database with the matching email and password
                User user = AppDatabase.getDatabase(getApplicationContext()).userDao().login(email, password);

                // 2. Switch back to the Main Thread to update UI/Session
                runOnUiThread(() -> {
                    // 3. Check if a user was found AND if their userType is "Seller"
                    if (user != null && "Seller".equals(user.getUserType())) {
                        // SUCCESS: The user is a valid Seller

                        // 4. Save the user's data into the session
                        sessionManager.createLoginSession(
                                user.getId(),
                                user.getName(),
                                user.getEmail(),
                                user.getUserType()
                        );

                        Toast.makeText(LoginPageSellerActivity.this, "Welcome back, " + user.getName(), Toast.LENGTH_SHORT).show();

                        // Navigate to the seller's home page
                        Intent intent = new Intent(LoginPageSellerActivity.this, HomeSellerActivity.class);
                        // Clear the activity stack so the user can't press "back" to get to the login page
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish(); // Close the login activity

                    } else {
                        // FAILURE: Either the credentials are wrong or the user is not a seller
                        Toast.makeText(LoginPageSellerActivity.this, "Invalid Seller Email or Password", Toast.LENGTH_SHORT).show();
                    }
                });
            });
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
