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
		//��ȡ��ť����
		btn_main_download=(Button) findViewById(R.id.btn_main_download);
		//�԰�ť���м���
		btn_main_download.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast toast=Toast.makeText(MainActivity.this, "��ʼ����...", Toast.LENGTH_SHORT);
				toast.show();
				btn_main_download.setText("���������С�������");
				
			}
		});
		
		
	}
}
