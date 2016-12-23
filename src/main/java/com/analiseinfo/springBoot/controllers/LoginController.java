package com.analiseinfo.springBoot.controllers;

import java.util.Date;

import javax.servlet.ServletException;

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

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class LoginController {

	@Autowired
	UsuarioService usuarioService;

	@RequestMapping(value = "/autenticar", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public LoginResponse autenticar(@RequestBody Usuario usuario) throws ServletException {
		
		if (usuario.getNome() == null || usuario.getSenha() == null) {
			throw new ServletException("Usuaário ou senha inválidos");
		}
		
		Usuario usurioAutenticado = usuarioService.buscarPorNomeESenha(usuario);

		if (!usurioAutenticado.getSenha().equals(usurioAutenticado.getSenha())) {
			throw new ServletException("Usuaário ou senha inválidos");
		}
				
		String token = geraTokenDoUsuario(usurioAutenticado);
		
		

		return new LoginResponse(token);

	}

	private String geraTokenDoUsuario(Usuario usurioAutenticado) {
		return Jwts.builder().setSubject(usurioAutenticado.getNome())
				.signWith(SignatureAlgorithm.HS512, "banana")
				.setExpiration(new Date(System.currentTimeMillis() + 1 * 60 * 1000 ))
				.compact();
	}

	private class LoginResponse {
		public String token;

		public LoginResponse(String token) {
			this.token = token;
		}

	}

}
