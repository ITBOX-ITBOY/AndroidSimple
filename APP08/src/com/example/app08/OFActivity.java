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
		//1. 判断sd卡状态, 如果是挂载的状态才继续, 否则提示
		if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			//2. 读取输入的文件名/内容
			String fileName = ed_key.getText().toString();
			String content = ed_value.getText().toString();
			//3. 得到指定文件的OutputStream
				//1).得到sd卡下的files路径
			String filesPath = getExternalFilesDir(null).getAbsolutePath();
				//2).组成完整路径
			String filePath = filesPath+File.separator+fileName;
				//3). 创建FileOutputStream
			Log.e("Tag", filePath);
			FileOutputStream fos = new FileOutputStream(filePath);
			//4. 写数据 
			fos.write(content.getBytes("utf-8"));
			fos.close();
			//5. 提示
			Toast.makeText(this, "保存完成", 0).show();
		} else {
			Toast.makeText(this, "sd卡没有挂载", 0).show();
		}
		
	}

	public void read(View v) throws Exception {
		
		// 1. 判断sd卡状态, 如果是挂载的状态才继续, 否则提示
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			// 2. 读取输入的文件名
			String fileName = ed_key.getText().toString();
			// 3. 得到指定文件的InputStream
				// 1).得到sd卡下的files路径
			String filesPath = getExternalFilesDir(null).getAbsolutePath();
				// 2).组成完整路径
			String filePath = filesPath + "/" + fileName;
			Log.e("tag", filePath);
				// 3). 创建FileInputStream
			FileInputStream fis = new FileInputStream(filePath);
			// 4. 读取数据, 成String
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = -1;
			while((len=fis.read(buffer))!=-1) {
				baos.write(buffer, 0, len);
			}
			String content = baos.toString();
			
			// 5. 显示
			ed_value.setText(content);
		} else {
			Toast.makeText(this, "sd卡没有挂载", 0).show();
		}
	}

	//  /storage/sdcard/atguigu/xxx.txt
	public void save2(View v) throws IOException {
		//1. 判断sd卡状态, 如果是挂载的状态才继续, 否则提示
		if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			//2. 读取输入的文件名/内容
			String fileName = ed_key.getText().toString();
			String content = ed_value.getText().toString();
			//3. 得到指定文件的OutputStream
				//1). /storage/sdcard/
			String sdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
				//2). /storage/sdcard/atguigu/(创建文件夹)
			File file = new File(sdPath+"/atguigu");
			if(!file.exists()) {
				file.mkdirs();//创建文件夹
			}
				//3). /storage/sdcard/atguigu/xxx.txt
			String filePath = sdPath+"/atguigu/"+fileName;
				//4). 创建输出流
			FileOutputStream fos = new FileOutputStream(filePath);
			//4. 写数据 
			fos.write(content.getBytes("utf-8"));
			fos.close();
			//5. 提示
			Toast.makeText(this, "保存完成", 0).show();
		} else {
			Toast.makeText(this, "sd卡没有挂载", 0).show();
		}
	}

	public void read2(View v) throws Exception {
		// 1. 判断sd卡状态, 如果是挂载的状态才继续, 否则提示
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			// 2. 读取输入的文件名
			String fileName = ed_key.getText().toString();
			// 3. 得到指定文件的InputStream
			String sdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
			String filePath = sdPath+"/atguigu/"+fileName;
			FileInputStream fis = new FileInputStream(filePath);
			// 4. 读取数据, 成String
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = -1;
			while((len=fis.read(buffer))!=-1) {
				baos.write(buffer, 0, len);
			}
			String content = baos.toString();
			fis.close();
			// 5. 显示
			ed_value.setText(content);
		} else {
			Toast.makeText(this, "sd卡没有挂载", 0).show();
		}
	}
}
