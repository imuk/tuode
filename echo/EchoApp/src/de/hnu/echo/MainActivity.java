package de.hnu.echo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button echo = (Button) findViewById(R.id.echoButton);
		echo.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				echo();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 1, Menu.NONE, "Echoliste");
		return super.onCreateOptionsMenu(menu);
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == 1) {
			echoliste(); // Mache irgend was Sinnvolles...
		}
		return super.onOptionsItemSelected(item);
	}

	public void echo() {
		// Zugriff auf GUI COntrol

		EditText t = (EditText) findViewById(R.id.eingabeText);
		String eingabe = t.getText().toString();
		Intent i = new Intent(this, AusgabeActivity.class);
		i.putExtra("eingabeText", eingabe);
		startActivity(i);

	}

	// methode zum öffnen der neuen activity
	public void echoliste() {
		Intent i = new Intent(this, EcholisteActivity.class);
		startActivity(i);
	}
}
