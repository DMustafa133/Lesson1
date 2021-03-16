package com.example.lesson1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String value = intent.getStringExtra(MyFragment.PARAM_VALUE);
        Intent newIntent = new Intent(MyFragment.BROADCAST_ACTION);
        newIntent.putExtra(MyFragment.PARAM_VALUE, value);
        sendBroadcast(newIntent);


        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
