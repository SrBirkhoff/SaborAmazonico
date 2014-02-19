package br.com.saboramazonico.activity;

import java.io.IOException;
import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainHome extends FragmentActivity {

	private LinearLayout layout1;
	private LinearLayout layout2;
	private LinearLayout layout3;
	private LinearLayout layout4;
	private LinearLayout layout5;
	private CopiaHelper helper;
	private ArrayList<String> listaDestaque;
	/*
	 * private LinearLayout layout6; private LinearLayout layout7; private
	 * LinearLayout layout8; private LinearLayout layout9; private LinearLayout
	 * layout10;
	 */
	private TextView nome1;
	private TextView nome2;
	private TextView nome3;
	private TextView nome4;
	private TextView nome5;
	String id = "";
	SQLiteDatabase db;

	private int vetorFotos[] = { R.drawable.pudim_tambaqui, R.drawable.moqueca,
			R.drawable.pirarucu, R.drawable.pudim_cupuacu, R.drawable.bolinho };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_main);
		helper = new CopiaHelper(this);

		nome1 = (TextView) findViewById(R.id.nome1);
		nome2 = (TextView) findViewById(R.id.nome2);
		nome3 = (TextView) findViewById(R.id.nome3);
		nome4 = (TextView) findViewById(R.id.nome4);
		nome5 = (TextView) findViewById(R.id.nome5);

		layout1 = (LinearLayout) findViewById(R.id.layout1);
		layout2 = (LinearLayout) findViewById(R.id.layout2);
		layout3 = (LinearLayout) findViewById(R.id.layout3);
		layout4 = (LinearLayout) findViewById(R.id.layout4);
		layout5 = (LinearLayout) findViewById(R.id.layout5);
		/*
		 * layout6 = (LinearLayout) findViewById(R.id.layout6); layout7 =
		 * (LinearLayout) findViewById(R.id.layout7); layout8 = (LinearLayout)
		 * findViewById(R.id.layout8); layout9 = (LinearLayout)
		 * findViewById(R.id.layout9); layout10 = (LinearLayout)
		 * findViewById(R.id.layout10);
		 */

		try {
			helper.criaBaseDados();
		} catch (IOException e) {
			e.printStackTrace();
		}

		carregarPratosDestaques();

		layout1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				id = "1";
				Intent intent = new Intent(MainHome.this, PratosActivity.class);
				intent.putExtra("idPrato", id);
				startActivity(intent);
			}
		});
		layout2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				id = "2";
				Intent intent = new Intent(MainHome.this, PratosActivity.class);
				intent.putExtra("idPrato", id);
				startActivity(intent);
			}
		});
		layout3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				id = "3";
				Intent intent = new Intent(MainHome.this, PratosActivity.class);
				intent.putExtra("idPrato", id);
				startActivity(intent);
			}
		});
		layout4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				id = "4";
				Intent intent = new Intent(MainHome.this, PratosActivity.class);
				intent.putExtra("idPrato", id);
				startActivity(intent);
			}
		});
		layout5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				id = "5";
				Intent intent = new Intent(MainHome.this, PratosActivity.class);
				intent.putExtra("idPrato", id);
				startActivity(intent);
			}
		});
	}

	public void carregarPratosDestaques() {
		db = helper.getReadableDatabase();

		
		Cursor cursor = db.rawQuery("SELECT nome FROM pratos where idPratos = 1 ", null);
		if(cursor.moveToFirst())
			nome1.setText(cursor.getString(0));
		
		db.close();
	}
}
