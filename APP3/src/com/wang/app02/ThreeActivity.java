package com.wang.app02;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class ThreeActivity extends Activity {

	public ThreeActivity(){
		Log.e("TAG", "ThreeActivity()");
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_three);
	}
}
