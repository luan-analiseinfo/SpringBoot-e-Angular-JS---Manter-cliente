package com.analiseinfo.springBoot.servicies;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.analiseinfo.springBoot.daos.UsuarioRepository;
import com.analiseinfo.springBoot.models.Usuario;

@Service
@Transactional
@CrossOrigin(origins= "*")
public class UsuarioServiceImp implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario buscarPorNomeESenha(Usuario usuario){
		return usuarioRepository.findByNomeAndSenha(usuario.getNome(),usuario.getSenha());
	}

	@Override
	public Collection<Usuario> buscarTodos() {		
		return usuarioRepository.findAll();
	}

	@Override
	public void excluir(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}


	@Override
	public Usuario cadastrar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario alterar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
}
