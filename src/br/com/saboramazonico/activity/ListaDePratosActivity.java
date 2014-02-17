package br.com.saboramazonico.activity;

import java.util.ArrayList;
import java.util.List;

import br.com.saboramazonico.DAO.ReceitaDAO;
import br.com.saboramazonico.adapter.ReceitaAdapter;


import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;

public class ListaDePratosActivity extends ListActivity{


	private CursorAdapter dados;
	private ReceitaDAO receitaDAO;
	private int[] images;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.receitaDAO = new ReceitaDAO(this);
		
		inicializaImagens();
		List<Receita> receitaList = new ArrayList<Receita>();
        Cursor cursor = receitaDAO.getReceitas();
        for (int i = 0; i < cursor.getCount(); i++) {
        	cursor.moveToNext();
            Receita receita = new Receita();
            receita.setNome(cursor.getString(1));
            
            receita.setFoto(images[Integer.parseInt(cursor.getString(4))]);
            
            receitaList.add(receita);
        }  
        
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
