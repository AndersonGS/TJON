package com.ads.proplan.activity;

import java.sql.SQLException;

import com.ads.proplan.R;
import com.ads.proplan.control.QuestionControl;
import com.ads.proplan.db.config.DatabaseHelper;
import com.ads.proplan.db.entity.QuestionEntity;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;


public class QuestionActivity extends FragmentActivity {

	/**
	 * A constante TAG_LOG do tipo String foi declarada. O objetivo dessa
	 * variavel abstrata � determina um titulo para o Log informativo desta
	 * classe.
	 */
	private static final String TAG_LOG = "QuestionActivity";

	/**
	 * A variavel adapte do tipo MontarPerguntasPagerAdapte foi declarada. O
	 * objetivo dessa variavel � gerar uma adapte.
	 */
	private PagesFragment adapte;

	/**
	 * A variavel m view pager do tipo ViewPager foi declarada. O objetivo dessa
	 * variavel � gerar uma ViewPager.
	 */
	private ViewPager mViewPager;

	private ImageView imageView;

	private ProgressBar bar;
	
	private boolean statusBar;
	
	private MediaPlayer playerTime;

	private QuestionControl control;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);

		control = QuestionControl.getInstance();
		control.setActivityContext(QuestionActivity.this, this);
		
		imageView = (ImageView) findViewById(R.id.question_image_icone);
		bar = (ProgressBar) findViewById(R.id.question_bar_time);

		buildFragmentPages();
		
		preparingAudio();
		timeBar();
				
		Log.i(TAG_LOG, "onCreate");
	}

	@Override
	protected void onStop() {
		super.onStop();
		statusBar = false;
		if (playerTime != null) {
			playerTime.stop();
		}
	}
	
	/**
	 * O metodo Time bar da classe QuestionActivity, � uma metodo void que tem o
	 * objetivo de animar a barra do tempo.
	 */
	private void timeBar() {
		new Thread(new Runnable() {
			
			int mProgressStatus = control.getPreferencesBar();
			int PROGRESS = 1;			
		    Handler mHandler = new Handler();

			public void run() {
				statusBar = true;
				playerTime.start();
				bar.setMax(60);
				while (mProgressStatus < 60 && statusBar) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
					mProgressStatus = mProgressStatus + PROGRESS;
					mHandler.post(new Runnable() {
						public void run() {
							bar.setProgress((int) mProgressStatus);
							control.setPreferencesBar(mProgressStatus);
						}
					});
				}
				if (playerTime != null) {
					if (playerTime.isPlaying()) {
						playerTime.stop();
					}
				}
				if (mProgressStatus >= 60) {
					control.setPreferencesBar(0);
					control.setQuestionResult(false);
					Intent intent = new Intent();
					intent.setClass(QuestionActivity.this,
							ResultActivity.class);
					startActivity(intent);
					finish();
				}

			}
        }).start();
		Log.i(TAG_LOG, "timeBar");
	}

	private void preparingAudio() {
		playerTime = MediaPlayer.create(this, R.raw.time_pulse);
		playerTime.setLooping(true);
	}

	/**
	 * O metodo Builds the fragment pages da classe QuestionActivity, � uma
	 * metodo void que tem o objetivo de Construir os fragmentos.
	 * 
	 * @param questionEntity
	 *            - O parametro question entity � do tipo Question entity.
	 */
	private void buildFragmentPages() {
		adapte = new PagesFragment(getSupportFragmentManager());
		mViewPager = (ViewPager) findViewById(R.id.pages);
		mViewPager.setAdapter(adapte);
		getPositionFragment();
		Log.i(TAG_LOG, "buildFragmentPages");
	}

	/**
	 * O metodo getPositionFragment da classe QuestionActivity � para esperar o
	 * usuario mudar de tela para mudar a imagem. O objetivo desse metodo �
	 * esperar o usuario mudar de pagina e alterar a image do icone de Swipe.
	 */
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
		Log.i(TAG_LOG, "getPositionFragment");
	}

}
