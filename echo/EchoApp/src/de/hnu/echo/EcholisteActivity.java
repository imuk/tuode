package de.hnu.echo;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class EcholisteActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_echoliste);
		loadListe();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.echoliste, menu);
		return true;
	}

	public void loadListe() {
		String echoStr = "";
		EchoDatenbank db = new EchoDatenbank(this);
		SQLiteDatabase con = db.getReadableDatabase();
		Cursor recs = con.rawQuery("SELECT _id,echotext FROM echo",
				new String[] {});
		while (recs.moveToNext()) {
			echoStr = echoStr + recs.getString(1) + "\n";
		}
		recs.close();
		con.close();
		((TextView) findViewById(R.id.echolistview)).setText(echoStr);
	}

}
