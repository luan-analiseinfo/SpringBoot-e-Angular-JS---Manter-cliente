package com.analiseinfo.springBoot.servicies;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.analiseinfo.springBoot.models.Cliente;

@Service
@CrossOrigin(origins= "*")
public interface ClienteService {

	Collection<Cliente> buscarTodos();

	void excluir(Cliente cliente);

	Cliente buscarPorId(Long id);

	Cliente alterar(Cliente cliente);

	Cliente cadastrar(Cliente cliente);
	
	
	

}
