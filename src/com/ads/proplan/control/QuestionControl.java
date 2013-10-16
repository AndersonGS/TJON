package com.ads.proplan.control;

import java.io.Serializable;
import java.util.ArrayList;

import com.ads.proplan.activity.QuestionActivity;
import com.ads.proplan.db.QuestionRepository;
import com.ads.proplan.entity.QuestionEntity;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

public class QuestionControl{

	/**
	 * A variavel activity context do tipo Context foi declarada. O objetivo
	 * dessa variavel � obter o contexto da activity que controla.
	 */
	private Activity activityContext;

	/**
	 * A constante TAG_LOG do tipo String foi declarada. O objetivo dessa
	 * variavel abstrata � determina um titulo para o Log informativo desta
	 * classe.
	 */
	private static final String TAG_LOG = "QuestionControl";

	private QuestionRepository repos;
	private ArrayList comments;

	private QuestionEntity questionEntity = new QuestionEntity();

	private static QuestionControl uniqueInstance;

	private QuestionControl() {
	}

	public static QuestionControl getInstance() {
		if (uniqueInstance == null){
			uniqueInstance = new QuestionControl();
		}
		return uniqueInstance;
	}

	public void setActivityContext(Activity c) {
		this.activityContext = c;
		provisorioEntidade();
		//Sequencia...
		repos = new QuestionRepository(activityContext.getApplicationContext());
		comments = (ArrayList) repos.getAll();
	}
	
	public Activity getActivityContext() {
		return activityContext;
	}

	public QuestionEntity getQuestionEntity() {
		return questionEntity;
	}

	private void provisorioEntidade() {
		questionEntity
				.setDescription("Avalia��o de casos cl�nicos relacionados �s perdas dentais em pacientes com necessidade de Pr�tese dent�ria");
		questionEntity.setQuestion("Qual a cor do dente?");
		questionEntity.setAlternative1("Branco");
		questionEntity.setAlternative2("Verde");
		questionEntity.setAlternative3("Rosa");
		questionEntity.setAlternative4("Amarelo");
		questionEntity.setAlternativeRight("Branco");
		Log.i(TAG_LOG, "provisorioEntidade");
	}

}
