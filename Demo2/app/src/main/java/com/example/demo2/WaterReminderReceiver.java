package com.example.demo2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.Objects;

public class WaterReminderReceiver extends BroadcastReceiver {
    private static final String ACTION_WATER_REMINDER = "com.example.WATER_REMINDER";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Objects.equals(intent.getAction(), ACTION_WATER_REMINDER)) {
            Toast.makeText(context, "Nhớ uống nước!", Toast.LENGTH_LONG).show();
        }
    }
}
