package br.com.saboramazonico.openhelper;

import android.R;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PratosOpenHelper extends SQLiteOpenHelper {

	public static final String NOME_DB = "pratos.db";
	public static final int VERSAO_DB = 1;

	public PratosOpenHelper(Context context) {
		super(context, NOME_DB, null, VERSAO_DB);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sqlCreate = "CREATE TABLE PRATOS ("
				+ "ID INTEGER NOT NULL,"
				+ "NOME VARCHAR(20) NOT NULL," 
				+ "INGREDIENTES TEXT NOT NULL,"
				+ "RECEITA TEXT NOT NULL,"
				+ "RENDIMENTO(20),"
				+ "DIFICULDADE VARCHAR(20),"
				+ "TMP_PREP VARCHAR(20),"
				+ "CATEGORIA VARCHAR(20),"
				+ "FOTO TEXT,"
				+ "PRIMARY KEY (ID));";

		db.execSQL(sqlCreate);
		
		String sqlInsert = "INSERT INTO PRATOS VALUES("
				//ID
				+ "1,"
				//NOME
				+ "'Receita de Moqueca de Peixe com Pirão',"
				//INGREDIENTES
				+ "'1kg de peixe (pequenos, pacu, por exemplo) inteiros \n"
				+ "2 colheres (sopa) de coentro picado \n"
				+ "1 cebola média cortada em quartos \n "
				+ "2 colheres de cebolinha verde picada \n"
				+ "2 tomates médios sem sementes, cortados \n"
				+ "Sal e pimenta do reino a gosto \n"
				+ "2 colheres (sopa) de suco de limão. \n"
				+ "Pirão: \n"
				+ "1 colher (sopa) de azeite de oliva \n"
				+ "1 cebola pequena bem picada \n"
				+ "1 colher (sopa) de coentro picado \n"
				+ "1 xícara de farinha de mandioca \n"
				+ "4 xícaras de água',"
				//RECEITA
				+ "'Limpe os peixes, lave e deixe escorrer. \n"
				+ "No copo do liquidificador, coloque coentro, cebola, cebolinha, tomates, sal, pimenta do reino e bata até triturar. \n"
				+ "Coloque os peixes em uma tigela, tempere com suco de limão, cubra com a mistura triturada envolvendo bem e deixe descansar por 1 hora. \n "
				+ "Acenda a churrasqueira ou pré aqueça o forno em temperatura alta (220º C). \n"
				+ "Coloque os peixes em uma folha nova e bem lavada de bananeira, enrole-a sobre os peixes, leve à grelha ou ao forno e asse por cerca de 30 minutos. \n"
				+ "Pirão: \n"
				+ "Coloque azeite em uma panela, aqueça em fogo alto, junte cebola, deixe dourar, acrescente coentro e misture por cerca de 2 minutos.  \n"
				+ "Dissolva farinha de mandioca na água, despeje na panela e cozinhe, mexendo sempre para não empelotar, até obter um pirão homogêneo e cremoso. \n"
				+ "Tire do fogo e sirva a moqueca acompanhada do pirão."
				//RENDIMENTO
				+ "04 porções"
				//DIFICULDADE
				+ "fácil"
				//TMP_PREP (tempo de preparo)
				+ "50 min"
				//CATEGORIA
				+ "PEIXES',"
				//FOTO
				+ "/SaborAmazonico/res/fotos/1.jpg);";
		db.execSQL(sqlInsert);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		onCreate(db);

	}

}
