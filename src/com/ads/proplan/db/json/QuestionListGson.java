package com.ads.proplan.db.json;

import java.util.List;

import com.ads.proplan.db.entity.QuestionEntity;

public class QuestionListGson {
	private List<QuestionEntity> questionEntities;

	public List<QuestionEntity> getQuestionEntities() {
		return questionEntities;
	}

	public void setQuestionEntities(List<QuestionEntity> questionEntities) {
		this.questionEntities = questionEntities;
	}
	
}
