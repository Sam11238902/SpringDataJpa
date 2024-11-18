package io.github.Sam11238902.libraryapi.repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.github.Sam11238902.libraryapi.model.Autor;
import io.github.Sam11238902.libraryapi.repositories.AutorRepository;


// ESSA CLASSE VAI SUBIR ESSES TESTES NO BANCO DE DADOS.

@SpringBootTest
public class AutorRepositoryTest {

	
	@Autowired
	AutorRepository autorRepository;
	
	
	@Test
	public void salvarAutor() {

		Autor aut1 = new Autor();

		aut1.setName("Deitel test2");
		aut1.setNacionalidade("EUA");
		aut1.setDataNascimento(LocalDate.of(1980,2,24));

		var autorSalvo = autorRepository.save(aut1);
		//System.out.println(autorSalvo);
		

	}
	
	@Test
	public void atualizarTest() {
		
		var id = UUID.fromString("9f37640e-8fb9-42ca-bbf5-71380dc752a2");
		
		
		Optional<Autor> possivelAutor = autorRepository.findById(id);
				
		
		if(possivelAutor.isPresent()) {
			
			Autor autorEncontrado = possivelAutor.get();
				
			System.out.println("Dados do autor : " + autorEncontrado);
		
			
			autorEncontrado.setDataNascimento(LocalDate.of(2000, 2, 20));
	
			autorRepository.save(autorEncontrado);
		}	
		
	}
}
