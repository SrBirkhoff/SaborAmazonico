package br.com.saboramazonico.activity;

import java.util.ArrayList;
import java.util.List;

import br.com.saboramazonico.adapter.CategoriaAdapter;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

public class CategoriaActivity extends ListActivity{
	protected void onCreate(Bundle savedInstanceState) {
		Log.d("ciro", "depois");
		super.onCreate(savedInstanceState);
		List<String> categoriaList = new ArrayList<String>();
		String[] categorias = new String[]{
				"categoria 1",
				"categoria 2"
		};
		for(int i=0;i<categorias.length;i++)
			categoriaList.add(categorias[i]);
		setListAdapter(new CategoriaAdapter(this, categoriaList));
	}
	
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Intent it = new Intent(getBaseContext(), ListaDePratosActivity.class);
		try{
			startActivity(it);
		}catch(Exception e){
			Log.d("ciro", "erro: " +e.getMessage());
		}
	}
}
