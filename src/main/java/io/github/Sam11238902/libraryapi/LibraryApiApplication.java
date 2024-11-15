package io.github.Sam11238902.libraryapi;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.Sam11238902.libraryapi.model.Autor;
import io.github.Sam11238902.libraryapi.repositories.AutorRepository;

@SpringBootApplication
public class LibraryApiApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(LibraryApiApplication.class, args);

//PEGA O CONTEXTO DA APLICAÇÃO , ISSO SERVE PARA PEGAR UM BEAN QUE ESTA DENTRO DO CONTEXTO DESSA APLICACAO .
		
		var context = SpringApplication.run(LibraryApiApplication.class, args);

		
// DEPOIS QUE PEGUEI O CONTEXTO DA APLICACAO TENHO ACESSO AO BEANS , PEGUEI O BEAN AutorRepository.Class e injetei na minha variavel
		AutorRepository autorRepository = context.getBean(AutorRepository.class);

// POR FIM CHAMEI O METODO PARA SALVAR UMA ENTIDADE.
		salvarAutor(autorRepository);

	}

	public static void salvarAutor(AutorRepository autorRepository) {

		Autor aut1 = new Autor();

		aut1.setName("Deitel");
		aut1.setNacionalidade("EUA");
		aut1.setDataNascimento(LocalDate.of(1970,2,24));

		var autorSalvo = autorRepository.save(aut1);

		System.out.println("Autor Salvo : " + autorSalvo);

	}
	
	

}
