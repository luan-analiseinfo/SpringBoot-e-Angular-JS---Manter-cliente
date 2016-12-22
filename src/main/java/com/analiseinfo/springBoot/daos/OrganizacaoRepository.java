package com.analiseinfo.springBoot.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.analiseinfo.springBoot.models.Organizacao;

@Repository
public interface OrganizacaoRepository extends JpaRepository<Organizacao, Long>,OrganizacaoRepositoryCustom {

	Organizacao findByRazaoSocial(String nome);

}
