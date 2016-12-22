package com.analiseinfo.springBoot.servicies;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.analiseinfo.springBoot.daos.ClienteRepository;
import com.analiseinfo.springBoot.models.Cliente;

@Service
@Transactional
@CrossOrigin(origins= "*")
public class ClienteServiceImpl  implements ClienteService{
	@Autowired
	ClienteRepository clienteRepository; 


	// Negocios
	public Cliente cadastrar(Cliente cliente) {
		return clienteRepository.save(cliente);

	}

	@Override
	public Collection<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}
	@Override
	public void excluir (Cliente cliente){
		clienteRepository.delete(cliente);
	}
	
	@Override
	public Cliente buscarPorId(Long id) {
		return clienteRepository.findOne(id);
	}
	
	@Override
	public Cliente alterar(Cliente cliente){
		return clienteRepository.save(cliente);
	}
}