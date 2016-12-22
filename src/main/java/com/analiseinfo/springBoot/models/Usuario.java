package com.analiseinfo.springBoot.models;

import javax.persistence.Entity;

import com.analiseinfo.springBoot.utils.BaseEntity;

@Entity
public class Usuario extends BaseEntity<Long>{

	
	private static final long serialVersionUID = -7581610292496422698L;
	
	private String nome;
	private String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
