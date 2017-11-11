package com.example.app08;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SpActivity extends Activity {

	
	private EditText editText1;
	private EditText editText2;
	
	private SharedPreferences sharedPreferences;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sp);
		
		editText1=(EditText)findViewById(R.id.editText1);
		editText2=(EditText)findViewById(R.id.editText2);
		
		sharedPreferences=getSharedPreferences("test123456", MODE_PRIVATE);
	}

	/**
	 * ���б���
	 * @param view
	 */
	@SuppressLint("ShowToast")
	public void save(View view) {
			Editor edit = sharedPreferences.edit();
			String key=editText1.getText().toString();
			String value=editText2.getText().toString();
			edit.putString(key, value);
			edit.commit();
			Toast.makeText(SpActivity.this, "�������", Toast.LENGTH_SHORT).show();
	}
	
	/**
	 * ���ж�ȡ
	 * @param view
	 */
	public void read(View view) {
		String key=editText1.getText().toString();
		
		String value=sharedPreferences.getString(key, null);
		if (value==null) {
			Toast.makeText(SpActivity.this, "û����key��ֵ", Toast.LENGTH_SHORT).show();
		}else{
			editText2.setText(value);
		}
		

	}
}
