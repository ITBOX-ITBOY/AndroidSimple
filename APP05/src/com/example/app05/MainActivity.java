package com.example.app05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends Activity implements OnClickListener {

	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/**
		 * Ìí¼Ó¼àÌý
		 */
		findViewById(R.id.btn1).setOnClickListener(this);
		findViewById(R.id.btn2).setOnClickListener(this);
		findViewById(R.id.btn3).setOnClickListener(this);
		findViewById(R.id.btn4).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.btn1:
			startActivity(new Intent(this,SimpleComponentActivity.class));
			break;
		case R.id.btn2:
			startActivity(new Intent(this,MenuActivity.class));
			break;
		case R.id.btn3:
			startActivity(new Intent(this,ProgressActivity.class));
			break;
		case R.id.btn4:
			startActivity(new Intent(this,DialogActivity.class));
			break;
		}

	}
}
