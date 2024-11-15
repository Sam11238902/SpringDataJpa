package io.github.Sam11238902.libraryapi.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.Sam11238902.libraryapi.model.Autor;


@Repository
public interface AutorRepository extends JpaRepository<Autor, UUID>{

	
	
		
}
