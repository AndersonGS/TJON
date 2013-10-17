package com.ads.proplan.db.entity;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class QuestionEntity{
	
	@DatabaseField(generatedId = true)
	public int id;
	
	@DatabaseField(useGetSet = true)
	private String image;
	
	@DatabaseField(useGetSet = true)
	private String description;
	
	@DatabaseField(useGetSet = true)
	private String question;
	
	@DatabaseField(useGetSet = true)
	private String alternative1;
	
	@DatabaseField(useGetSet = true)
	private String alternative2;
	
	@DatabaseField(useGetSet = true)
	private String alternative3;
	
	@DatabaseField(useGetSet = true)
	private String alternative4;
	
	@DatabaseField(useGetSet = true)
	private String alternativeRight;
	
	public QuestionEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public String getAlternative1() {
		return alternative1;
	}

	public void setAlternative1(String alternative1) {
		this.alternative1 = alternative1;
	}

	public String getAlternative2() {
		return alternative2;
	}

	public void setAlternative2(String alternative2) {
		this.alternative2 = alternative2;
	}

	public String getAlternative3() {
		return alternative3;
	}

	public void setAlternative3(String alternative3) {
		this.alternative3 = alternative3;
	}

	public String getAlternative4() {
		return alternative4;
	}

	public void setAlternative4(String alternative4) {
		this.alternative4 = alternative4;
	}

	public String getAlternativeRight() {
		return alternativeRight;
	}

	public void setAlternativeRight(String alternativeRight) {
		this.alternativeRight = alternativeRight;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
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
