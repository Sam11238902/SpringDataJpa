package io.github.Sam11238902.libraryapi.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	void salvarTest() {

		Livro livro = new Livro();

		livro.setIsbn("90887-8470");
		livro.setPreco(BigDecimal.valueOf(100));
		livro.setGenero(GeneroLivro.FICCAO);
		livro.setTitulo("Java How to Program");
		livro.setDataPublicacao(LocalDate.of(1980, 2, 25));
		Autor autorLivro = autorRepository.findById(UUID.fromString("6705cebb-cd97-46d0-98b9-8d18da1d8981"))
				.orElse(null);
		livro.setAutor(autorLivro);
		livroRepository.save(livro);
	}

	@Test
	@Transactional
	void salvarAutorCascate() {

		Livro livro = new Livro();

		livro.setIsbn("90887-8470");
		livro.setPreco(BigDecimal.valueOf(100));
		livro.setGenero(GeneroLivro.FICCAO);
		livro.setTitulo("Java How to Program");
		livro.setDataPublicacao(LocalDate.of(1980, 2, 25));

		Autor aut1 = new Autor();
		aut1.setName("João Da Silva");
		aut1.setNacionalidade("EUA");
		aut1.setDataNascimento(LocalDate.of(1980, 2, 24));

		livro.setAutor(aut1);
		livroRepository.save(livro);

	}

	@Test
	@Transactional
	void buscarLivroTest() {
		UUID id = UUID.fromString("5d7fea59-7fd0-48b6-8868-147fb35bc930");
		Livro livro = livroRepository.findById(id).orElse(null);
		System.out.println("Livro : \n");
		System.out.println(livro.getTitulo());
		System.out.println(livro.getAutor());
	
	}
	
	@Test
	@Transactional
	void pesquisarPorTituloTest() {

		List<Livro> listTitulo = livroRepository.findByTituloContainingIgnoreCase("Saga");

		System.out.println("IMPRIMINDO BUSCA POR TITULO PERSONALIZADA : ");

		for (Livro livro : listTitulo) {
			System.out.println(livro);
		}

		System.out.println("*******************************************");

	}
	
	
	
	@Test
	void pesquisaPorTituloTest() {
		
		List<Livro> lista = livroRepository.findByTitulo("Desinformado");
		System.out.println("Pesuisa por livro : ");
		
		for(Livro livro : lista) {
			System.out.println(livro);
		}
	
	}
	
	@Test
	void pesquisaPorIsbnTest() {
		List<Livro> lista = livroRepository.findByIsbn("90887-8470");
		
		System.out.println("Pesuisa por Isbn : ");
	
		for(Livro livro : lista ) {
			System.out.println(livro);
		}
	}
	
}
