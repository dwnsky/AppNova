package com.example.appnovavolunteer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DeliveryUpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliveryupdate);

        RadioGroup rgStatus = findViewById(R.id.rgStatus);
        Button btnSubmit = findViewById(R.id.btnSubmitStatus);

        btnSubmit.setOnClickListener(v -> {
            int selectedId = rgStatus.getCheckedRadioButtonId();

            if (selectedId == R.id.rbSuccess) {
                // Aliran: Update -> Delivery Success
                Intent intent = new Intent(this, DeliverySuccessActivity.class);
                startActivity(intent);
                finish(); // Tutup skrin update
            } else if (selectedId == R.id.rbFailed) {
                Toast.makeText(this, "Report submitted for issue.", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Please select a status", Toast.LENGTH_SHORT).show();
            }
        });
    }
}