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
import android.widget.TextView;

public class CategoriaActivity extends ListActivity{
	
	String[] categorias;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		inicializaCategorias();
		List<String> categoriaList = new ArrayList<String>();
		for(int i=0;i<categorias.length;i++)
			categoriaList.add(categorias[i]);
		setListAdapter(new CategoriaAdapter(this, categoriaList));
	}
	
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Intent pratosIntent = new Intent(getBaseContext(), ListaDePratosActivity.class);
		TextView textNome = (TextView) v.findViewById(R.id.nome_categoria);
		pratosIntent.putExtra("categoria", textNome.getText().toString());
		try{
			startActivity(pratosIntent);
		}catch(Exception e){
			Log.d("ciro", "erro: " +e.getMessage());
		}
	}
	
	private void inicializaCategorias(){
		categorias = new String[]{
				"PEIXES",
				"MASSAS",
				"CARNES",
				"DOCES"
		};
	}
}
