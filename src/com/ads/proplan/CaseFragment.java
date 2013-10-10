package com.ads.proplan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CaseFragment extends Fragment {
	
	/**
	 * A constante ARG_OBJECT do tipo String foi declarada. O
	 * objetivo dessa variavel é determinar o nome do fragmento.
	 */
	public static final String ARG_OBJECT = "object";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_case, container,
				false);
		Bundle args = getArguments();
		QuestionEntity questionEntity = (QuestionEntity) args.getSerializable(ARG_OBJECT);
		((TextView) rootView.findViewById(R.id.case_text_description)).setText(questionEntity.getDescription());
		 
		return rootView;
	}

}
