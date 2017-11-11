package com.example.app05;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnCreateContextMenuListener;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends Activity {

	private Button contextMenu;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		contextMenu=(Button) findViewById(R.id.contextMenu);
		contextMenu.setOnCreateContextMenuListener(this);
	}

	/*
	 * @Override public boolean onCreateOptionsMenu(Menu menu) { menu.add(0, 2,
	 * Menu.NONE, "Ìí¼Ó"); menu.add(0, 3, Menu.NONE,"É¾³ý"); return
	 * super.onCreateOptionsMenu(menu); }
	 */

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.option_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.add:
			Toast.makeText(this, "Ìí¼Ó", Toast.LENGTH_SHORT).show();
			break;
		case R.id.delete:
			Toast.makeText(this, "É¾³ý", Toast.LENGTH_SHORT).show();
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.option_menu, menu);
		super.onCreateContextMenu(menu, v, menuInfo);
	}
}
