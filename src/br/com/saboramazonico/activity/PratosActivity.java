package br.com.saboramazonico.activity;

import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;

public class PratosActivity extends Activity {

	TextView titulo;
	String idPts;
	TextView dificuldades;
	TextView tempoPreparo;
	TextView ingredientes;
	TextView desPreparo;
	CopiaHelper helper;
	Intent i;
	String IdPrato;
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pratos);
		titulo = (TextView) findViewById(R.id.nome_receita);
		tempoPreparo = (TextView) findViewById(R.id.tempo);
		dificuldades = (TextView) findViewById(R.id.Nivel_dificuldade);
		ingredientes = (TextView) findViewById(R.id.descricaoIngredientes);
		desPreparo = (TextView) findViewById(R.id.DesPreparo);
		helper = new CopiaHelper(this);

		i = getIntent();
		IdPrato = i.getStringExtra("idPrato");

		// System.out.println(i.getExtras().getString("idPrato"));

		try {
			helper.criaBaseDados();
		} catch (IOException e) {
			e.printStackTrace();
		}

		carregarTela(IdPrato);
	}

	// esse e o metodo que faz a pesquisa atraves do id vai pegar o nome
	// correspondente
	public void carregarTela(String id) {
		db = helper.getReadableDatabase();

		String args[] = { id };
		Cursor cursor = db
				.rawQuery(
						"SELECT nome,tmp_prep,dificuldade,ingredientes,receita FROM pratos where idPratos =?",
						args);

		if (cursor.moveToNext()) {

			titulo.setText(cursor.getString(0));
			tempoPreparo.setText(cursor.getString(1));
			dificuldades.setText(cursor.getString(2));
			ingredientes.setText(cursor.getString(3));
			desPreparo.setText(cursor.getString(4));

		} else {

			titulo.setText("REGISTRO NÃO ENCONTRADO");
		}

		db.close();
	}

}
