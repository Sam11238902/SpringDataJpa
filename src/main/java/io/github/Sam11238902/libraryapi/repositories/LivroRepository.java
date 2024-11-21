package io.github.Sam11238902.libraryapi.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.Sam11238902.libraryapi.model.Autor;
import io.github.Sam11238902.libraryapi.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, UUID> {

	
	//QUERY METHOD , METODO DE CONSULTA PERSONALIZADA 
	
	 List<Livro> findByAutor(Autor autor);
	 
	
}
