package io.github.Sam11238902.libraryapi.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.web.JsonPath;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


// @ENTITY RELACIONA ESSA ENTITADE AO MODELO ORM PARA O BANCO .
// @TABLE É O NOME DA TABELA NO BANCO E SCHEMA O SCHEMA DO BANCO CASO TENHA VARIOS SCHEMA


@Entity
@Table(name=  "autor", schema = "public")
@Getter
@Setter
@Data
public class Autor {
	
	
	@Id
	@Column(name ="id")
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	
	@Column(name = "nome", length = 100, nullable = false)
	private String name;
	
	@Column(name ="data_nascimento", nullable = false)
	private LocalDate dataNascimento;

	@Column(name = "nacionalidade", length = 50, nullable = false)
	private String nacionalidade;

	
	
	
	
	// É UMA BOA PRATICA SEMPRE UTILIZAR O LAZY
	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@ToString.Exclude
	private List<Livro> listLivros;
		
	
	
}



