package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterPageActivity extends AppCompatActivity {

    EditText etName, etEmail, etPassword, etConfirmPassword;
    Button btnSignUp;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);

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
    }
}

