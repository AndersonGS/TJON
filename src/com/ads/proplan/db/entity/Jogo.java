package com.ads.proplan.db.entity;

import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Jogo{
	
	@DatabaseField(generatedId = true)
	public int id;
	
	@ForeignCollectionField
	private ForeignCollection<Midia> midia;
	
	@DatabaseField(useGetSet = true)
	private String descricao;
	
	@DatabaseField(useGetSet = true)
	private String titulo;
	
	@DatabaseField(useGetSet = true)
	private String sobre;
	
	@DatabaseField(useGetSet = true)
	private String versao;
	public Jogo() {
		// TODO Auto-generated constructor stub
	}

	public void setMidia(ForeignCollection<Midia> items) {
		this.midia = items;
	}

	public List<Midia> getMidia() {
		ArrayList<Midia> itemList = new ArrayList<Midia>();
		for (Midia m : midia) {
			itemList.add(m);
		}
		return itemList;
	}
	
	public String getAlternative1() {
		return sobre;
	}

	public void setAlternative1(String alternative1) {
		this.sobre = alternative1;
	}

	public String getAlternative2() {
		return versao;
	}

	public void setAlternative2(String alternative2) {
		this.versao = alternative2;
	}


	public String getDescription() {
		return descricao;
	}

	public void setDescription(String description) {
		this.descricao = description;
	}

	public String getQuestion() {
		return titulo;
	}

	public void setQuestion(String question) {
		this.titulo = question;
	}
	
}
