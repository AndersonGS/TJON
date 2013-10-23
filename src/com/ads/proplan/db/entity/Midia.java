package com.ads.proplan.db.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Midia{
	
	@DatabaseField(generatedId = true)
	public int id;

	@DatabaseField(foreign=true,foreignAutoRefresh=true)
	private Jogo jogo;
	
	@DatabaseField(foreign=true,foreignAutoRefresh=true)
	private Cenario cenario;
	
	@DatabaseField(foreign=true,foreignAutoRefresh=true)
	private Fase fase;

	@DatabaseField(useGetSet = true)
	private String texto;
	
	@DatabaseField(useGetSet = true)
	private String caminho;
	public Midia() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescription() {
		return texto;
	}

	public void setDescription(String description) {
		this.texto = description;
	}

	public String getQuestion() {
		return caminho;
	}

	public void setQuestion(String question) {
		this.caminho = question;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public Cenario getCenario() {
		return cenario;
	}

	public void setCenario(Cenario cenario) {
		this.cenario = cenario;
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	
}
