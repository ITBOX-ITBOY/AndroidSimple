package com.example.app11_broadcastreceiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	private MyReceiver2 receiver;
	/**
	 * ע��㲥������
	 * @param view
	 */
	public void registBR(View view) {
		if (receiver==null) {
			String action = "com.example.app11_broadcastreceiver.MyReceiver1.action";
			MyReceiver2 receiver=new MyReceiver2();
			IntentFilter filter=new IntentFilter(action);
			registerReceiver(receiver, filter);
			Toast.makeText(this, "ע��㲥������", Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(this, "�Ѿ�ע��㲥������", Toast.LENGTH_SHORT).show();
		}
	}

	/**
	 * ��ע��㲥������
	 * @param view
	 */
	public void unRegistBR(View view) {
		if (receiver!=null) {
			unregisterReceiver(receiver);
			receiver=null;
			Toast.makeText(this, "��ע��㲥������", Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(this, "��û��ע��㲥������", Toast.LENGTH_SHORT).show();
		}
	}
	
	@Override
	protected void onDestroy() {
		if (receiver!=null) {
			unregisterReceiver(receiver);
			receiver=null;
		}
	}

}
