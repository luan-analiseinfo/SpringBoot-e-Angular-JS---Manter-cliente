package com.analiseinfo.springBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.analiseinfo.springBoot.models.Organizacao;
import com.analiseinfo.springBoot.servicies.OrganizacaoService;

@RestController
public class CRUDRestController {

	@Autowired
	private OrganizacaoService organizacaoService;
	
	//Add Organizacao
	@RequestMapping(value = "/organizacao/new", method = RequestMethod.POST)
	public ResponseEntity<Void> adicionaOrganizacao(@RequestBody Organizacao organizacao, UriComponentsBuilder ucb){
		if(organizacaoService.isOrganizacaoExist(organizacao)){
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}else{
			organizacaoService.salva(organizacao);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucb.path("/organizacao/{id}").buildAndExpand(organizacao.getId()).toUri());
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}
	
	//Get Single Organizacao
	@RequestMapping(value = "/organizacao/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Organizacao> getOrganizacao(@PathVariable("id") int id){
		Organizacao organizacao = organizacaoService.findById(id);
		if (organizacao == null) {
			return new ResponseEntity<Organizacao>(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<Organizacao>(organizacao,HttpStatus.OK);
	}
	
	//getAll organizacaões
	@RequestMapping(value = "/organizacoes", method = RequestMethod.GET)
	public ResponseEntity<List<Organizacao>> listAllOrganizacoes(){
		List<Organizacao> organizacaos = organizacaoService.findAllOrganizacoes();
		if(organizacaos.isEmpty()){
			return new ResponseEntity<List<Organizacao>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Organizacao>>(HttpStatus.OK);
	}
	
	//Add Organizacao
		@RequestMapping(value = "/organizacao/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Organizacao> atualizaOrganizacao(@PathVariable("id") long id, @RequestBody Organizacao org){
			Organizacao organizacao = organizacaoService.findById(id);
			
			if(organizacao == null){
				return new ResponseEntity<Organizacao>(HttpStatus.NOT_FOUND);
			}
			
			organizacao.setRazaoSocial(org.getRazaoSocial());
			organizacao.setRamoAtuacao(org.getRamoAtuacao());
			organizacao.setCnpj(org.getCnpj());
			organizacao.setTelefone(org.getTelefone());
			
			organizacaoService.update(organizacao);
			return new ResponseEntity<Organizacao>(organizacao, HttpStatus.OK);
		}
	
		@RequestMapping(value="/organizacao/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Organizacao> deletaOrganizacao(@PathVariable("id") long id){
			
			Organizacao organizacao = organizacaoService.findById(id);
			
			if(organizacao == null){
				return new ResponseEntity<Organizacao>(HttpStatus.NOT_FOUND);
			}
			
			organizacaoService.deletaById(id);
			return new ResponseEntity<Organizacao>(HttpStatus.NO_CONTENT);
		}
		
		@RequestMapping(value = "/organizacao/deletell")
		public ResponseEntity<Organizacao> deleleAllOrganizacoes(){
			
			organizacaoService.deleteAllOrganizacoes();
			return new ResponseEntity<Organizacao>(HttpStatus.NO_CONTENT);
		}
}