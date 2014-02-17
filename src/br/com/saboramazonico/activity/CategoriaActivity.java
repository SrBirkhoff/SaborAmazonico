package br.com.saboramazonico.activity;

import java.util.ArrayList;
import java.util.List;

import br.com.saboramazonico.adapter.CategoriaAdapter;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;

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
}
