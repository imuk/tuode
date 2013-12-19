package de.hnu.echo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EchoDatenbank extends SQLiteOpenHelper {
	public EchoDatenbank(Context context) {
		super(context, "echo.db", null, 1);
	}

	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE echo ("
				+ "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "echotext TEXT NOT NULL);");
	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE echo;");
		onCreate(db);
	}
}