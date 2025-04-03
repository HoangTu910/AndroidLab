package com.example.demo2;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;

public class WaterReminderService extends Service {
    private static final String ACTION_WATER_REMINDER = "com.example.WATER_REMINDER";
    // private static final int INTERVAL = 60 * 60 * 1000; // 1 hour
    private static final int INTERVAL = 5 * 1000; // 2

    private Handler handler;
    private Runnable reminderRunnable;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        handler = new Handler();
        reminderRunnable = new Runnable() {
            @Override
            public void run() {
                sendReminderBroadcast();
                handler.postDelayed(this, INTERVAL);
            }
        };
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        handler.postDelayed(reminderRunnable, INTERVAL);
        return START_STICKY;
    }

    private void sendReminderBroadcast() {
        Intent intent = new Intent(ACTION_WATER_REMINDER);
        intent.setClass(this, WaterReminderReceiver.class);
        sendBroadcast(intent);
    }

    @Override
    public void onDestroy() {
        handler.removeCallbacks(reminderRunnable);
        super.onDestroy();
    }
}
