package com.example.appnovavolunteer;

import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import android.content.Intent;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.appnovavolunteer.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }

        // Butang pangkah (X) untuk tutup map
        binding.btnClose.setOnClickListener(v -> finish());

        // Butang Next untuk hantar data atau pergi ke page seterusnya
        binding.btnNext.setOnClickListener(v -> {
            // Logic selepas pilih lokasi
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Set koordinat (Contoh: Kuala Lumpur / Dubai)
        LatLng myLocation = new LatLng(3.1390, 101.6869);

        // Letak marker
        mMap.addMarker(new MarkerOptions().position(myLocation).title("Your Location"));

        // Gerakkan kamera dengan zoom level 15 (supaya nampak jalan)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 15.0f));
    }
}