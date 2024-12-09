package io.github.Sam11238902.libraryapi.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.Sam11238902.libraryapi.model.Autor;
import io.github.Sam11238902.libraryapi.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, UUID> {

	
	// Query Methods abaixo 
	// SELECT * FROM livro WHERE Autor = Autor autor <<< FAZ ESSE SELECT NO BANCO 
	 List<Livro> findByAutor(Autor autor);	 
	 
	 // SELECT * FROM livro WHERE titulo = String titulo; << FAZ ESSE SELECT NO BANCO
	 List<Livro> findByTitulo(String titulo);
	
	 
	 List<Livro> findByTituloContainingIgnoreCase(String titulo);
	 
	 
	 
	 List<Livro> findByIsbn(String isbn);
	 
}
