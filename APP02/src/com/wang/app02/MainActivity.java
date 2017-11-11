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

@SuppressWarnings({ "unused", "unused" })
public class MainActivity extends Activity implements OnClickListener {
	private EditText editText1;
	private Button button1;
	private Button button2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editText1=(EditText) findViewById(R.id.editText1);
		button1=(Button)findViewById(R.id.button1);
		button2=(Button)findViewById(R.id.button2);
		
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
	}

	@SuppressLint("ShowToast")
	@Override
	public void onClick(View v) {
		if (v==button1) {
			//Toast.makeText(this, "一般性调用", 0).show();
			//创建意图对象 
			Intent intent=new Intent(this,SecondActivity.class);
			//获取文本框中的内容
			String message=editText1.getText().toString();
			//设置要带过去的值 
			intent.putExtra("message", message);
			//启动Activity
			startActivity(intent);
		}else if(v==button2){
			//Toast.makeText(this, "回调调用", 0).show();
			Intent intent=new Intent(this,SecondActivity.class);
			//获取文本框中的内容
			String message=editText1.getText().toString();
			//设置要带过去的值 
			intent.putExtra("message", message);
			int requestCode=2;
			startActivityForResult(intent, requestCode);
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode==2&&resultCode==3) {
			String result = data.getStringExtra("result");
			editText1.setText(result);
		}
	}
}
