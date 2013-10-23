package com.ads.proplan.db.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Cenario {

	@DatabaseField(generatedId = true)
	public int id;
	
	@DatabaseField(foreign=true,foreignAutoRefresh=true)
	private Fase fase;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}
}
