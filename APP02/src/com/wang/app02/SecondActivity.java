package com.wang.app02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends Activity {

	private EditText edit_text;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		//��ȡ��ͼ����
		Intent intent = getIntent();
		//��ȡ���ݹ�����ֵ
		String message = intent.getStringExtra("message");
		//���õ�ʱ��ǰҳ����ȥ
		edit_text=(EditText) findViewById(R.id.edit_text);
		edit_text.setText(message);
		
	}
	
	public void back1(View v){
		finish();
	}
	
	public void back2(View v){
		int resultCode=3;
		Intent intent=new Intent();
		String result = edit_text.getText().toString();
		intent.putExtra("result", result);
		setResult(resultCode, intent);
		
		finish();
	}
}
