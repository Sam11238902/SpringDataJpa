package io.github.Sam11238902.libraryapi.model;

import java.math.BigDecimal;
import java.util.UUID;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "livro")
@Data // @Anotation @Data , incorpora , @Getter , @Setter @ToString, @EqualsAndHashCode @RequiredArgsContructor
@NoArgsConstructor
@AllArgsConstructor

public class Livro {
		
	@Id
	@Column(name = "id", nullable = false)
	private UUID id;
	
	
	@Column(name = "isbn", length = 20, nullable = false)
	private String isbn;
	
	@Column(name = "titulo", length = 150, nullable = false)
	private String titulo;
	
	
	@Column(name = "genero", length = 30, nullable = false)
	@Enumerated(EnumType.STRING)
	private GeneroLivro genero;
	
	@Column(name = "preco", precision = 18, scale = 2 , nullable = false )
	private BigDecimal preco;
	
	
	@ManyToOne
	@JoinColumn(name = "id_autor")
	private Autor autor;
	
	
/*
 
create table livro (
	id uuid not null primary key,
	isbn varchar(20) not null,
	titulo varchar(150) not null,
	genero varchar(30) not null,
	preco numeric (18,2) not null,
	id_autor uuid not null references autor(id),
	CONSTRAINT chk_genero check(genero in ('FICCAO','FANTASIA',
	'MISTERIO','ROMANCE','BIOGRAFIA','CIENCIA'))
	
);
 */
	
	
}


