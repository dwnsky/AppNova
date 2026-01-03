package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordPage3 extends AppCompatActivity {

    TextView loginBtn = findViewById(R.id.loginBtn);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password_page3);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotPasswordPage3.this, LoginPageSellerActivity.class);
                startActivity(intent);
            }
        });
    }}
