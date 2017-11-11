package com.example.app08;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class DBActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_db);
	}

	public void testCreateDB(View view) {
		DBHepler db = new DBHepler(this, 1);

		SQLiteDatabase readableDatabase = db.getReadableDatabase();
		// ��ʾ��Ϣ
		Toast.makeText(this, "�������ݿ�ɹ�", Toast.LENGTH_SHORT).show();
	}

	public void testUpdateDB(View view) {

		DBHepler db = new DBHepler(this, 2);

		SQLiteDatabase readableDatabase = db.getReadableDatabase();

		Toast.makeText(this, "�������ݿ�ɹ�", Toast.LENGTH_SHORT).show();

	}

	public void testInsert(View view) {
		DBHepler db = new DBHepler(this, 2);
		SQLiteDatabase readableDatabase = db.getReadableDatabase();
		ContentValues values = new ContentValues();
		values.put("name", "wang");
		values.put("age", 12);
		readableDatabase.insert("person", null, values);
		readableDatabase.close();
		Toast.makeText(this, "�������ݳɹ�", Toast.LENGTH_SHORT).show();

	}

	public void testUpdate(View view) {
		DBHepler db = new DBHepler(this, 2);
		SQLiteDatabase readableDatabase = db.getReadableDatabase();
		ContentValues values = new ContentValues();
		values.put("name", "wang");
		values.put("age", 19);
		int update = readableDatabase.update("person", values, "_id=?", new String[] { "4" });
		readableDatabase.close();

		Toast.makeText(this, "�������ݳɹ�" + update, Toast.LENGTH_SHORT).show();

	}

	public void testDelete(View view) {
		DBHepler db = new DBHepler(this, 2);

		SQLiteDatabase readableDatabase = db.getReadableDatabase();

		int delete = readableDatabase.delete("person", "_id=?", new String[] { "5" });

		readableDatabase.close();
		
		Toast.makeText(this, "ɾ���ɹ�"+delete, Toast.LENGTH_SHORT).show();

	}

	public void testQuery(View view) {
		DBHepler db = new DBHepler(this, 2);
		SQLiteDatabase readableDatabase = db.getReadableDatabase();

		Cursor cursor=readableDatabase.query("person", null, null, null, null, null, null);
		while (cursor.moveToNext()) {
			
			int id = cursor.getInt(0);
			String name = cursor.getString(1);
			int age = cursor.getInt(2);
			Log.e("tag", id+"--"+name+"--"+age+"--"+cursor.getCount());
			
		}
		readableDatabase.close();
		
		Toast.makeText(this, "��ѯ�ɹ�", Toast.LENGTH_SHORT).show();
	}

	public void testTransaction(View view) {
		DBHepler db = new DBHepler(this, 2);

		SQLiteDatabase readableDatabase = db.getReadableDatabase();


		readableDatabase.close();
	}

}
