package com.ads.proplan.activity;

import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;

import com.ads.proplan.R;
import com.ads.proplan.control.QuestionControl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

@EActivity(R.layout.activity_endgame)
public class EndGameActivity extends Activity {

	@ViewById(R.id.endgame_text_descricao)
	TextView descricaoTextView;
	private QuestionControl control;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		control = QuestionControl.getInstance();
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		descricaoTextView.setText("Você me decepcionou, eu poderia demiti-lo, mas vou dar uma chance, deseja continuar ou vai desistir?");
	}
	
	@Click(R.id.endgame_button_continuar)
	void onclickButomContinuar(){
		control.restartControl();
		Intent intent = new Intent();
		intent.setClass(EndGameActivity.this, QuestionActivity.class);
		startActivity(intent);
		finish();
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		control.closeControl();
	}

	
}
