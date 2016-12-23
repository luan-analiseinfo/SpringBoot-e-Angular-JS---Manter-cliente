package com.analiseinfo.springBoot.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class TokenFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		
		String header = servletRequest.getHeader("Authorization");
		
		if (header == null || !header.startsWith("Bearer ")) {
			throw new ServletException("Token inexiste ou inválido");
		}
		
		String token = header.substring(7); //Extraindo só o token, sem o Bearer
		try{
			validaToken(token);	
		}catch(SignatureException e){
//			throw new ServletException("Token inválido");
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Acess não autorizado");
		}
		
		chain.doFilter(request, response);
	}

	private void validaToken(String token) {
		Jwts.parser().setSigningKey("banana").parseClaimsJws(token).getBody();
	}

}
