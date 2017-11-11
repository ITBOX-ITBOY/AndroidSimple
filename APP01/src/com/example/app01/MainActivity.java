package com.example.app01;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btn_main_download;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//获取按钮对象
		btn_main_download=(Button) findViewById(R.id.btn_main_download);
		//对按钮进行监听
		btn_main_download.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast toast=Toast.makeText(MainActivity.this, "开始下载...", Toast.LENGTH_SHORT);
				toast.show();
				btn_main_download.setText("正在下载中。。。。");
				
			}
		});
		
		
	}
}
