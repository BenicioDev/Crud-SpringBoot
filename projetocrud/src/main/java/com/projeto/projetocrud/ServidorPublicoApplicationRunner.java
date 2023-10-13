package com.projeto.projetocrud;

import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.projeto.projetocrud.model.ServidorPublico;
import com.projeto.projetocrud.service.ServidorPublicoService;

public class ServidorPublicoApplicationRunner implements CommandLineRunner {

	private ServidorPublicoService servidorService;
	
	// DI
	@Autowired
	public void setServidorPublicoService (ServidorPublicoService servidorService) {
		this.servidorService = servidorService;
	}
	
	//Método 1 - Chamar Service - listAll()
	public void listAll() {
		List<ServidorPublico> servidorespublicos = servidorService.listAll();
		
		if (servidorespublicos.size() !=0) {
			servidorespublicos.forEach(
					servidor -> {
						System.out.println("»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»");
						System.out.println(servidor.matricula());
						System.out.println(servidor.nome());
						System.out.println(servidor.foto());
						System.out.println(servidor.orgao());
					}
					);
		}
		else {
			System.out.print("Arquivo vazio");
		}
	}
	
	//Método 2 - receber matrícula
	public void listByMatricula() {
		long matricula = Long.parseLong(JOptionPane.showInputDialog("Digite matrícula desejada: "));
		Optional<ServidorPublico> servidorEncontrado = servidorService.listByMatricula(matricula);
		
		if(servidorEncontrado.isPresent()) {
			System.out.println("»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»");
			System.out.println(servidorEncontrado.get().matricula());
			System.out.println(servidorEncontrado.get().nome());
			System.out.println(servidorEncontrado.get().foto());
			System.out.println(servidorEncontrado.get().orgao());
		} else {
			System.out.print("Matrícula inexistente");
		}
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		

	}

}
