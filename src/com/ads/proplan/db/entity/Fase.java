package com.ads.proplan.db.entity;

import java.util.ArrayList;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Fase {

	@DatabaseField(generatedId = true)
	public int id;
	
	@DatabaseField(useGetSet = true)
	private String description;
	
	@DatabaseField(foreign=true,foreignAutoRefresh=true)
	private Trofeu trofeu;
	
	@ForeignCollectionField
	private ForeignCollection<Cenario> cenarios;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ForeignCollection<Cenario> getCenarios() {
		
		ArrayList<Cenario> itemList = new ArrayList<Cenario>();
		for (Cenario f : cenarios) {
			itemList.add(f);
		}
		return cenarios;
	}

	public void setCenarios(ForeignCollection<Cenario> cenarios) {
		this.cenarios = cenarios;
	}

	public Trofeu getTrofeu() {
		return trofeu;
	}

	public void setTrofeu(Trofeu trofeu) {
		this.trofeu = trofeu;
	}

}
