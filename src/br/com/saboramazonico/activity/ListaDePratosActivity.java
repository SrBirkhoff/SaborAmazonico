package br.com.saboramazonico.activity;

import java.util.ArrayList;
import java.util.List;

import br.com.saboramazonico.DAO.ReceitaDAO;
import br.com.saboramazonico.adapter.ReceitaAdapter;


import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.util.Log;

public class ListaDePratosActivity extends ListActivity{


	private CursorAdapter dados;
	private ReceitaDAO receitaDAO;
	private int[] images;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("ciro", "lista de pratos 1");
		this.receitaDAO = new ReceitaDAO(this);
		Log.d("ciro", "lista de pratos 2");
		inicializaImagens();
		List<Receita> receitaList = new ArrayList<Receita>();
		Log.d("ciro", "lista de pratos 3");
        Cursor cursor = receitaDAO.getReceitas();
		Log.d("ciro", "lista de pratos 4");
        for (int i = 0; i < cursor.getCount(); i++) {
        	cursor.moveToNext();
            Receita receita = new Receita();
            receita.setNome(cursor.getString(1));
            
            receita.setFoto(images[Integer.parseInt(cursor.getString(8))]);
            
            receitaList.add(receita);
        }  
		Log.d("ciro", "lista de pratos 5");
        setListAdapter(new ReceitaAdapter(this, receitaList));
		
			
	}

	void inicializaImagens(){
		images = new int[]{
				R.drawable.bolinho,
				R.drawable.moqueca,
				R.drawable.pirarucu,
				R.drawable.pudim_cupuacu,
				R.drawable.pudim_tambaqui
				};
	}
}
