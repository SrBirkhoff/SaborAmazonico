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
		try{
			PratosOpenHelper helperReceita = new PratosOpenHelper(context);
			this.bancoDeDados = helperReceita.getReadableDatabase();
		}catch(Exception e){
			Log.d("ciro", "erro: "+e.getMessage());
		}
		/*
		try {
			helperReceita.criaBaseDados();
		} catch (IOException e) {
			Log.e("SaborAmazonico", e.getMessage());
		}*/
	}

	public Cursor getReceitas() {
		try {
			return bancoDeDados.query("PRATOS", null, null, null, null, null, "NOME");
		} catch (SQLException e) {
			Log.e("SaborAmazonico", e.getMessage());
			return null;
		}
	}

}
