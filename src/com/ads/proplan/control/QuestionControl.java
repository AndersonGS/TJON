package com.ads.proplan.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.ads.proplan.activity.QuestionActivity;
import com.ads.proplan.db.QuestionRepository;
import com.ads.proplan.db.entity.QuestionEntity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

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
	private String TAG_PREF_QUESTION = "QUESTION";
	
	private final int barMaxSize = 60;
	
	private QuestionRepository repos;
	private ArrayList<QuestionEntity> arrayListQuestions;
	private QuestionEntity questionEntity;

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
		
		Log.i(TAG_LOG, "setActivityContext");
	}

	private void getPreferences(Context context) {
		if(preferences == null){
		preferences = context.getSharedPreferences(TAG_PREF, 0);
		}
	}

	private void getListQuestionDb(Context context) {
		if (repos == null) {
			repos = new QuestionRepository(context);
			arrayListQuestions = (ArrayList<QuestionEntity>) repos.getAll();
			mixList(arrayListQuestions);
		}
	}

	private void mixList(List lista) {
		long seed = System.nanoTime();
		Collections.shuffle(lista, new Random(seed));
	}

	public Activity getActivityContext() {
		return activityContext;
	}

	public QuestionEntity getQuestionEntity() {
		return questionEntity;
	}

	private void selectQuestion() {
		boolean repetido = true;
		Random gerador = new Random();
		int [] lista = getPreferencesQuestion();
		
		while (repetido) {
			int cont = 0;
			if (lista.length >= arrayListQuestions.size()) {
				repetido = false;
				preferencesQuestionClean();
				mixList(arrayListQuestions);
			}
			int index = gerador.nextInt(arrayListQuestions.size());
			questionEntity = arrayListQuestions.get(index);
			for (int i : lista) {
				if (i == questionEntity.id) {
					cont++;
				}
			}
			if (cont == 0) {
				setPreferencesQuestion(questionEntity.id);
				Log.i(TAG_LOG, "provisorioEntidade" + questionEntity.id);
				repetido = false;
			}
		}
		Log.i(TAG_LOG, "provisorioEntidade");
	}

	public boolean isQuestionResult() {
		return questionResult;
	}

	public void setQuestionResult(boolean questionResult) {
		this.questionResult = questionResult;
	}

	public int getPreferencesBar() {
		int value = 0;
		if (preferences.contains(TAG_PREF_BAR)) {
			value = preferences.getInt(TAG_PREF_BAR, 0);
		}
		return value;
	}

	public void setPreferencesBar(int value) {
		SharedPreferences.Editor editor = preferences.edit();
		editor.putInt(TAG_PREF_BAR, value);
		editor.commit();
	}

	public int[] getPreferencesQuestion() {
		String value = "";
		int[] results = new int[1];
		if (preferences.contains(TAG_PREF_QUESTION)) {
			value = preferences.getString(TAG_PREF_QUESTION, "");
			String[] items = value.split(",");
			results = new int[items.length];
			for (int i = 0; i < items.length; i++) {
				try {
					results[i] = Integer.parseInt(items[i]);
				} catch (NumberFormatException nfe) {
				}
			}
		}
		return results;
	}

	public void setPreferencesQuestion(int value) {
		String text = preferences.getString(TAG_PREF_QUESTION, "");
		text = (text + "," + value);
		SharedPreferences.Editor editor = preferences.edit();
		editor.putString(TAG_PREF_QUESTION, text);
		editor.commit();
	}
	
	public void preferencesQuestionClean() {
		SharedPreferences.Editor editor = preferences.edit();
		editor.putString(TAG_PREF_QUESTION, "");
		editor.commit();
	}

	public void runOnStop() {
		//TODO
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
}
