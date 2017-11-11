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
	 * ��ʾһ��alertDialog
	 * @param v
	 */
	public void showAD(View v){
		new AlertDialog.Builder(this)
						.setTitle("ɾ������")
						.setMessage("��ȷ��Ҫɾ��������")
						.setPositiveButton("ɾ��", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								Toast.makeText(DialogActivity.this, "ɾ������", 0).show();
							}
						})
						.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								Toast.makeText(DialogActivity.this, "ȡ������", 0).show();
							}
						})
						.show();
	}
	/**
	 * ��ʾһ��alertDialog
	 * @param v
	 */
	public void showLD(View v){
		final String[] items={"��","��","��","��"};
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
	 * ��ʾһ��alertDialog
	 * @param v
	 */
	public void showCD(View v){
		View view=View.inflate(this, R.layout.dialog_view, null);
		final EditText userName = (EditText) view.findViewById(R.id.editText1);
		final EditText pass = (EditText)view.findViewById(R.id.editText2);
		
		new AlertDialog.Builder(this)
					.setView(view)
					.setPositiveButton("ȷ��",new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							String name=userName.getText().toString();
							String passworld=pass.getText().toString();
							Toast.makeText(DialogActivity.this, "userName:"+name+"---"+passworld, 0).show();
							
						}
					}).setNegativeButton("ȡ��", null).show();
		
	}
	/**
	 * ��ʾһ��alertDialog
	 * @param v
	 * @throws InterruptedException 
	 */
	public void showPD(View v) throws InterruptedException{
		final ProgressDialog show = ProgressDialog.show(this, "���ݼ���","���ݼ����С���������");
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
						Toast.makeText(DialogActivity.this, "�������", 0).show();
					}
				});
			}
		}.start();
	
	}
	/**
	 * ��ʾһ��alertDialog
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
	 * ��ʾһ��alertDialog
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
	 * ��ʾһ��alertDialog
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
