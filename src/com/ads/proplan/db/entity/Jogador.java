package com.ads.proplan.db.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Jogador {

	@DatabaseField(generatedId = true)
	public int id;
	
	@DatabaseField(foreign=true,foreignAutoRefresh=true)
	private Usuario usuario;
	
	@DatabaseField(useGetSet = true)
	private int vidas;
	
	@DatabaseField(useGetSet = true)
	private String nickName;
	
	@DatabaseField(useGetSet = true)
	private int pulos;
	
	@DatabaseField(useGetSet = true)
	private int pontos;
	
	
	@ForeignCollectionField
	private ForeignCollection<Trofeu> trofeus;
	
	@ForeignCollectionField
	private ForeignCollection<Sessao> sessoes;
	
	@DatabaseField(useGetSet = true)
	private Date dtInicio;
	
	@DatabaseField(useGetSet = true)
	private Date dtFim;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTrofeu(ForeignCollection<Trofeu> items) {
		this.trofeus = items;
	}

	public List<Trofeu> getTrofeu() {
		ArrayList<Trofeu> itemList = new ArrayList<Trofeu>();
		for (Trofeu m : trofeus) {
			itemList.add(m);
		}
		return itemList;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ForeignCollection<Trofeu> getTrofeus() {
		return trofeus;
	}

	public void setTrofeus(ForeignCollection<Trofeu> trofeus) {
		this.trofeus = trofeus;
	}
	
	public ForeignCollection<Sessao> getSessao() {
		return sessoes;
	}

	public void setSessao(ForeignCollection<Sessao> s) {
		this.sessoes = s;
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getPulos() {
		return pulos;
	}

	public void setPulos(int pulos) {
		this.pulos = pulos;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public ForeignCollection<Sessao> getSessoes() {
		return sessoes;
	}

	public void setSessoes(ForeignCollection<Sessao> sessoes) {
		this.sessoes = sessoes;
	}

	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Date getDtFim() {
		return dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

}
