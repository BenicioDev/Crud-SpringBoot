package com.projeto.projetocrud.service;

import java.util.List;
import java.util.Optional;

import com.projeto.projetocrud.model.ServidorPublico;

public interface ServidorPublicoService {

	//Recebendo lista JSON
	List<ServidorPublico> listAll();
	
	//Verificação de objetos/registros
	Optional<ServidorPublico> listByMatricula (long matricula);
	
}
