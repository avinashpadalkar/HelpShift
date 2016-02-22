package com.fuffataa.mytask.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper
{
	public SQLiteHelper(Context context) 
	{
//		its helps to create and managing DB
		super(context, DataBaseConstants.DATABASE_NAME, null, DataBaseConstants.DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) 
	{
//		Actualy Create DB
		db.execSQL(SQLiteQueries.CREATE_EMP_DETAIL );
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
//		Update DB
		// TODO Auto-generated method stub
		
	}


}
