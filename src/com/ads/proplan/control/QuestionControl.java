package com.ads.proplan.control;

import java.io.Serializable;

import com.ads.proplan.activity.QuestionActivity;
import com.ads.proplan.entity.QuestionEntity;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

public class QuestionControl implements Serializable{

	private static final long serialVersionUID = -5980044146548289511L;

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
	
	private QuestionEntity questionEntity = new QuestionEntity();

	public QuestionControl(Activity c) {
		this.activityContext = c;
		provisorioEntidade();
	}
	
	public Context getActivityContext() {
		return activityContext;
	}

	public QuestionEntity getQuestionEntity() {
		return questionEntity;
	}

	public void setQuestionEntity(QuestionEntity questionEntity) {
		this.questionEntity = questionEntity;
	}
	
	private void provisorioEntidade() {
		questionEntity.setDescription("Avaliação de casos clínicos relacionados às perdas dentais em pacientes com necessidade de Prótese dentária");
		questionEntity.setQuestion("Qual a cor do dente?");
		questionEntity.setAlternative1("Branco");
		questionEntity.setAlternative2("Verde");
		questionEntity.setAlternative3("Rosa");
		questionEntity.setAlternative4("Amarelo");
		questionEntity.setAlternativeRight("Branco");
		questionEntity.setActivity(activityContext);
		Log.i(TAG_LOG, "provisorioEntidade");
	}

	
	
}
