package com.ads.proplan.activity;

import com.ads.proplan.R;
import com.ads.proplan.control.QuestionControl;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

@EActivity(R.layout.activity_jump)
public class JumpActivity extends Activity {

	@ViewById(R.id.jump_text_descricao)
	public TextView descricaoTextView;
	
	private QuestionControl control;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		control = QuestionControl.getInstance();
	}

	@Override
	protected void onStart() {
		super.onStart();
		descricaoTextView.setText("Você Tem "+control.getJumpNumber()+" Pulos!");
	}

	@Override
	protected void onResume() {
		super.onResume();
		timeSplash();
	}

	@UiThread(delay = 2000)
	public void timeSplash() {
		Intent intent = new Intent();
		intent.setClass(JumpActivity.this, QuestionActivity.class);
		startActivity(intent);
		finish();
	}

	@Override
	public void onBackPressed() {
	}
}
