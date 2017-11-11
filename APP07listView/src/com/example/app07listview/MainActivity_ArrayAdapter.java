package com.example.app07listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity_ArrayAdapter extends Activity {

	private ListView lv_main;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lv_main=(ListView)findViewById(R.id.lv_main);
		
		String[] data={"A","B","C","D","E","F","G","H","I","J","K","L","U","O","P","M","V","C","X","Z"};
		
		ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, R.layout.item_array, data);
		
		lv_main.setAdapter(arrayAdapter);
	}
}
