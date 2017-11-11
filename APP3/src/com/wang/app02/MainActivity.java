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
	 * 启动第一个界面
	 * @param view
	 */
	public void startFirst(View view){
		//进行启动第一个界面
		startActivity(new Intent(this,MainActivity.class));
	}
	
	/**
	 * 启动第二个界面
	 * @param view
	 */
	public void startSecond(View view){
		//进行启动第二个界面
		startActivity(new Intent(this,SecondActivity.class));
	}
}
