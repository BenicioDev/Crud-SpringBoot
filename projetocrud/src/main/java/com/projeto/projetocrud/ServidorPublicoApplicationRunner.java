package com.projeto.projetocrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.projeto.projetocrud.service.ServidorPublicoService;

public class ServidorPublicoApplicationRunner implements CommandLineRunner {

	private ServidorPublicoService servidorService;
	
	// DI
	@Autowired
	public void setServidorPublicoService (ServidorPublicoService servidorService) {
		this.servidorService = servidorService;
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		

	}

}
