package com.analiseinfo.springBoot.servicies;

import java.util.List;

import org.springframework.stereotype.Service;

import com.analiseinfo.springBoot.models.Organizacao;

@Service
public interface OrganizacaoService {
	
	Organizacao findById(long Id);
	Organizacao findByName(String nome);
	void salva(Organizacao organizacao);
	void update(Organizacao organizacao);
	void deletaById(Long Id);
	List<Organizacao> findAllOrganizacoes();
	void deleteAllOrganizacoes();
	boolean isOrganizacaoExist(Organizacao org);
	
	

}
