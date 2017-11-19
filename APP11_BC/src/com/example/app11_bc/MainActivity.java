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
	 * ����һ��㲥
	 * 
	 * @param view
	 */
	public void sendNormalBC(View view) {
		// ����һ��㲥action
		String action = "com.example.app11_broadcastreceiver.MyReceiver1.action";
		Intent intent = new Intent(action);
		intent.putExtra("action", "gaogao");
		// ���з���
		sendBroadcast(intent);
		
		Toast.makeText(this, "����һ��㲥", Toast.LENGTH_SHORT).show();

	}

	/**
	 * ��������㲥
	 * 
	 * @param view
	 */
	public void sendOrderBC(View view) {

		// ����һ��㲥action
		String action = "com.example.app11_broadcastreceiver.MyReceiver1.action";
		Intent intent = new Intent(action);
		sendOrderedBroadcast(intent, null);
		Toast.makeText(this, "��������㲥", Toast.LENGTH_SHORT).show();

	}
}
