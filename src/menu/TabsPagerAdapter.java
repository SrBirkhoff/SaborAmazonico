package menu;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {
	
//	private AreaListFragment HomeFragment;
	//  private AreaListFragment CategoriasFragment;
	  //private AreaListFragment FavoritosFragment;

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

/*	
	@Override
	  public Fragment getItem(int position) {
	    if (position == 3) {
	      if (stateFragment == null) {
	        stateFragment = new StateListFragment();
	      }
	      return stateFragment;
	    } else if (position == 0) {
	      if (searchFragment == null) {
	        searchFragment =  new AreaListFragment();
	        searchFragment.setType(AreaListFragment.TYPE_SEARCH);
	        searchFragment.setSearch("");
	      }
	      return searchFragment;
	    } else if (position == 1) {
	      if (favoriteFragment == null) {
	        favoriteFragment =  new AreaListFragment();
	        favoriteFragment.setType(AreaListFragment.TYPE_FAVORITE);
	      }
	      return favoriteFragment;
	    } else if (position == 2) {
	      if (nearbyFragment == null) {
	        nearbyFragment =  new AreaListFragment();
	        nearbyFragment.setType(AreaListFragment.TYPE_NEARBY);
	        nearbyFragment.setLocation(latitude, longitude);
	      }
	      return nearbyFragment;
	    } else if (position == 4) {
	      if (mapFragment == null) {
	        mapFragment = new AreaMapFragment();
	      }
	      return mapFragment;
	    }
	  }
*/
	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			return new HomeFragment();
		case 1:
			return new CategoriasFragment();
		case 2:
			return new FavoritosFragment();
		}

		return null;
	}
	
	@Override
	public int getCount() {
		return 3;
	}

}
