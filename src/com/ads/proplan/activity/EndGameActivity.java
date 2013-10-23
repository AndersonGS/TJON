package com.ads.proplan.activity;

import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;

import com.ads.proplan.R;
import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

@EActivity(R.layout.activity_endgame)
public class EndGameActivity extends Activity {

	@ViewById(R.id.endgame_text_descricao)
	TextView descricaoTextView;
	
	@Override
	protected void onStart() {
		super.onStart();
		descricaoTextView.setText("Você me decepcionou, eu poderia demiti-lo, mas vou dar uma chance, deseja continuar ou vai desistir?");
	}
	
	@Click(R.id.endgame_button_continuar)
	void onclickButomContinuar(){
		Intent intent = new Intent();
		intent.setClass(EndGameActivity.this, QuestionActivity.class);
		startActivity(intent);
		finish();
	}
	
}
