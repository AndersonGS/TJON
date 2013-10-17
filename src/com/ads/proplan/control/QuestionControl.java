package com.ads.proplan.control;

import java.io.Serializable;
import java.util.ArrayList;
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

	private QuestionRepository repos;
	private ArrayList<QuestionEntity> arrayListQuestions;

	private QuestionEntity questionEntity;

	private static QuestionControl uniqueInstance;

	private boolean questionResult;

	private SharedPreferences preferences;

	private QuestionControl() {
	}

	public static QuestionControl getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new QuestionControl();
		}
		return uniqueInstance;
	}

	public void setActivityContext(Activity activity, Context context) {
		this.activityContext = activity;
		// Sequencia...
		Log.i(TAG_LOG, "setActivityContext" + context);
		repos = new QuestionRepository(context);
		arrayListQuestions = (ArrayList<QuestionEntity>) repos.getAll();
		preferences = context.getSharedPreferences(TAG_PREF, 0);
		selectQuestion();
		Log.i(TAG_LOG, "setActivityContext");
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

		// questionEntity.setDescription("Avaliação de casos clínicos relacionados às perdas dentais em pacientes com necessidade de Prótese dentária");
		// questionEntity.setQuestion("Qual a cor do dente?");
		// questionEntity.setAlternative1("Branco");
		// questionEntity.setAlternative2("Verde");
		// questionEntity.setAlternative3("Rosa");
		// questionEntity.setAlternative4("Amarelo");
		// questionEntity.setAlternativeRight("Branco");
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
				;
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

}
