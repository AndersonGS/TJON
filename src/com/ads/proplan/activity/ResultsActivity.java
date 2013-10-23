package com.ads.proplan.activity;

import com.ads.proplan.R;
import com.ads.proplan.control.QuestionControl;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.googlecode.androidannotations.annotations.res.DrawableRes;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

@EActivity(R.layout.activity_results)
public class ResultsActivity extends Activity {
	
	@ViewById(R.id.results_image_like)
	ImageView likeImageView;
	
	@ViewById(R.id.results_text_like)
	TextView likTextView;
	
	@ViewById(R.id.results_text_descricao)
	TextView descricaoTextView;

	private QuestionControl control; 
	
	@Override
	protected void onStart() {
		super.onStart();
		control = QuestionControl.getInstance();
		if(control.isQuestionResult()){
			likeImageView.setImageResource(R.raw.like);
			likTextView.setText("Bom Trabalho");
			descricaoTextView.setText("Você realmente sabe sobre isso. A resposta está certa: "+ control.getQuestionEntity().getAlternativeRight());
		}else{
			likeImageView.setImageResource(R.raw.dislike);
			likTextView.setText("Mau Trabalho");
			descricaoTextView.setText("Você não sabe sobre isso. A resposta certa é "+ control.getQuestionEntity().getAlternativeRight());
		}		
	}
	
	@Click(R.id.results_button_cotinuar)
	void onclickButomContinuar(){
		Intent intent = new Intent();
		intent.setClass(ResultsActivity.this, QuestionActivity.class);
		startActivity(intent);
		finish();
	}
}
