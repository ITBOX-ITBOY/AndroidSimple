package com.example.app05;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 简单的Component
 * 
 * @author wangjiucheng
 *
 */
public class SimpleComponentActivity extends Activity {

	private TextView tv_simple_message;
	private EditText ed_text;

	private CheckBox checkBox1;
	private CheckBox checkBox2;
	private CheckBox checkBox3;

	
	private RadioGroup radioGroup1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_component);

		tv_simple_message = (TextView) findViewById(R.id.tv_simple_message);
		tv_simple_message.setText("nb");

		ed_text = (EditText) findViewById(R.id.ed_text);

		final ImageView imageView = (ImageView) findViewById(R.id.iv_simple_play);
		imageView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				imageView.setBackgroundResource(android.R.drawable.alert_light_frame);
				imageView.setImageResource(android.R.drawable.ic_media_pause);
			}
		});

		checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
		checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
		checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					Toast.makeText(SimpleComponentActivity.this, "选中篮球", Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(SimpleComponentActivity.this, "未选中篮球", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
		checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
		
		radioGroup1=(RadioGroup) findViewById(R.id.radioGroup1);
		radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@SuppressLint("ShowToast")
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				RadioButton radioButton=(RadioButton) findViewById(checkedId);
				String sex=radioButton.getText().toString();
				Toast.makeText(SimpleComponentActivity.this, sex, Toast.LENGTH_SHORT).show();
			}
		});

	}

	public void submit(View v) {
		StringBuffer str = new StringBuffer();

		if (checkBox1.isChecked()) {
			str.append(checkBox1.getText().toString()).append("  ");
		}
		if (checkBox2.isChecked()) {
			str.append(checkBox2.getText().toString()).append("  ");
		}
		if (checkBox3.isChecked()) {
			str.append(checkBox3.getText().toString()).append("  ");
		}

		Toast.makeText(this, str.toString(), Toast.LENGTH_SHORT).show();
	}
}
