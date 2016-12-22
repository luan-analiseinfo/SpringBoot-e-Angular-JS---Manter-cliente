package com.analiseinfo.springBoot.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.analiseinfo.springBoot.utils.BaseEntity;


@Entity
@Table(name="CLIENTE")
@Component
public class Cliente extends BaseEntity<Long> {
	

	private static final long serialVersionUID = 1L;

	@NotNull
	private String nome;
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}