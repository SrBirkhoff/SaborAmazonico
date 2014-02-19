package br.com.saboramazonico.activity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

public class CopiaHelper extends SQLiteOpenHelper {
	 private static String DB_PATH = Environment.getDataDirectory() + "/data/com.example.destaque/databases/";
	    private static String DB_NAME = "Sabor_Amazonico_BD.db";
	    private static int DB_VERSION = 1;
	    private Context context;

		public CopiaHelper(Context c) {
	        super(c, DB_NAME, null, DB_VERSION);
	        context = c;
	        System.out.println(DB_PATH);
	    }

	    public void criaBaseDados() throws IOException {
	        boolean dbexist = verificaBaseDados();
	        if (!dbexist) {
	        	System.out.println("Nao exite banco");
	            this.getReadableDatabase();
	            this.close();
	            try {
	            	
	            	
	                copiaBaseDados();
	                System.out.println("Copiou dados");
	            } catch(IOException e) {
	                throw new Error("Erro copiando banco de dados:" + e);
	            }
	        }
	    }

	    private void copiaBaseDados() throws IOException {
	        InputStream arqEntrada = context.getAssets().open(DB_NAME);
	        String nomeArqSaida = DB_PATH + DB_NAME;
	        OutputStream arqSaida = new FileOutputStream(nomeArqSaida);
	        byte[] buffer = new byte[1024];
	        int length;
	        while((length = arqEntrada.read(buffer)) > 0) {
	            arqSaida.write(buffer, 0, length);
	        }
	        arqSaida.flush();
	        arqSaida.close();
	        arqEntrada.close();
	    }

	    private boolean verificaBaseDados()
	    {
	        File dbFile = new File(DB_PATH + DB_NAME);
	        return dbFile.exists();
	    }

	    @Override
	    public void onCreate(SQLiteDatabase db) {

	    }

	    @Override
	    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	        onCreate(db);
	    }

	}


