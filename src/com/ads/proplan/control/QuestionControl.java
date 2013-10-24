package com.ads.proplan.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.ads.proplan.db.JogadorRepository;
import com.ads.proplan.db.QuestionRepository;
import com.ads.proplan.db.entity.Jogador;
import com.ads.proplan.db.entity.QuestionEntity;

public class QuestionControl {

	/**
	 * A variavel activity context do tipo Context foi declarada. O objetivo
	 * dessa variavel é obter o contexto da activity que controla.
	 */
	private Activity activityContext;

	/**
	 * A constante TAG_LOG do tipo String foi declarada. O objetivo dessa
	 * variavel abstrata é determina um titulo para o Log informativo desta
	 * classe.
	 */
	private static final String TAG_LOG = "QuestionControl";
	private String TAG_PREF = "QuestionControl";
	private String TAG_PREF_BAR = "BAR";

	private int [] listQuestionResolved;
	
	/**
	 * A variavel jump number do tipo Int foi declarada. O objetivo dessa
	 * variavel é para guardar o numero de pulo como variavel local.
	 */
	private int jumpNumber;

	/**
	 * A variavel question number do tipo Int foi declarada. O objetivo dessa
	 * variavel é guardar o numero de questões resolvidas como variavel local.
	 */
	private int questionNumber = 0;
	
	/**
	 * A variavel question correct number do tipo Int foi declarada. O objetivo
	 * dessa variavel é guardar o numero de questões corretas.
	 */
	private int questionCorrectNumber = 0;
	
	private int lifeNumber;
	
	private final int barMaxSize = 60;
	
	private QuestionRepository questionRepos;
	private ArrayList<QuestionEntity> arrayListQuestions;
	private QuestionEntity questionEntity;

	private JogadorRepository jogadorRepos;
	private ArrayList<Jogador> arrayListJogador;
	private Jogador jogadorEntity;
	/**
	 * A variavel question result do tipo Boolean foi declarada. O objetivo
	 * dessa variavel é determinar o fim da questão, e é usado para determinar o
	 * fim da musica e do progresso da barra.
	 */
	private boolean statusBar;
	
	private boolean questionResult;
	
	/**
	 * A variavel preferences do tipo SharedPreferences foi declarada. O
	 * objetivo dessa variavel é pegar a istancia do SharedPreferences para
	 * resgatar as preferencias salvas.
	 */
	private SharedPreferences preferences;

	private static QuestionControl uniqueInstance;
	private QuestionControl() {	}
	public static QuestionControl getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new QuestionControl();
		}
		return uniqueInstance;
	}

	public void setActivityContext(Activity activity, Context context) {
		this.activityContext = activity;
		// Sequencia...
		setStatusBar(true);
		getListQuestionDb(context);
		getPreferences(context);
		selectQuestion();
		
		if (jogadorRepos == null) {
			jogadorRepos = new JogadorRepository(context);
			arrayListJogador = (ArrayList<Jogador>) jogadorRepos.getAll();
			jogadorEntity = arrayListJogador.get(0);
			jumpNumber = jogadorEntity.getPulos();
			lifeNumber = jogadorEntity.getVidas();
		}
		
		Log.i(TAG_LOG, "setActivityContext");
	}

	private void getPreferences(Context context) {
		if(preferences == null){
		preferences = context.getSharedPreferences(TAG_PREF, 0);
		}
	}

	private void getListQuestionDb(Context context) {
		if (questionRepos == null) {
			questionRepos = new QuestionRepository(context);
			arrayListQuestions = (ArrayList<QuestionEntity>) questionRepos.getAll();
			mixList(arrayListQuestions);
		}
	}

	private void mixList(List lista) {
		long seed = System.nanoTime();
		Collections.shuffle(lista, new Random(seed));
	}

	private void selectQuestion() {
		boolean repetido = true;
		Random gerador = new Random();
		int [] lista = getPreferencesQuestion();
		
		while (repetido) {
			int cont = 0;
			for (int i : lista) {
				if(i != 0){
					cont++;
				}
			}
			if (lista.length == cont) {
				preferencesQuestionClean();
				mixList(arrayListQuestions);
			}
			cont = 0;
			int index = gerador.nextInt(arrayListQuestions.size());
			questionEntity = arrayListQuestions.get(index);
			for (int i : lista) {
				if (i == questionEntity.id) {
					cont++;
				}
			}
			if (cont == 0) {
				setPreferencesQuestion(questionEntity.id);
				repetido = false;
			}
		}
		Log.i(TAG_LOG, "provisorioEntidade");
	}
	
	public int getPreferencesBar() {
		int value = 60;
		if (preferences.contains(TAG_PREF_BAR)) {
			value = preferences.getInt(TAG_PREF_BAR, barMaxSize);
		}
		return value;
	}

	public void setPreferencesBar(int value) {
		SharedPreferences.Editor editor = preferences.edit();
		editor.putInt(TAG_PREF_BAR, value);
		editor.commit();
	}

	public int[] getPreferencesQuestion() {
		if (listQuestionResolved == null) {
			listQuestionResolved = new int[arrayListQuestions.size()];
		}
		return listQuestionResolved;
	}

	public void setPreferencesQuestion(int value) {
		if (listQuestionResolved == null) {
			listQuestionResolved = new int[arrayListQuestions.size()];
		}
		for (int j = 0; j < listQuestionResolved.length; j++) {
			if(listQuestionResolved[j] == 0){
				listQuestionResolved[j] = value;
				break;
			}
		}
	}
	
	public void preferencesQuestionClean() {
		if (listQuestionResolved == null) {
			listQuestionResolved = new int[arrayListQuestions.size()];
		}
		for (int i = 0; i < listQuestionResolved.length; i++) {
			listQuestionResolved[i] = 0;
		}
	}
	
	public void restartControl(){
		jumpNumber = 3;
		lifeNumber = 0;
		setPreferencesBar(60);
	}
	
	public void closeControl(){
		//jumpNumber = 3;
		//lifeNumber = 0;
		//setPreferencesBar(60);
		jogadorEntity.setPulos(jumpNumber);
		jogadorEntity.setVidas(lifeNumber);
		jogadorRepos.update(jogadorEntity);
		jogadorRepos = null;
		//uniqueInstance = null;
	}
	
	public Activity getActivityContext() {
		return activityContext;
	}
	public QuestionEntity getQuestionEntity() {
		return questionEntity;
	}
	public boolean isQuestionResult() {
		return questionResult;
	}
	public void setQuestionResult(boolean questionResult) {
		this.questionResult = questionResult;
	}
	public int getBarMaxSize() {
		return barMaxSize;
	}
	public boolean isStatusBar() {
		return statusBar;
	}
	public void setStatusBar(boolean statusBar) {
		this.statusBar = statusBar;
	}
	public int getQuestionNumber() {
		return questionNumber;
	}
	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}
	public int getJumpNumber() {
		return jumpNumber;
	}
	public void setJumpNumber(int jumpNumber) {
		this.jumpNumber = jumpNumber;
	}
	public int getQuestionCorrectNumber() {
		return questionCorrectNumber;
	}
	public void setQuestionCorrectNumber(int questionCorrectNumber) {
		this.questionCorrectNumber = questionCorrectNumber;
	}
	public int getLifeNumber() {
		return lifeNumber;
	}
	public void setLifeNumber(int lifeNumber) {
		this.lifeNumber = lifeNumber;
	}
	public Jogador getJogadorEntity() {
		return jogadorEntity;
	}
	public void setJogadorEntity(Jogador jogadorEntity) {
		this.jogadorEntity = jogadorEntity;
	}
	
}
