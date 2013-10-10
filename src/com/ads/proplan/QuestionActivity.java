package com.ads.proplan;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class QuestionActivity extends FragmentActivity {

	/**
	 * A constante TAG_LOG do tipo String foi declarada. O objetivo dessa
	 * variavel abstrata é determina um titulo para o Log informativo desta
	 * classe.
	 */
	private static final String TAG_LOG = "QuestionActivity";

	/**
	 * A variavel adapte do tipo MontarPerguntasPagerAdapte foi declarada. O
	 * objetivo dessa variavel é gerar uma adapte.
	 */
	private PagesFragment adapte;

	/**
	 * A variavel m view pager do tipo ViewPager foi declarada. O objetivo dessa
	 * variavel é gerar uma ViewPager.
	 */
	private ViewPager mViewPager;

	private ImageView imageView;

	private ProgressBar bar;

	ImageView caseImage;

	TextView caseText;

	private Button buttonRespond;
	private Button buttonSkip;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);
		
		imageView = (ImageView) findViewById(R.id.question_image_icone);
		bar = (ProgressBar) findViewById(R.id.question_bar_time);

		caseImage = (ImageView) findViewById(R.id.case_image_arcada);
		caseText = (TextView) findViewById(R.id.case_text_description);
		
		
		
		QuestionEntity questionEntity = new QuestionEntity();
		provisorioEntidade(questionEntity);
		
		timeBar();
		buildFragmentPages(questionEntity);
		
		Log.i(TAG_LOG, "onCreate");
	}

	private void provisorioEntidade(QuestionEntity questionEntity) {
		questionEntity.setDescription("Avaliação de casos clínicos relacionados às perdas dentais em pacientes com necessidade de Prótese dentária");
		questionEntity.setQuestion("Qual a cor do dente?");
		questionEntity.setAlternative1("Branco");
		questionEntity.setAlternative2("Verde");
		questionEntity.setAlternative3("Rosa");
		questionEntity.setAlternative4("Amarelo");
		questionEntity.setAlternativeRight("Branco");
		questionEntity.setActivity(QuestionActivity.this);
	}

	private void timeBar() {
		new Thread(new Runnable() {
			int mProgressStatus = 0;
			int PROGRESS = 1;
		    Handler mHandler = new Handler();
            public void run() {
                while (mProgressStatus < 100) {
                	try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
                    mProgressStatus = mProgressStatus + PROGRESS;
                    mHandler.post(new Runnable() {
                        public void run() {
                        	bar.setProgress(mProgressStatus);
                        }
                    });
                }
            }
        }).start();
	}

	private void buildFragmentPages(QuestionEntity questionEntity) {
		adapte = new PagesFragment(getSupportFragmentManager(), questionEntity);
		mViewPager = (ViewPager) findViewById(R.id.pages);
		mViewPager.setAdapter(adapte);
		getPositionFragment();

	}

	private void getPositionFragment() {
		mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						Log.i(TAG_LOG, "Position: "+position);
						if(position == 1){
							imageView.setImageResource(R.raw.bolad);
						}else{
							imageView.setImageResource(R.raw.bolae);
						}
					}		
				});
	}

}
