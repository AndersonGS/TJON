package com.ads.proplan.db.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class SessaoPergunta {

	@DatabaseField(generatedId = true)
	public int id;
	
//	@DatabaseField(foreign=true,foreignAutoRefresh=true)
//	private Sessao sessao;

	@DatabaseField(foreign=true,foreignAutoRefresh=true)
	private Pergunta pergunta;
	
	@DatabaseField(generatedId = true)
	public int isAcerto;
	
	@DatabaseField(generatedId = true)
	public int tempoResolucao;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public Sessao getSessao() {
//		return sessao;
//	}
//
//	public void setSessao(Sessao sessao) {
//		this.sessao = sessao;
//	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public int getIsAcerto() {
		return isAcerto;
	}

	public void setIsAcerto(int isAcerto) {
		this.isAcerto = isAcerto;
	}

	public int getTempoResolucao() {
		return tempoResolucao;
	}

	public void setTempoResolucao(int tempoResolucao) {
		this.tempoResolucao = tempoResolucao;
	}
}
