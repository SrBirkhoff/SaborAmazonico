package br.com.saboramazonico.activity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void vai(View view){
		Intent it = new Intent(getBaseContext(), CategoriaActivity.class);
		try{
			startActivity(it);
		}catch(Exception e){
			Log.d("ciro", "erro: " +e.getMessage());
		}
	}
}
