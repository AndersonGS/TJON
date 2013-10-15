package com.ads.proplan.entity;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable
public class Teste implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5790871350245398679L;

	@DatabaseField(id = true)
	public int id;
	
	@DatabaseField
	public String teste;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeste() {
		return teste;
	}

	public void setTeste(String teste) {
		this.teste = teste;
	}
	
	
}
