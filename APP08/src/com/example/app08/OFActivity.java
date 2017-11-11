package com.example.app08;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class OFActivity extends Activity {

	private EditText ed_key;
	private EditText ed_value;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_of);
		
		ed_key=(EditText) findViewById(R.id.ed_key);
		ed_value=(EditText) findViewById(R.id.ed_value);
	}
	
	public void save(View v) throws IOException {
		//1. �ж�sd��״̬, ����ǹ��ص�״̬�ż���, ������ʾ
		if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			//2. ��ȡ������ļ���/����
			String fileName = ed_key.getText().toString();
			String content = ed_value.getText().toString();
			//3. �õ�ָ���ļ���OutputStream
				//1).�õ�sd���µ�files·��
			String filesPath = getExternalFilesDir(null).getAbsolutePath();
				//2).�������·��
			String filePath = filesPath+File.separator+fileName;
				//3). ����FileOutputStream
			Log.e("Tag", filePath);
			FileOutputStream fos = new FileOutputStream(filePath);
			//4. д���� 
			fos.write(content.getBytes("utf-8"));
			fos.close();
			//5. ��ʾ
			Toast.makeText(this, "�������", 0).show();
		} else {
			Toast.makeText(this, "sd��û�й���", 0).show();
		}
		
	}

	public void read(View v) throws Exception {
		
		// 1. �ж�sd��״̬, ����ǹ��ص�״̬�ż���, ������ʾ
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			// 2. ��ȡ������ļ���
			String fileName = ed_key.getText().toString();
			// 3. �õ�ָ���ļ���InputStream
				// 1).�õ�sd���µ�files·��
			String filesPath = getExternalFilesDir(null).getAbsolutePath();
				// 2).�������·��
			String filePath = filesPath + "/" + fileName;
			Log.e("tag", filePath);
				// 3). ����FileInputStream
			FileInputStream fis = new FileInputStream(filePath);
			// 4. ��ȡ����, ��String
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = -1;
			while((len=fis.read(buffer))!=-1) {
				baos.write(buffer, 0, len);
			}
			String content = baos.toString();
			
			// 5. ��ʾ
			ed_value.setText(content);
		} else {
			Toast.makeText(this, "sd��û�й���", 0).show();
		}
	}

	//  /storage/sdcard/atguigu/xxx.txt
	public void save2(View v) throws IOException {
		//1. �ж�sd��״̬, ����ǹ��ص�״̬�ż���, ������ʾ
		if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			//2. ��ȡ������ļ���/����
			String fileName = ed_key.getText().toString();
			String content = ed_value.getText().toString();
			//3. �õ�ָ���ļ���OutputStream
				//1). /storage/sdcard/
			String sdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
				//2). /storage/sdcard/atguigu/(�����ļ���)
			File file = new File(sdPath+"/atguigu");
			if(!file.exists()) {
				file.mkdirs();//�����ļ���
			}
				//3). /storage/sdcard/atguigu/xxx.txt
			String filePath = sdPath+"/atguigu/"+fileName;
				//4). ���������
			FileOutputStream fos = new FileOutputStream(filePath);
			//4. д���� 
			fos.write(content.getBytes("utf-8"));
			fos.close();
			//5. ��ʾ
			Toast.makeText(this, "�������", 0).show();
		} else {
			Toast.makeText(this, "sd��û�й���", 0).show();
		}
	}

	public void read2(View v) throws Exception {
		// 1. �ж�sd��״̬, ����ǹ��ص�״̬�ż���, ������ʾ
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			// 2. ��ȡ������ļ���
			String fileName = ed_key.getText().toString();
			// 3. �õ�ָ���ļ���InputStream
			String sdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
			String filePath = sdPath+"/atguigu/"+fileName;
			FileInputStream fis = new FileInputStream(filePath);
			// 4. ��ȡ����, ��String
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = -1;
			while((len=fis.read(buffer))!=-1) {
				baos.write(buffer, 0, len);
			}
			String content = baos.toString();
			fis.close();
			// 5. ��ʾ
			ed_value.setText(content);
		} else {
			Toast.makeText(this, "sd��û�й���", 0).show();
		}
	}
}
