package com.example.demo2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private WaterReminderReceiver waterReminderReceiver;

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Register broadcast receiver with explicit intent
        waterReminderReceiver = new WaterReminderReceiver();
        IntentFilter filter = new IntentFilter("com.example.WATER_REMINDER");
        registerReceiver(waterReminderReceiver, filter, Context.RECEIVER_NOT_EXPORTED);

        Button startReminderButton = findViewById(R.id.startReminderButton);
        startReminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the WaterReminderService
                Intent serviceIntent = new Intent(MainActivity.this, WaterReminderService.class);
                startService(serviceIntent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (waterReminderReceiver != null) {
            unregisterReceiver(waterReminderReceiver);
        }
    }
}
