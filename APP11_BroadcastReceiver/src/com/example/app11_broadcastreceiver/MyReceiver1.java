package com.example.app11_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * ¾²Ì¬×¢²á
 * @author wangjiucheng
 *
 */
public class MyReceiver1 extends BroadcastReceiver {

	public MyReceiver1() {
		Log.e("TAG","MyReceiver1 MyReceiver1()");
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		String stringExtra = intent.getStringExtra("action");
		Log.e("TAG","MyReceiver1 onReceive()"+stringExtra);

	}

}
