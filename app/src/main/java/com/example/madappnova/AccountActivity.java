package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AccountActivity extends AppCompatActivity {
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_page_seller);

        session = new SessionManager(this);

        // Display user info
        TextView tvName = findViewById(R.id.tvName);
        TextView tvEmail = findViewById(R.id.tvEmail);

        tvName.setText(session.getUserName());
        tvEmail.setText(session.getUserEmail());

        // Logout button
        findViewById(R.id.imageButton2).setOnClickListener(v -> {
            session.logout();
            Intent intent = new Intent(this, LoginPageSellerActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });

        findViewById(R.id.button3).setOnClickListener(v -> {
            finish();
        });
    }
}
