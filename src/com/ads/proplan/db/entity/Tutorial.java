package com.ads.proplan.db.entity;

import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Tutorial {

	@DatabaseField(generatedId = true)
	public int id;
	
	@DatabaseField(foreign=true,foreignAutoRefresh=true)
	private Jogo jogo;
	
	@ForeignCollectionField
	private ForeignCollection<Midia> midias;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public void setMidia(ForeignCollection<Midia> items) {
		this.midias = items;
	}

	public List<Midia> getMidia() {
		ArrayList<Midia> itemList = new ArrayList<Midia>();
		for (Midia m : midias) {
			itemList.add(m);
		}
		return itemList;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public ForeignCollection<Midia> getMidias() {
		return midias;
	}

	public void setMidias(ForeignCollection<Midia> midias) {
		this.midias = midias;
	}

}
