package com.analiseinfo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.analiseinfo.springBoot.Boot;
import com.analiseinfo.springBoot.daos.ClienteRepository;
import com.analiseinfo.springBoot.daos.OrganizacaoRepository;
import com.analiseinfo.springBoot.models.Organizacao;
import com.analiseinfo.springBoot.servicies.OrganizacaoService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Boot.class)
@WebAppConfiguration
public class OrganizacaoTest {

	@Autowired
	OrganizacaoRepository organizacaoRepository;
	
	@Autowired
	OrganizacaoService organizacaoService;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Test
	public void teste(){
		Organizacao organizacao = new Organizacao();
		organizacaoRepository.someCustomMethod();
		organizacaoService.findById(1L);
		System.out.println("Funcionou");
		clienteRepository.findAll();
		
	}
	
}
