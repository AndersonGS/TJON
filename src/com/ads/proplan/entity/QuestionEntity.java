package com.ads.proplan.entity;

import java.io.Serializable;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import android.app.Activity;

@DatabaseTable
public class QuestionEntity{
	
	@DatabaseField(generatedId = true)
	int id;
	
	@DatabaseField(useGetSet = true, canBeNull = false)
	private int image;
	
	@DatabaseField
	private String description;
	
	@DatabaseField
	private String question;
	
	@DatabaseField
	private String Alternative1;
	
	@DatabaseField
	private String Alternative2;
	
	@DatabaseField
	private String Alternative3;
	
	@DatabaseField
	private String Alternative4;
	
	@DatabaseField(dataType = DataType.SERIALIZABLE)
	private Teste teste;
	
	public QuestionEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public String getAlternative1() {
		return Alternative1;
	}

	public void setAlternative1(String alternative1) {
		Alternative1 = alternative1;
	}

	public String getAlternative2() {
		return Alternative2;
	}

	public void setAlternative2(String alternative2) {
		Alternative2 = alternative2;
	}

	public String getAlternative3() {
		return Alternative3;
	}

	public void setAlternative3(String alternative3) {
		Alternative3 = alternative3;
	}

	public String getAlternative4() {
		return Alternative4;
	}

	public void setAlternative4(String alternative4) {
		Alternative4 = alternative4;
	}

	public String getAlternativeRight() {
		return AlternativeRight;
	}

	public void setAlternativeRight(String alternativeRight) {
		AlternativeRight = alternativeRight;
	}

	private String AlternativeRight;

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
}
