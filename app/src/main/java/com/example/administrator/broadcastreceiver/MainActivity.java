package com.example.administrator.broadcastreceiver;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.register).setOnClickListener(onClickListener);
        findViewById(R.id.sendMessage).setOnClickListener(onClickListener);
        findViewById(R.id.unregister).setOnClickListener(onClickListener);

        intent = new Intent("com.example.administrator.broadcastreceiver.intent.action.MyReceiver");

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.register:
                    if (myReceiver == null) {
                        myReceiver = new MyReceiver();
                        registerReceiver(myReceiver,new IntentFilter("com.example.administrator.broadcastreceiver.intent.action.MyReceiver"));
                    }
                    break;
                case R.id.unregister:
                    if (myReceiver != null) {
                        unregisterReceiver(myReceiver);
                        myReceiver = null;
                    }
                    break;
                case R.id.sendMessage:
                    sendBroadcast(intent);
                    break;
            }
        }
    };

    private MyReceiver myReceiver = null;
}
