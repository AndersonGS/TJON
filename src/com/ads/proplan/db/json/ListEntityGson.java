package com.ads.proplan.db.json;

import java.util.List;

import com.google.gson.Gson;


public class ListEntityGson {

	private String json = "{'questionEntities':[{'description':'Avaliação de casos clínicos relacionados às perdas dentais em pacientes com necessidade de Prótese dentária','question':'Qual a cor do dente?','alternative1':'Branco','alternative2':'Verde','alternative3':'Rosa','alternative4':'Amarelo','alternativeRight':'Branco','image':'arcada'}" +
			"								,{'description':'Avaliação da quantidade de dentes na boca do paciente.','question':'Quantos dentes tem?','alternative1':'16','alternative2':'22','alternative3':'28','alternative4':'32','alternativeRight':'32','image':'arcada'}" +
			"								,{'description':'Avaliação mental.','question':'Oque é isso?','alternative1':'Torre','alternative2':'Muro','alternative3':'Elefante','alternative4':'Bola','alternativeRight':'Bola','image':'bola'}" +
			"								,{'description':'Avaliação da sua visão.','question':'Quantas cores você enxerga na imagem?','alternative1':'1','alternative2':'4','alternative3':'3','alternative4':'2','alternativeRight':'2','image':'bola'}" +
			"								,{'description':'Avaliação de um técnico em construção civil.','question':'Essa casa tem telhado?','alternative1':'Não','alternative2':'Talvez','alternative3':'Piscina?','alternative4':'Sim','alternativeRight':'Sim','image':'casa'}" +
			"								,{'description':'Avaliação mental.','question':'Determine qual objeto esta imagem representa?','alternative1':'Arvore','alternative2':'Pedra','alternative3':'Asilo','alternative4':'Casa','alternativeRight':'Casa','image':'casa'}]}";
	
	public static final String QUESTION = "Question";
	
	public void readString(String json) {
		this.json = json;
	}
	
	public List getListEntity(String tipo) {
		if(tipo.equalsIgnoreCase("Question")){
			Gson gson = new Gson();
			QuestionListGson questionList = gson.fromJson(json, QuestionListGson.class);
			return questionList.getQuestionEntities();
		}
		return null;
	}
}
