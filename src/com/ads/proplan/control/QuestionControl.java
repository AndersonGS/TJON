package com.ads.proplan.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import com.ads.proplan.activity.QuestionActivity;
import com.ads.proplan.db.QuestionRepository;
import com.ads.proplan.db.entity.QuestionEntity;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

public class QuestionControl{

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

	private QuestionRepository repos;
	private ArrayList<QuestionEntity> arrayListQuestions;

	private QuestionEntity questionEntity;

	private static QuestionControl uniqueInstance;

	private QuestionControl() {
	}

	public static QuestionControl getInstance() {
		if (uniqueInstance == null){
			uniqueInstance = new QuestionControl();
		}
		return uniqueInstance;
	}

	public void setActivityContext(Activity activity, Context context) {
		this.activityContext = activity;
		//Sequencia...
		Log.i(TAG_LOG, "setActivityContext"+context);
		repos = new QuestionRepository(context);
		arrayListQuestions = (ArrayList<QuestionEntity>) repos.getAll();
		Log.i(TAG_LOG, "setActivityContext");
		selectQuestion();
	}
	
	public Activity getActivityContext() {
		return activityContext;
	}

	public QuestionEntity getQuestionEntity() {
		return questionEntity;
	}

	private void selectQuestion() {
		Random gerador = new Random();
        int index = gerador.nextInt(arrayListQuestions.size());
        questionEntity = arrayListQuestions.get(index);
		
//		questionEntity.setDescription("Avaliação de casos clínicos relacionados às perdas dentais em pacientes com necessidade de Prótese dentária");
//		questionEntity.setQuestion("Qual a cor do dente?");
//		questionEntity.setAlternative1("Branco");
//		questionEntity.setAlternative2("Verde");
//		questionEntity.setAlternative3("Rosa");
//		questionEntity.setAlternative4("Amarelo");
//		questionEntity.setAlternativeRight("Branco");
		Log.i(TAG_LOG, "provisorioEntidade");
	}

}
