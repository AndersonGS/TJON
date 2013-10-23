package com.ads.proplan.db.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Trofeu {

	@DatabaseField(generatedId = true)
	public int id;
	
	@DatabaseField(foreign=true,foreignAutoRefresh=true)
	private Jogador jogador;
	
	@DatabaseField(foreign=true,foreignAutoRefresh=true)
	private Fase fase;
	
	@DatabaseField(useGetSet = true)
	private String nome;

	@DatabaseField(useGetSet = true)
	private float aproveitamentoMin;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getAproveitamentoMin() {
		return aproveitamentoMin;
	}

	public void setAproveitamentoMin(float aproveitamentoMin) {
		this.aproveitamentoMin = aproveitamentoMin;
	}

}
