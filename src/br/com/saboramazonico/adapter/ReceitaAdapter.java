package br.com.saboramazonico.adapter;

import java.util.List;

import categoria.Receita;

import br.com.saboramazonico.activity.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ReceitaAdapter extends BaseAdapter{
	private Context context;
	private List<Receita> receitaList;

	public ReceitaAdapter(Context context, List<Receita> receitaList) {
		this.context = context;
		this.receitaList = receitaList;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return receitaList.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return receitaList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Receita receita = receitaList.get(position);

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		 View view = inflater.inflate(R.layout.receita_linha, null);
		 
		 TextView textNomeReceita = (TextView) view.findViewById(R.id.nome_receita);
		 textNomeReceita.setText(receita.getNome());
		 
		 ImageView img = (ImageView) view.findViewById(R.id.imageView1);
		 img.setImageResource(receita.getFoto());
		 
		 return view;
	}
}
