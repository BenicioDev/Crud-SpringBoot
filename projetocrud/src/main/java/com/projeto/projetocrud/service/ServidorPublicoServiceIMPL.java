package com.projeto.projetocrud.service;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projeto.projetocrud.model.ServidorPublico;

@Service
public class ServidorPublicoServiceIMPL implements ServidorPublicoService {

	private final String SERVIDOR = "/data/servidorpublico.json";
	
	@Override
	public List<ServidorPublico> listAll() {
		
		try {
		
		//Pegar lista 
		TypeReference<List<ServidorPublico>> typeref = 
				new TypeReference<List<ServidorPublico>>(){}; 
	
		//Abrir arquivo
		InputStream inputstream = TypeReference.class.getResourceAsStream(SERVIDOR);
		
		//Buscar lista
		List<ServidorPublico> servidorespublicos = new ObjectMapper().readValue(inputstream, typeref);
		
		return servidorespublicos;
		} 
		catch (Exception e)
		{
			System.out.println("Exceção"+e.getMessage());
			return null;
		}
		
		
	}

	@Override
	public Optional<ServidorPublico> listByMatricula(long matricula) {
		try {
			
			//Pegar lista 
			TypeReference<List<ServidorPublico>> typeref = 
					new TypeReference<List<ServidorPublico>>(){}; 
		
			//Abrir arquivo
			InputStream inputstream = TypeReference.class.getResourceAsStream(SERVIDOR);
			
			//Buscar lista
			List<ServidorPublico> servidorespublicos = new ObjectMapper().readValue(inputstream, typeref);
			
				Optional<ServidorPublico> servidorEncontrado = servidorespublicos.stream().filter(
						servidor -> servidor.matricula().equals(matricula)).findFirst();
						
					
			} 
			catch (Exception e)
			{
				System.out.println("Exceção"+e.getMessage());
				return null;
			}
	}

}
