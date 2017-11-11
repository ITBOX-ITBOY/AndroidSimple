package com.example.app07listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity_Simple_Adapter extends Activity {

	private ListView lv_main;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lv_main=(ListView)findViewById(R.id.lv_main);
		List<Map<String, Object>> data=new ArrayList<Map<String,Object>>();
		for (int i = 0; i < 10; i++) {
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("icon", R.drawable.ic_launcher);
			map.put("name", "name---"+i+1);
			map.put("content", "content---"+i+1);
			data.add(map);
		}
		
		String[] from ={"icon","name","content"};
		int[] to={R.id.iv_item_icon,R.id.tv_item_name,R.id.tv_item_content};
		SimpleAdapter simpleAdapter=new SimpleAdapter(this, data, R.layout.item_simple_apapter,from,to);	
		lv_main.setAdapter(simpleAdapter);
	}
}
