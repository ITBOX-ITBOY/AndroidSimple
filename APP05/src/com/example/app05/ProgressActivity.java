package com.example.app05;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ProgressActivity extends Activity {

	
	private LinearLayout loading;
	private ProgressBar progressBar1;
	private SeekBar	seekBar1;
	private OnSeekBarChangeListener onSeekBarChangeListener=new OnSeekBarChangeListener() {
		
		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			Log.e("TAG", "离开");
			int progress=seekBar1.getProgress();
			progressBar1.setProgress(progress);
			if (progress==seekBar1.getMax()) {
				//loading.setVisibility(View.INVISIBLE);
				loading.setVisibility(View.GONE);
			}else{
				loading.setVisibility(View.VISIBLE);
			}
		}
		
		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			Log.e("TAG", "按下");
		}
		
		@Override
		public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
			Log.e("TAG", "移动");
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_progress);
		
		loading=(LinearLayout) findViewById(R.id.loading);
		progressBar1=(ProgressBar) findViewById(R.id.progressBar1);
		seekBar1=(SeekBar) findViewById(R.id.seekBar1);
		
		seekBar1.setOnSeekBarChangeListener(onSeekBarChangeListener);
	}
}
