package com.example.app05;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class DialogActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialog);
	}
	
	/**
	 * 显示一般alertDialog
	 * @param v
	 */
	public void showAD(View v){
		new AlertDialog.Builder(this)
						.setTitle("删除数据")
						.setMessage("你确定要删除数据吗？")
						.setPositiveButton("删除", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								Toast.makeText(DialogActivity.this, "删除数据", 0).show();
							}
						})
						.setNegativeButton("取消", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								Toast.makeText(DialogActivity.this, "取消数据", 0).show();
							}
						})
						.show();
	}
	/**
	 * 显示一般alertDialog
	 * @param v
	 */
	public void showLD(View v){
		final String[] items={"红","蓝","绿","青"};
		new AlertDialog.Builder(this)
		.setSingleChoiceItems(items, 2, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(DialogActivity.this,items[which], 0).show();
				dialog.dismiss();
			}
		})				
		.show();
		
	}
	/**
	 * 显示一般alertDialog
	 * @param v
	 */
	public void showCD(View v){
		View view=View.inflate(this, R.layout.dialog_view, null);
		final EditText userName = (EditText) view.findViewById(R.id.editText1);
		final EditText pass = (EditText)view.findViewById(R.id.editText2);
		
		new AlertDialog.Builder(this)
					.setView(view)
					.setPositiveButton("确定",new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							String name=userName.getText().toString();
							String passworld=pass.getText().toString();
							Toast.makeText(DialogActivity.this, "userName:"+name+"---"+passworld, 0).show();
							
						}
					}).setNegativeButton("取消", null).show();
		
	}
	/**
	 * 显示一般alertDialog
	 * @param v
	 * @throws InterruptedException 
	 */
	public void showPD(View v) throws InterruptedException{
		final ProgressDialog show = ProgressDialog.show(this, "数据加载","数据加载中。。。。。");
		new Thread(){
			public void run() {
				for (int i = 0; i <20; i++) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				show.dismiss();
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						Toast.makeText(DialogActivity.this, "运行完成", 0).show();
					}
				});
			}
		}.start();
	
	}
	/**
	 * 显示一般alertDialog
	 * @param v
	 */
	public void showPD2(View v){
		final ProgressDialog ps=new ProgressDialog(this);
		ps.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		ps.show();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				int count=20;
				for (int i = 0; i < count; i++) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ps.setProgress(ps.getProgress()+1);
				}
				ps.dismiss();
			}
		}).start();
		
	}
	/**
	 * 显示一般alertDialog
	 * @param v
	 */
	public void showDateAD(View v){
		Calendar cs=Calendar.getInstance();
		int year=cs.get(Calendar.YEAR);
		int monthOfYear=cs.get(Calendar.MONTH);
		int dayOfMonth=cs.get(Calendar.DAY_OF_MONTH);
		
		new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
			
			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
					
				Log.e("TAG",year+":"+monthOfYear+":"+dayOfMonth);
			}
		}, year, monthOfYear, dayOfMonth).show();
		
	}
	/**
	 * 显示一般alertDialog
	 * @param v
	 */
	public void showTimeAD(View v){
		Calendar cs=Calendar.getInstance();
		int hourOfDay=cs.get(Calendar.HOUR_OF_DAY);
		int minute=cs.get(Calendar.MINUTE);
		boolean is24HourView=false;
		new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
			
			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				// TODO Auto-generated method stub
				
			}
		}, hourOfDay, minute, is24HourView).show();
	}
}
