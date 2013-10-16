package com.ads.proplan.activity;

import com.ads.proplan.R;
import com.ads.proplan.control.QuestionControl;
import com.ads.proplan.db.entity.QuestionEntity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class OptionsFragment extends Fragment {

	/**
	 * A constante ARG_OBJECT do tipo String foi declarada. O
	 * objetivo dessa variavel é determinar o nome do fragmento.
	 */
	public static final String ARG_OBJECT = "object";
	private Activity activity;
	private QuestionEntity questionEntity ;
	private View rootView;
	private QuestionControl control;

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
		((TextView) rootView.findViewById(R.id.option_text_question)).setText(questionEntity.getQuestion());
		((TextView) rootView.findViewById(R.id.option_radioButton1)).setText(questionEntity.getAlternative1());
		((TextView) rootView.findViewById(R.id.option_radioButton2)).setText(questionEntity.getAlternative2());
		((TextView) rootView.findViewById(R.id.option_radioButton3)).setText(questionEntity.getAlternative3());
		((TextView) rootView.findViewById(R.id.option_radioButton4)).setText(questionEntity.getAlternative4());
		activity = control.getActivityContext();
	}

	private void addButton( ) {
		ActionButtonSkip();	
		ActionButtonRespond();
	}

	private void ActionButtonSkip( ) {
		((Button) rootView.findViewById(R.id.option_button_skip)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(activity, QuestionActivity.class);
				startActivity(intent);
				activity.finish();
			}
		});
	}

	private void ActionButtonRespond() {
		((Button) rootView.findViewById(R.id.option_button_respond)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				verifyCorrectAlternative();
				
				new Handler().post(new Runnable() {
                    public void run() {
                    	Intent intent = new Intent();
						intent.setClass(activity, QuestionActivity.class);
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
						}
						startActivity(intent);
						activity.finish();
                    }
                });
				
			}
		});
	}

	private void 
verifyCorrectAlternative( ) {
		((RadioButton) rootView.findViewById(R.id.option_radioButton1)).setBackgroundColor(Color.GREEN);
	}
	
}
