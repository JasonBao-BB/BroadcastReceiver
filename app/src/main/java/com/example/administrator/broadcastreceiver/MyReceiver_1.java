package com.example.administrator.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver_1 extends BroadcastReceiver {
    public MyReceiver_1() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        System.out.println("Receiver1 got it");
    }
}
