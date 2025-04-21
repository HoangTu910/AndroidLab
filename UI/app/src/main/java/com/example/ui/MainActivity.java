package com.example.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton buttonLedTv = findViewById(R.id.button_led_tv);
        ImageButton buttonFurniture = findViewById(R.id.button_furniture);
        ImageButton buttonHotel = findViewById(R.id.button_hotel);
        ImageButton buttonFlights = findViewById(R.id.button_flights);
        ImageButton buttonFashion = findViewById(R.id.button_fashion);
        ImageButton buttonOffers = findViewById(R.id.button_offers);
        ImageButton buttonMobile = findViewById(R.id.button_mobile);
        ImageButton buttonBeauty = findViewById(R.id.button_beauty);

        buttonLedTv.setOnClickListener(v -> Toast.makeText(this, "LED TV clicked", Toast.LENGTH_SHORT).show());
        buttonFurniture.setOnClickListener(v -> Toast.makeText(this, "Furniture clicked", Toast.LENGTH_SHORT).show());
        buttonHotel.setOnClickListener(v -> Toast.makeText(this, "Hotel clicked", Toast.LENGTH_SHORT).show());
        buttonFlights.setOnClickListener(v -> Toast.makeText(this, "Flights clicked", Toast.LENGTH_SHORT).show());
        buttonFashion.setOnClickListener(v -> Toast.makeText(this, "Fashion clicked", Toast.LENGTH_SHORT).show());
        buttonOffers.setOnClickListener(v -> Toast.makeText(this, "Offers clicked", Toast.LENGTH_SHORT).show());
        buttonMobile.setOnClickListener(v -> Toast.makeText(this, "Mobile clicked", Toast.LENGTH_SHORT).show());
        buttonBeauty.setOnClickListener(v -> Toast.makeText(this, "Beauty clicked", Toast.LENGTH_SHORT).show());
    }
}