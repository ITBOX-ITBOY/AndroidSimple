package com.example.app08;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * 数据库操作的帮助类
 * @author wangjiucheng
 *
 */
public class DBHepler extends SQLiteOpenHelper {

	public DBHepler(Context context,int version) {
		super(context, "atguigu.db", null, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql="create table person(_id integer primary key autoincrement,name varchar,age int)";
		db.execSQL(sql);
		
		String sql1="insert into person(name,age) values('tt',11)";
		String sql2="insert into person(name,age) values('te',12)";
		String sql3="insert into person(name,age) values('tr',13)";
		String sql4="insert into person(name,age) values('tg',14)";
		db.execSQL(sql1);
		db.execSQL(sql2);
		db.execSQL(sql3);
		db.execSQL(sql4);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.e("TAG","DBHepler   onUpgrade");
	}

}
