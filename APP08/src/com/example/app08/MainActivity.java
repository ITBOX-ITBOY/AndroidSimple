package com.example.app08;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

		// ����sp�洢
		public void onClickSP(View v) {
			startActivity(new Intent(this, SpActivity.class));
		}

		// �����ֻ��ڲ��ļ��洢
		public void onClickIF(View v) {
			startActivity(new Intent(this, IFActivity.class));
		}

		// �����ֻ��ⲿ�ļ��洢
		public void onClickOF(View v) {
			startActivity(new Intent(this, OFActivity.class));
		}

		public void onClickDB(View v) {
				startActivity(new Intent(this,DBActivity.class));
		}

		public void onClickNW(View v) {
			startActivity(new Intent(this,NetworkActivity.class));
		}
}
