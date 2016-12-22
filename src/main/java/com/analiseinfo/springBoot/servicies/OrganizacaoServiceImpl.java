package com.analiseinfo.springBoot.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.analiseinfo.springBoot.daos.OrganizacaoRepository;
import com.analiseinfo.springBoot.models.Organizacao;

@Service
@Transactional
public class OrganizacaoServiceImpl implements OrganizacaoService {

	@Autowired
	private OrganizacaoRepository organizacaoRepository;

	@Override
	public Organizacao findById(long Id) {
		return organizacaoRepository.findOne(Id);
	}

	@Override
	public Organizacao findByName(String nome) {
		return organizacaoRepository.findByRazaoSocial(nome);
	}

	@Override
	public void salva(Organizacao organizacao) {
		organizacaoRepository.save(organizacao);
	}

	@Override
	public void update(Organizacao organizacao) {
		organizacaoRepository.save(organizacao);

	}

	@Override
	public void deletaById(Long Id) {
		organizacaoRepository.delete(Id);
	}

	@Override
	public List<Organizacao> findAllOrganizacoes() {
		return organizacaoRepository.findAll();
	}

	@Override
	public void deleteAllOrganizacoes() {
		organizacaoRepository.deleteAll();
	}

	@Override
	public boolean isOrganizacaoExist(Organizacao org) {
		if(org.getId() != null)
		return organizacaoRepository.exists(org.getId());
		else
			return false;
	}

}
