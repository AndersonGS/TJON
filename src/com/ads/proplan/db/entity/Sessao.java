package com.ads.proplan.db.entity;

import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Sessao {

	@DatabaseField(generatedId = true)
	public int id;
	
	@DatabaseField(foreign=true,foreignAutoRefresh=true)
	private Jogador jogador;

	@ForeignCollectionField
	private ForeignCollection<Pergunta> perguntas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPerguntas(ForeignCollection<Pergunta> items) {
		this.perguntas = items;
	}

	public List<Pergunta> getPerguntas() {
		ArrayList<Pergunta> itemList = new ArrayList<Pergunta>();
		for (Pergunta m : perguntas) {
			itemList.add(m);
		}
		return itemList;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	
}
