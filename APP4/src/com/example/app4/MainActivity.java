package com.example.app4;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("ShowToast")
public class MainActivity extends Activity implements OnLongClickListener {
	//手机号码内容
	@SuppressWarnings("unused")
	private EditText edit_number;
	//信息内容
	@SuppressWarnings("unused")
	private EditText btn_send;
	//打电话按钮
	private Button btn_call;
	//发信息近世
	private Button btn_msg;
	private OnClickListener onClickListener=new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			if(v==btn_call){
				//Toast.makeText(MainActivity.this, "点击打电话", 0).show();
				//获取输入的电话号码
				edit_number= (EditText)findViewById(R.id.edit_number);
				String action=Intent.ACTION_DIAL;
				Intent intent=new Intent(action);
				intent.setData(Uri.parse("tel:"+edit_number.getText().toString()));
				//启动要调用的页面
				startActivity(intent);
			}else if(v==btn_msg){
				//Toast.makeText(MainActivity.this, "发信息", 0).show();
				String action=Intent.ACTION_SENDTO;
				Intent intent=new Intent(action);
				intent.setData(Uri.parse("smsto:"+edit_number.getText().toString()));
				intent.putExtra("sms_body",btn_send.getText().toString());
				startActivity(intent);
			}
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edit_number = (EditText) findViewById(R.id.edit_number);
		btn_send=(EditText) findViewById(R.id.btn_send);
		btn_call=(Button) findViewById(R.id.btn_call);
		btn_msg=(Button) findViewById(R.id.btn_msg);
		
		btn_call.setOnClickListener(onClickListener);
		btn_msg.setOnClickListener(onClickListener);
		
		btn_call.setOnLongClickListener(this);
		btn_msg.setOnLongClickListener(this);
		
	}

	@Override
	
	public boolean onLongClick(View v) {
		if(v==btn_call){
			//Toast.makeText(MainActivity.this, "长按打电话", 0).show();
			//获取输入的电话号码
			edit_number= (EditText)findViewById(R.id.edit_number);
			String action=Intent.ACTION_CALL;
			Intent intent=new Intent(action);
			intent.setData(Uri.parse("tel:"+edit_number.getText().toString()));
			//启动要调用的页面
			startActivity(intent);
		}else if(v==btn_msg){
			//Toast.makeText(MainActivity.this, "长按发信息", 0).show();
			SmsManager smsManager=SmsManager.getDefault();
			smsManager.sendTextMessage(edit_number.getText().toString(), null, btn_send.getText().toString(), null, null);
		}
		return true;
	}
}
