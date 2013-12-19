package de.hnu.echo;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class AusgabeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ausgabe);
		Intent i = getIntent();
		String eingabe = i.getExtras().getString("eingabeText");
		((TextView) findViewById(R.id.ausgabeText)).setText(eingabe);
		saveInListe(eingabe);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ausgabe, menu);
		return true;
	}

	public void saveInListe(String echotext) {
		EchoDatenbank db = new EchoDatenbank(this);
		SQLiteDatabase con = db.getWritableDatabase();
		SQLiteStatement stmt = con
				.compileStatement("INSERT INTO echo(echotext) VALUES(?)");
		stmt.bindString(1, echotext);
		stmt.executeInsert();
		stmt.close();
		con.close();
	}

}
