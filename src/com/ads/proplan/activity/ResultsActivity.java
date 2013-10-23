package com.ads.proplan.activity;

import com.ads.proplan.R;
import com.ads.proplan.control.QuestionControl;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;
import com.googlecode.androidannotations.annotations.res.DrawableRes;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

@EActivity(R.layout.activity_results)
public class ResultsActivity extends Activity {
	
	@ViewById(R.id.results_image_like)
	ImageView likeImageView;
	
	@ViewById(R.id.results_image_dislike1)
	ImageView dislikeImageView1;
	
	@ViewById(R.id.results_image_dislike2)
	ImageView dislikeImageView2;
	
	@ViewById(R.id.results_image_dislike3)
	ImageView dislikeImageView3;
	
	@ViewById(R.id.results_text_like)
	TextView likTextView;
	
	@ViewById(R.id.results_text_descricao)
	TextView descricaoTextView;

	@ViewById(R.id.results_button_cotinuar)
	Button continuiButton;
	
	private QuestionControl control; 
	
	@Override
	protected void onStart() {
		super.onStart();
		control = QuestionControl.getInstance();
		selectModelo();		
		setLife(); 
		
		checkLife();
	}

	private void checkLife() {
		if(control.getLifeNumber() == 3){
			continuiButton.setEnabled(false);
			timeNext();
		}
	}

	private void setLife() {
		if(control.getLifeNumber() > 0){
			dislikeImageView3.setImageResource(R.raw.dislike);
		}if (control.getLifeNumber() > 1) {
			dislikeImageView2.setImageResource(R.raw.dislike);
		} if (control.getLifeNumber() > 2) {
			dislikeImageView1.setImageResource(R.raw.dislike);
		}
	}

	private void selectModelo() {
		if(control.isQuestionResult()){
			likeImageView.setImageResource(R.raw.like);
			likTextView.setText("Bom Trabalho");
			descricaoTextView.setText("Você realmente sabe sobre isso. A resposta está certa: "+ control.getQuestionEntity().getAlternativeRight()+". Voce acerto "+control.getQuestionCorrectNumber()+" questões!");
		}else{
			likeImageView.setImageResource(R.raw.dislike);
			likTextView.setText("Mau Trabalho");
			descricaoTextView.setText("Você não sabe sobre isso. A resposta certa é "+ control.getQuestionEntity().getAlternativeRight()+". Voce erro "+(control.getQuestionNumber() - control.getQuestionCorrectNumber())+" questões.");
		}
	}
	
	@Click(R.id.results_button_cotinuar)
	void onclickButomContinuar(){
		Intent intent = new Intent();
		intent.setClass(ResultsActivity.this, QuestionActivity.class);
		startActivity(intent);
		finish();
	}
	
	@UiThread(delay = 3000)
	public void timeNext() {
		Intent intent = new Intent();
		intent.setClass(ResultsActivity.this, EndGameActivity_.class);
		startActivity(intent);
		finish();
	}
}
