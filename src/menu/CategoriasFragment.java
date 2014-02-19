package menu;

import br.com.saboramazonico.activity.R;
import br.com.saboramazonico.activity.R.layout;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CategoriasFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_categorias, container, false);
		
		//Context context = null;
		//Intent intent = new Intent(context, CategoriaActivity.class);

		// intent.putExtra(....); // put your data

		//getActivity().startActivity(intent);
		//return container;

		
		return rootView;
	}
}
