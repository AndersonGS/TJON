package com.ads.proplan;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;

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
	PagesFragment adapte;

	/**
	 * A variavel m view pager do tipo ViewPager foi declarada. O objetivo dessa
	 * variavel é gerar uma ViewPager.
	 */
	ViewPager mViewPager;

	private ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);
		imageView = (ImageView) findViewById(R.id.question_image_icone);
		adicionarAcaoBotao();
		
		buildFragmentPages();
		Log.i(TAG_LOG, "onCreate");
	}

	private void buildFragmentPages() {
		adapte = new PagesFragment(getSupportFragmentManager());
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

	/**
	 * O metodo Adicionar acao botao da classe PerguntaActivity, é uma metodo
	 * void que tem o objetivo de gerenciar os botoes.
	 */
	private void adicionarAcaoBotao() {
		// TODO Auto-generated method stub

	}

}
