package com.analiseinfo.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class Boot
{

	 @RequestMapping("/olaMundoSpring")
	  public String execute() {
	      System.out.println("Executando a lógica com Spring MVC");
	      return "ok";
	  }
	
   public static void main(String[] args)
   {
      SpringApplication.run(Boot.class, args);
   }
}
