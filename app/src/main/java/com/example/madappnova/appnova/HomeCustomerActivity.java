package com.example.appnova;

import android.os.Bundle;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class HomeCustomerActivity extends AppCompatActivity {

    private RecyclerView rvFoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_customer);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() == null) {
            // User NOT logged in → go back to Login
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }

        rvFoods = findViewById(R.id.rvFoods);

        // 2 items per row, vertical scroll
        rvFoods.setLayoutManager(new GridLayoutManager(this, 2));
        rvFoods.setHasFixedSize(true);

        ArrayList<FoodItem> list = new ArrayList<>();
        // Put your food images in res/drawable, then use them here:
        list.add(new FoodItem(R.drawable.food_1, "Nasi Ayam Gepuk", "RM 11.90"));
        list.add(new FoodItem(R.drawable.food_2, "Nasi Lemak", "RM 7.50"));
        list.add(new FoodItem(R.drawable.croissant, "Croissant", "RM 6.00"));
        list.add(new FoodItem(R.drawable.food_4, "Roti Telur", "RM 3.50"));
        list.add(new FoodItem(R.drawable.food_3, "Spaghetti Bolognese", "RM 10.00"));
        list.add(new FoodItem(R.drawable.food_1, "Nasi Ayam Gepuk", "RM 11.90"));
        list.add(new FoodItem(R.drawable.food_4, "Roti Telur", "RM 3.50"));
        list.add(new FoodItem(R.drawable.food_2, "Nasi Lemak", "RM 7.50"));

        FoodAdapter adapter = new FoodAdapter(this, list, item ->
                Toast.makeText(this, item.getName(), Toast.LENGTH_SHORT).show()
        );

        rvFoods.setAdapter(adapter);

        TextView tvHome = findViewById(R.id.tvHomeCustomer);
        TextView tvShop = findViewById(R.id.tvShopCustomer);
        TextView tvOrder = findViewById(R.id.tvOrderCustomer);
        TextView tvChat = findViewById(R.id.tvChatCustomer);

// Home (current)
        tvHome.setOnClickListener(v -> {
            // already on home
        });

// Shop
        tvShop.setOnClickListener(v -> {
            startActivity(new Intent(this, ShopActivity.class));
        });

// Orders
        tvOrder.setOnClickListener(v -> {
            startActivity(new Intent(this, OrderActivity.class));
        });

// Chat
        tvChat.setOnClickListener(v -> {
            startActivity(new Intent(this, ChatCustomer.class));
        });

    }
}
