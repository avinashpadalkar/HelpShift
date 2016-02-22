package com.helpshift.mytask.database;

import com.helpshift.mytask.model.EmpDetails;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;
import android.widget.Toast;

public class MyDbHelper {

	private SQLiteDatabase db;
	SQLiteHelper helper;
	Context context;

	// database path

	private static String DB_PATH = "/data/data/com.fuffataa.mytask/databases/MyDatabase.db";

	public MyDbHelper(Context context) {
		this.context = context;
		// call SQliteHelper for create table
		helper = new SQLiteHelper(context);

		// get Write permission to DB
		db = helper.getWritableDatabase();
	}

	// open database and acquire Reference
	// this method is synchronized because of thread safety
	public synchronized void openDB() {
		try {
			db = SQLiteDatabase.openDatabase(DB_PATH, null,
					SQLiteDatabase.OPEN_READWRITE);
			if (db.isDbLockedByCurrentThread()) {
				Toast.makeText(context, "TRUE", Toast.LENGTH_SHORT).show();
			}

			db.acquireReference();

		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(context, "DB Couldn't Open", Toast.LENGTH_SHORT)
					.show();
		}
	}

	// close DB and releaseReference
	public synchronized void closeDB() {

		if (db != null) {
			try {

				db.close();
				db.releaseReference();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// insert data synchronizly

	public synchronized boolean insertData(EmpDetails details)

	{

		// set flag for is row iserted or NOT
		boolean isInserted = false;

		// check is DB open or not

		if (!db.isOpen()) {

			openDB();
		}

		// set a value details to local variale

		String name = details.getEmpName();
		String ssn = details.getEmpSSN();
		String dept = details.getEmpDep();

		db.beginTransactionNonExclusive();
		try {
			// begin transaction

			// Prepare statment

			String sql = "INSERT INTO " + DataBaseConstants.TABLE_EMP + "  ("
					+ DataBaseConstants.EMP_NAME + ","
					+ DataBaseConstants.EMP_SSN + " , "
					+ DataBaseConstants.EMP_DEP + ") VALUES (?,?, ?)";

			// compile prepare statment before execute

			SQLiteStatement statement = db.compileStatement(sql);

			// cleare all bindings

			statement.clearBindings();
			statement.bindString(1, name);
			statement.bindString(2, ssn);
			statement.bindString(3, dept);

			// Execute prepare stament

			statement.executeInsert();
			statement.clearBindings();

			// This commits the transaction if
			// there were no exceptions

			db.setTransactionSuccessful();

			// if transaction is successully completed then set isInserted true
			isInserted = true;

			// in SQL queries this exception occured Constraint dosent match

		} catch (SQLiteConstraintException sce) {
			Log.w("Exception:", sce);
			Toast.makeText(context, "Employee ID Should Be UNIQUE!!",
					Toast.LENGTH_SHORT).show();
			isInserted = false;
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(context, "Error occured Try Agian!!",
					Toast.LENGTH_SHORT).show();
			isInserted = false;
		}

		// important code are included in finally block
		// end transaction and close Db
		// retun the flag value

		finally {
			db.endTransaction();
			closeDB();
			return isInserted;
		}

	}

}
