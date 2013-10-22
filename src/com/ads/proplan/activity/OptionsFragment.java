package com.ads.proplan.activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import com.ads.proplan.R;
import com.ads.proplan.control.QuestionControl;
import com.ads.proplan.db.entity.QuestionEntity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class OptionsFragment extends Fragment {

	/**
	 * A constante ARG_OBJECT do tipo String foi declarada. O
	 * objetivo dessa variavel é determinar o nome do fragmento.
	 */
	public static final String ARG_OBJECT = "object";
	
	/**
	 * A constante TAG_LOG do tipo String foi declarada. O objetivo dessa
	 * variavel abstrata é determina um titulo para o Log informativo desta
	 * classe.
	 */
	private static final String TAG_LOG = "OptionsFragment";
	
	private Activity activity;
	private QuestionEntity questionEntity ;
	private View rootView;
	private QuestionControl control;

	private RadioGroup radioGroup;

	private int selectedId;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_options, container,
				false);
		Bundle args = getArguments();
		control = QuestionControl.getInstance();
		questionEntity = control.getQuestionEntity();
		setObject();
		addButton();
		return rootView;
	}

	private void setObject() {
		ArrayList<String> fileList = mixList();
		((TextView) rootView.findViewById(R.id.option_text_question)).setText(questionEntity.getQuestion());	
		((TextView) rootView.findViewById(R.id.option_radioButton1)).setText(fileList.get(0));
		((TextView) rootView.findViewById(R.id.option_radioButton2)).setText(fileList.get(1));
		((TextView) rootView.findViewById(R.id.option_radioButton3)).setText(fileList.get(2));
		((TextView) rootView.findViewById(R.id.option_radioButton4)).setText(fileList.get(3));
		activity = control.getActivityContext();
	}

	private ArrayList<String> mixList() {
		String [] list = {questionEntity.getAlternative1(),questionEntity.getAlternative2(),questionEntity.getAlternative3(),questionEntity.getAlternative4()};
		ArrayList<String> fileList = new ArrayList<String>(Arrays.asList(list));
		long seed = System.nanoTime();
		Collections.shuffle(fileList, new Random(seed));
		return fileList;
	}

	private void addButton( ) {
		ActionButtonSkip();	
		ActionButtonRespond();
	}

	private void ActionButtonSkip( ) {
		((Button) rootView.findViewById(R.id.option_button_skip)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(control.getPreferencesBar() < 59){
				Intent intent = new Intent();
				intent.setClass(activity, QuestionActivity.class);
				startActivity(intent);
				activity.finish();
				}
			}
		});
	}

	private void ActionButtonRespond() {
		((Button) rootView.findViewById(R.id.option_button_respond))
				.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						if(control.getPreferencesBar() < 59){
							radioGroup = (RadioGroup) rootView.findViewById(R.id.option_radiongroup_option);
							selectedId = radioGroup.getCheckedRadioButtonId();
							if(selectedId != -1){
								verifyCorrectAlternative();
								Intent intent = new Intent();
								intent.setClass(activity, ResultActivity.class);
								startActivity(intent);
								activity.finish();
							}
						}
					}
				});
	}

	private void verifyCorrectAlternative() {
		Log.i(TAG_LOG, "verifyCorrectAlternative");

		RadioButton radioButton = (RadioButton) rootView.findViewById(selectedId);
		if(questionEntity.getAlternativeRight().equalsIgnoreCase(""+radioButton.getText())){
			control.setQuestionResult(true);
		}else{
			control.setQuestionResult(false);
		}
	}

}
