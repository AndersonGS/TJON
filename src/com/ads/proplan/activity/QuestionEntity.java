package com.ads.proplan.activity;

import java.io.Serializable;

import android.app.Activity;

public class QuestionEntity implements Serializable {

	private static final long serialVersionUID = -8788845661812737246L;

	private int image;
	private String description;
	private String question;
	private String Alternative1;
	private String Alternative2;
	private String Alternative3;
	private String Alternative4;
	private Activity activity;
	
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

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

}
