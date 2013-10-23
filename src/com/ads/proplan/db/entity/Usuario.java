package com.ads.proplan.db.entity;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Usuario {

	@DatabaseField(generatedId = true)
	public int id;
	
	@DatabaseField(foreign=true,foreignAutoRefresh=true)
	private Jogador jogador;
	
	@DatabaseField(useGetSet = true)
	private String email;
	
	@DatabaseField(useGetSet = true)
	private String senha;
	
	@DatabaseField(useGetSet = true)
	private int cdPrivilegio;
	
	@DatabaseField(useGetSet = true)
	private Date dtCadastro;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getCdPrivilegio() {
		return cdPrivilegio;
	}

	public void setCdPrivilegio(int cdPrivilegio) {
		this.cdPrivilegio = cdPrivilegio;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
}
