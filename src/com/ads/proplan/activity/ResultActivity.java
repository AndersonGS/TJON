package com.ads.proplan.activity;

import java.util.Timer;
import java.util.TimerTask;

import com.ads.proplan.R;
import com.ads.proplan.control.QuestionControl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class ResultActivity extends Activity {

	public ImageView iconeImageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		iconeImageView = (ImageView) findViewById(R.id.result_image_like);
		QuestionControl control = QuestionControl.getInstance();
		if(control.isQuestionResult()){
			iconeImageView.setImageResource(R.raw.like);
		}else{
			iconeImageView.setImageResource(R.raw.dislike);
		}
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		timeSplash(2000);
	}
	
	private void timeSplash(int time) {
		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				Intent intent = new Intent();
				intent.setClass(ResultActivity.this, QuestionActivity.class);
				startActivity(intent);
				finish();
			}
		}, time);
	}
	
}
