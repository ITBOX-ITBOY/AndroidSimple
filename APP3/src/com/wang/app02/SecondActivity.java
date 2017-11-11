package com.wang.app02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends Activity {
	
	public SecondActivity(){
		Log.e("TAG", "SecondActivity()");
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
	}
	
	/**
	 * 启动第一个窗体
	 * @param v
	 */
	public void startFirst(View v){
		startActivity(new Intent(this,MainActivity.class));
	}
	/**
	 * 启动第三个窗体
	 * @param v
	 */
	public void startThree(View v){
		startActivity(new Intent(this,ThreeActivity.class));
	}
	
}
