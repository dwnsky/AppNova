package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterPageActivity extends AppCompatActivity {

    EditText etName, etEmail, etPassword, etConfirmPassword;
    Button btnSignUp;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);

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
        etName = findViewById(R.id.etName); // replace with actual ID
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        radioButton= findViewById(R.id.radioButton);

        // Button click
        btnSignUp.setOnClickListener(v -> {
            // Optional: validate inputs
            String name = etName.getText().toString();
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();
            String confirmPassword = etConfirmPassword.getText().toString();

            if(name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            if(!password.equals(confirmPassword)){
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                return;
            }

            // Check if user agreed to terms
            if (!radioButton.isChecked()) {
                Toast.makeText(this, "You must agree to the terms to continue", Toast.LENGTH_SHORT).show();
                return;
            }

            // After validation, go to next page
            Intent intent = new Intent(RegisterPageActivity.this, LoginPageSellerActivity.class); // replace with actual next page
            startActivity(intent);
        });

        TextView signin = findViewById(R.id.textView15);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterPageActivity.this, LoginPageSellerActivity.class);
                startActivity(intent);
            }
        });
    }
}

