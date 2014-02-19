package br.com.saboramazonico.adapter;

import java.util.List;

import categoria.Receita;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.saboramazonico.activity.R;

public class CategoriaAdapter extends BaseAdapter{
	private Context context;
	private List<String> categoriaList;

	public CategoriaAdapter(Context context, List<String> categoriaList) {
		this.context = context;
		this.categoriaList = categoriaList;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return categoriaList.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return categoriaList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		String categoria = categoriaList.get(position);

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		 View view = inflater.inflate(R.layout.categoria_linha, null);
		 
		 TextView textNomeReceita = (TextView) view.findViewById(R.id.nome_categoria);
		 textNomeReceita.setText(categoria);
		 
		 return view;
	}
}
