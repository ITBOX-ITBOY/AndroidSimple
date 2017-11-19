package com.example.app11_bc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	/**
	 * 发送一般广播
	 * 
	 * @param view
	 */
	public void sendNormalBC(View view) {
		// 发送一般广播action
		String action = "com.example.app11_broadcastreceiver.MyReceiver1.action";
		Intent intent = new Intent(action);
		intent.putExtra("action", "gaogao");
		// 进行发送
		sendBroadcast(intent);
		
		Toast.makeText(this, "发送一般广播", Toast.LENGTH_SHORT).show();

	}

	/**
	 * 发送有序广播
	 * 
	 * @param view
	 */
	public void sendOrderBC(View view) {

		// 发送一般广播action
		String action = "com.example.app11_broadcastreceiver.MyReceiver1.action";
		Intent intent = new Intent(action);
		sendOrderedBroadcast(intent, null);
		Toast.makeText(this, "发送有序广播", Toast.LENGTH_SHORT).show();

	}
}
