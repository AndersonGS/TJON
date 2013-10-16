package com.ads.proplan.activity;

import com.ads.proplan.control.QuestionControl;
import com.ads.proplan.db.entity.QuestionEntity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

public class PagesFragment extends FragmentStatePagerAdapter {

	/**
	 * A constante TAG_LOG do tipo String foi declarada. O objetivo dessa
	 * variavel abstrata é determina um titulo para o Log informativo desta
	 * classe.
	 */
	private static final String TAG_LOG = "PagesFragment";

	QuestionControl control;
	
	QuestionEntity questionEntity;
	
	public PagesFragment(FragmentManager fm) {
		super(fm);	
		this.control = QuestionControl.getInstance();
		questionEntity = control.getQuestionEntity();
		Log.i(TAG_LOG, "PagesFragment");
	}

	@Override
	public Fragment getItem(int i) {
		Fragment fragment = null;
		Bundle args;
		switch (i) {
		case 0:
			fragment = new CaseFragment();
			args = new Bundle();
			//args.putSerializable(CaseFragment.ARG_OBJECT, questionEntity);
			fragment.setArguments(args);
			break;
		case 1:
			fragment = new OptionsFragment();
			args = new Bundle();
			//args.putSerializable(CaseFragment.ARG_OBJECT, questionEntity);
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
