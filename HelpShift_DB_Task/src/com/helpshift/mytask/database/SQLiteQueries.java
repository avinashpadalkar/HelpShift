package com.helpshift.mytask.database;


public class SQLiteQueries 
{
//	create table query
	
	public static final String CREATE_EMP_DETAIL = "create table IF NOT EXISTS  "
			+ DataBaseConstants.TABLE_EMP + "("
			+ DataBaseConstants.EMP_ID + " INTEGER primary key AUTOINCREMENT,"
			+ DataBaseConstants.EMP_NAME + " VARCHAR,"
			+ DataBaseConstants.EMP_SSN + " INTEGER NOT NULL UNIQUE,"
			+ DataBaseConstants.EMP_DEP + " VARCHAR );";
}