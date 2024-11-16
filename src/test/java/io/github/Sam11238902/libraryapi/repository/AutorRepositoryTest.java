package io.github.Sam11238902.libraryapi.repository;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.github.Sam11238902.libraryapi.model.Autor;
import io.github.Sam11238902.libraryapi.repositories.AutorRepository;

@SpringBootTest
public class AutorRepositoryTest {

	
	@Autowired
	AutorRepository autorRepository;
	
	
	@Test
	public void salvarAutor() {

		Autor aut1 = new Autor();

		aut1.setName("Deitel test1");
		aut1.setNacionalidade("EUA");
		aut1.setDataNascimento(LocalDate.of(1970,2,24));

		var autorSalvo = autorRepository.save(aut1);
		//System.out.println(autorSalvo);
		

	}
	
	
	
}
