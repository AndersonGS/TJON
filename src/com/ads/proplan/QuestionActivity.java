package com.ads.proplan;

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
	
	MediaPlayer playerTime;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);
		
		imageView = (ImageView) findViewById(R.id.question_image_icone);
		bar = (ProgressBar) findViewById(R.id.question_bar_time);
		
		QuestionEntity questionEntity = new QuestionEntity();
		provisorioEntidade(questionEntity);
		buildFragmentPages(questionEntity);
		
		preparingAudio();
		timeBar();
				
		Log.i(TAG_LOG, "onCreate");
	}

	@Override
	protected void onStop() {
		super.onStop();
		if (playerTime != null) {
			playerTime.stop();
		}
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
		Log.i(TAG_LOG, "provisorioEntidade");
	}

	/**
	 * O metodo Time bar da classe QuestionActivity, é uma metodo void que tem o
	 * objetivo de animar a barra do tempo.
	 */
	private void timeBar() {
		new Thread(new Runnable() {
			int mProgressStatus = 0;
			int PROGRESS = 1;			
		    Handler mHandler = new Handler();
            public void run() {
            	playerTime.start();    
            	bar.setMax(60);
                while (mProgressStatus < 60) {
                	try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
                    mProgressStatus = mProgressStatus + PROGRESS;
                    mHandler.post(new Runnable() {
                        public void run() {
                        	bar.setProgress((int) mProgressStatus);
                        }
                    });
                }
                if (playerTime != null) {
                	if(playerTime.isPlaying()){
    					playerTime.stop();
                	}
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
	 * O metodo Builds the fragment pages da classe QuestionActivity, é uma
	 * metodo void que tem o objetivo de Construir os fragmentos.
	 * 
	 * @param questionEntity
	 *            - O parametro question entity é do tipo Question entity.
	 */
	private void buildFragmentPages(QuestionEntity questionEntity) {
		adapte = new PagesFragment(getSupportFragmentManager(), questionEntity);
		mViewPager = (ViewPager) findViewById(R.id.pages);
		mViewPager.setAdapter(adapte);
		getPositionFragment();
		Log.i(TAG_LOG, "buildFragmentPages");
	}

	/**
	 * O metodo getPositionFragment da classe QuestionActivity é para esperar o
	 * usuario mudar de tela para mudar a imagem. O objetivo desse metodo é
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
