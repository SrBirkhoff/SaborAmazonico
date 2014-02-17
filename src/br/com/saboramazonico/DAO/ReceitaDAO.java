package br.com.saboramazonico.DAO;

import java.io.IOException;

import br.com.saboramazonico.openhelper.PratosOpenHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ReceitaDAO {
	private SQLiteDatabase bancoDeDados;

	public ReceitaDAO(Context context) {
		PratosOpenHelper helperReceita = new PratosOpenHelper(context);
		/*
		try {
			helperReceita.criaBaseDados();
		} catch (IOException e) {
			Log.e("SaborAmazonico", e.getMessage());
		}*/
		this.bancoDeDados = helperReceita.getReadableDatabase();
	}

	public Cursor getReceitas() {
		try {
			return bancoDeDados.query("pratos", null, null, null, null, null, "nome");
		} catch (SQLException e) {
			Log.e("SaborAmazonico", e.getMessage());
			return null;
		}
	}

}
