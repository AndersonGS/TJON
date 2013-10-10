package com.ads.proplan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

public class PagesFragment extends FragmentStatePagerAdapter {

	/**
	 * A constante TAG_LOG do tipo String foi declarada. O objetivo dessa
	 * variavel abstrata � determina um titulo para o Log informativo desta
	 * classe.
	 */
	private static final String TAG_LOG = "PagesFragment";
	
	public PagesFragment(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int i) {
		Fragment fragment = null;
		Bundle args;
		switch (i) {
		case 0:
			fragment = new CaseFragment();
			args = new Bundle();
			args.putInt(CaseFragment.ARG_OBJECT, i + 1);
			fragment.setArguments(args);
			break;
		case 1:
			fragment = new OptionsFragment();
			args = new Bundle();
			args.putInt(OptionsFragment.ARG_OBJECT, i + 1);
			fragment.setArguments(args);
			break;
		default:

			break;
		}
		Log.i(TAG_LOG, "getItem:" + i);
		return fragment;
	}

	@Override
	public int getCount() {
		return 2;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		Log.i(TAG_LOG, "Position: "+position);
		return "OBJECT " + (position + 1);
	}

}