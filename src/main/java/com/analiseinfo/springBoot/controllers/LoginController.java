package com.analiseinfo.springBoot.controllers;

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
public class LoginController {

	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(value="/autenticar", consumes=MediaType.APPLICATION_JSON_VALUE, method= RequestMethod.POST)
	public ResponseEntity<Usuario> autenticar(@RequestBody Usuario usuario) {
		Usuario usurioAutenticado = usuarioService.buscarPorNomeESenha(usuario);
		
		return new ResponseEntity<>(usurioAutenticado,HttpStatus.OK);
		
	}
	
}
