package com.analiseinfo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.analiseinfo.springBoot.Boot;
import com.analiseinfo.springBoot.models.Usuario;
import com.analiseinfo.springBoot.servicies.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Boot.class)
@WebAppConfiguration
public class UsuarioTest {

	@Autowired
	UsuarioService usuarioService;
	
	@Test
	public void teste(){
		Usuario usuario = new Usuario();
		usuario.setNome("Luan");
		usuario.setSenha("admin");
		usuarioService.buscarPorNomeESenha(usuario);
		System.out.println(usuario.getNome() + "  " + usuario.getSenha());
		
	}
	
}
