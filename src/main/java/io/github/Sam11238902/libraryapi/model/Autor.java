package io.github.Sam11238902.libraryapi.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


// @ENTITY RELACIONA ESSA ENTITADE AO MODELO ORM PARA O BANCO .
// @TABLE É O NOME DA TABELA NO BANCO E SCHEMA O SCHEMA DO BANCO CASO TENHA VARIOS SCHEMA


@Entity
@Table(name=  "autor", schema = "public")
@Getter
@Setter
public class Autor {
	
	
	@Id
	@Column(name ="id")
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	
	@Column(name = "nome", length = 100, nullable = false)
	private String name;
	
	@Column(name ="date_nascimento", nullable = false)
	private LocalDate dataNascimento;

	@Column(name = "nacionalidade", length = 50, nullable = false)
	private String nacionalidade;

	
	@OneToMany(mappedBy = "autor")
	private List<Livro> listLivros;
	
	
	
}



