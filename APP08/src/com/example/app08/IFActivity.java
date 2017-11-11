package com.example.app08;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class IFActivity extends Activity {

	private ImageView iv_if;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_if);
		
		iv_if=(ImageView)findViewById(R.id.iv_if);
	}
	
	public void save(View view) throws IOException{
		AssetManager manager=getAssets();
		InputStream io=manager.open("logo.png");
		
		FileOutputStream fs=openFileOutput("logo.png", Context.MODE_PRIVATE);
		byte[] buffer=new byte[1024];
		int len=-1;
		
		while ((len=io.read(buffer))!=-1) {
			fs.write(buffer, 0, len);
		}
		fs.close();
		io.close();
		Toast.makeText(IFActivity.this, "±£´æÍê³É", Toast.LENGTH_SHORT).show();
	}
	
	public void read(View view){
		String filePath=getFilesDir().getAbsolutePath();
		String imagePath=filePath+File.separator+"logo.png";
		Bitmap bitmap=BitmapFactory.decodeFile(imagePath);
		
		iv_if.setImageBitmap(bitmap);
		
	}
}
