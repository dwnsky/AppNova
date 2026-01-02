package com.example.appnovavolunteer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.appnovavolunteer.databinding.ActivityMapsBinding;

public class MapsActivity extends AppCompatActivity { // Tukar ke AppCompatActivity

    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Klik butang Close (X) balik ke page sebelum
        binding.btnClose.setOnClickListener(v -> finish());

        // Klik butang Next - Bawa ke page Fridge Search (Imej Marker Hijau/Kelabu)
        binding.btnNext.setOnClickListener(v -> {
            // Kita akan buat satu lagi Activity atau tukar imej peta di sini
            Intent intent = new Intent(MapsActivity.this, FridgeResultActivity.class);
            startActivity(intent);
        });

        // Klik butang Home di Nav Bar
        binding.bottomNavBar.btnHomeNav.setOnClickListener(v -> {
            Intent intent = new Intent(MapsActivity.this, HomeActivity.class);
            startActivity(intent);
        });

        // Di dalam MapsActivity.java
        binding.btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(MapsActivity.this, FridgeResultActivity.class);
            startActivity(intent);
        });
    }
}