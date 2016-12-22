package com.analiseinfo.springBoot.servicies;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.analiseinfo.springBoot.models.Usuario;

@Service
public interface UsuarioService {

	Usuario buscarPorNomeESenha(Usuario usuario);
	
	Collection<Usuario> buscarTodos();

	void excluir(Usuario usuario);

	Usuario alterar(Usuario usuario);

	Usuario cadastrar(Usuario usuario);
	
	
	
	
}
