package com.analiseinfo.springBoot.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.analiseinfo.springBoot.models.Usuario;
import com.analiseinfo.springBoot.servicies.UsuarioService;

@RestController
@RequestMapping(value="/api")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value="/usuarios", consumes=MediaType.APPLICATION_JSON_VALUE, method= RequestMethod.POST)
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioCadastrado = usuarioService.cadastrar(usuario);
		return new ResponseEntity<Usuario>(usuarioCadastrado,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/usuarios", consumes=MediaType.APPLICATION_JSON_VALUE, method= RequestMethod.GET)
	public ResponseEntity<Collection<Usuario>> cadastrarUsuario() {
		Collection<Usuario> usuarios = usuarioService.buscarTodos();
		return new ResponseEntity<>(usuarios,HttpStatus.OK);
		
	}
	
}
	
