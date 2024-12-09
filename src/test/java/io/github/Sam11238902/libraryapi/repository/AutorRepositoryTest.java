package io.github.Sam11238902.libraryapi.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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


// ESSA CLASSE VAI SUBIR ESSES TESTES NO BANCO DE DADOS.

@SpringBootTest
public class AutorRepositoryTest {

	
	@Autowired
	AutorRepository autorRepository;
	
	@Autowired
	LivroRepository livroRepository;
	
	
	
	
	@Test
	@Transactional
	public void salvarAutor() {
	
		Autor aut1 = new Autor();

		aut1.setName("Deitel test2");
		aut1.setNacionalidade("EUA");
		aut1.setDataNascimento(LocalDate.of(1980,2,24));

		var autorSalvo = autorRepository.save(aut1);
		//System.out.println(autorSalvo);
		

	}
	
	@Test
	@Transactional
	public void atualizarTest() {

		var id = UUID.fromString("9f37640e-8fb9-42ca-bbf5-71380dc752a2");

		Optional<Autor> possivelAutor = autorRepository.findById(id);

		if (possivelAutor.isPresent()) {

			Autor autorEncontrado = possivelAutor.get();

			System.out.println("Dados do autor : " + autorEncontrado);

			autorEncontrado.setDataNascimento(LocalDate.of(2000, 2, 20));

			autorRepository.save(autorEncontrado);
		}

	}
	
	@Test
	@Transactional
	public void  listar() {
		
		List<Autor> listaAutor = autorRepository.findAll();
		
		for (Autor autor : listaAutor) {
			System.out.println(autor);
		}
		
	}
	
	
	@Test
	void listarLivrosAutor() {
		
		UUID id = UUID.fromString("36a7cc2c-ce74-420e-a6eb-e2df36e4872b");
		
		Autor autor = autorRepository.findById(id).orElse(null);
		
		//COMO O LIST<LIVROS> DE AUTOR ESTA EM FETCH LAZY , ELE NAO CARREGA ,EU PRECISO IR NO LIVROS E BUSCAR POR AUTOR
		// DEPOIS RETORNO PARA DENTRO DE AUTOR A LISTA DE LIVROS DO AUTOR QUE FOI PASSADO ENCONTRADA .
		// É SEMPRE UMA BOA PRATICA USAR O FETCH LAZY , PARA ECONOMIA DE MEMORIA .
		autor.setListLivros(livroRepository.findByAutor(autor));
		
		
		
		
		System.out.println("**** IMPRIMINDO LIVROS DO AUTOR PESQUISADO : \n");
		
		
		for(Livro l : autor.getListLivros()) {
			
			System.out.println(l.toString());
		}
		
	}
	
	
	
	@Test
	@Transactional
	public void contagemAutores() {
		System.out.println("Contagem de autores : " + autorRepository.count());
	}
	
	
	@Test
	@Transactional
	public void deleteAutor() {
		var id = UUID.fromString("8ea0c6b9-c5c5-4296-a61d-a53d6b4b26a6");
		autorRepository.deleteById(id);
		
	}
	
	
	
	
	@Test
	@Transactional
	public void salvarAutorLivros() {
		
		
	
		Autor aut2 = new Autor();

		aut2.setName("GUSTAVO LIMA");
		aut2.setNacionalidade("EUA");
		aut2.setDataNascimento(LocalDate.of(1990,2,24));
	
		Livro livro1= new Livro();
		
		livro1.setIsbn("90887-8470");
		livro1.setPreco(BigDecimal.valueOf(100));
		livro1.setGenero(GeneroLivro.FICCAO);
		livro1.setTitulo("Saga dos jogos2");
		livro1.setDataPublicacao(LocalDate.of(1920, 2, 25));
		livro1.setAutor(aut2);
	
		
		
	
	
		Livro livro2= new Livro();
		
		livro2.setIsbn("90887-8470");
		livro2.setPreco(BigDecimal.valueOf(100));
		livro2.setGenero(GeneroLivro.FICCAO);
		livro2.setTitulo("Desinformando todo mundo");
		livro2.setDataPublicacao(LocalDate.of(1970, 2, 25));
		livro2.setAutor(aut2);
		
		
		aut2.setListLivros(new ArrayList<>());
		aut2.getListLivros().add(livro1);
		aut2.getListLivros().add(livro2);
		
	
		autorRepository.save(aut2);
		
		
	// CASO A LIST<LIVROS> DENTRO DE AUTOR ESTIVER ANOTADA COM CASCADETYPE.CASCADE.ALL , NAO PRECISA SALVAR DESSA FORMA , APENAS
    // SALVANDO O AUTOR QUE TEM UMA LISTA DE LIVROS JA VAI SALVAR OS LIVROS TBM .
	//	livroRepository.saveAll(aut2.getListLivros());
		
		
		
		
	}

}
