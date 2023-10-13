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
		
		//Criar lista - VAZIA
		TypeReference<List<ServidorPublico>> typeref = 
				new TypeReference<List<ServidorPublico>>(){}; 
	
		//Abrir arquivo JSON
		InputStream inputstream = TypeReference.class.getResourceAsStream(SERVIDOR);
		
		//Buscar 
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
			
			//Criar lista 
			TypeReference<List<ServidorPublico>> typeref = 
					new TypeReference<List<ServidorPublico>>(){}; 
		
			//Recebendo arquivo JSON - Mapear
			InputStream inputstream = TypeReference.class.getResourceAsStream(SERVIDOR);
			
			//Buscar lista
			List<ServidorPublico> servidorespublicos = new ObjectMapper().readValue(inputstream, typeref);
			
			//Buscar matrícula solicitada
			Optional<ServidorPublico> servidorEncontrado = servidorespublicos.stream().filter(
					//Condição de chamar matricula como valor que foi passado
					servidor -> servidor.matricula().equals(matricula)).findFirst();
						
				return servidorEncontrado;	
			} 
			catch (Exception e)
			{
				System.out.println("Exceção"+e.getMessage());
				return null;
			}
	}

}
