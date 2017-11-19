package com.example.app11_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * ¶¯Ì¬×¢²á
 * @author wangjiucheng
 *
 */
public class MyReceiver2 extends BroadcastReceiver {

	public MyReceiver2() {
		Log.e("TAG","MyReceiver1 MyReceiver1()");
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		String stringExtra = intent.getStringExtra("action");
		Log.e("TAG","MyReceiver2 onReceive()"+stringExtra);

	}

}
