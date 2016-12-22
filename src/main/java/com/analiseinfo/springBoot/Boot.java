package com.analiseinfo.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;

import com.analiseinfo.springBoot.filter.TokenFilter;

@SpringBootApplication
public class Boot {

	@Bean
	public FilterRegistrationBean filtroJwt() {
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setFilter(new TokenFilter());
		bean.addUrlPatterns("/private/*");
		return bean;
	}

	public static void main(String[] args) {
		SpringApplication.run(Boot.class, args);
	}

}
