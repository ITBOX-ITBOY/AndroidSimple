package com.wang.app02;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressWarnings({ "unused" })
public class MainActivity extends Activity{
	
	public MainActivity(){
		Log.e("TAG", "MainActivity()");
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.e("TAG", "onCreate()");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	/**
	 * ������һ������
	 * @param view
	 */
	public void startFirst(View view){
		//����������һ������
		startActivity(new Intent(this,MainActivity.class));
	}
	
	/**
	 * �����ڶ�������
	 * @param view
	 */
	public void startSecond(View view){
		//���������ڶ�������
		startActivity(new Intent(this,SecondActivity.class));
	}
}
