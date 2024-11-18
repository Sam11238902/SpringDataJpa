package io.github.Sam11238902.libraryapi.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.github.Sam11238902.libraryapi.model.Autor;
import io.github.Sam11238902.libraryapi.model.GeneroLivro;
import io.github.Sam11238902.libraryapi.model.Livro;
import io.github.Sam11238902.libraryapi.repositories.AutorRepository;
import io.github.Sam11238902.libraryapi.repositories.LivroRepository;

@SpringBootTest
public class LivroRepositoryTest {
	
	
	
	@Autowired
	LivroRepository livroRepository;
	
	
	@Autowired
	AutorRepository autorRepository;
	
	
	
	
	@Test
	void salvarTest() {
		
		
		Livro livro = new Livro();
		
		livro.setIsbn("90887-8470");
		livro.setPreco(BigDecimal.valueOf(100));
		livro.setGenero(GeneroLivro.FICCAO);
		livro.setTitulo("Java How to Program");
		livro.setDataPublicacao(LocalDate.of(1980, 2, 25));
		
		
		
		Autor autorLivro = autorRepository.findById(UUID.fromString("6705cebb-cd97-46d0-98b9-8d18da1d8981")).orElse(null);		
		
		
		
		
		livro.setAutor(autorLivro);
		
		livroRepository.save(livro);
		
		
	}
	

}
