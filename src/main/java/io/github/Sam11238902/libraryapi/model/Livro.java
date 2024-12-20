package io.github.Sam11238902.libraryapi.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data // @Anotation @Data , incorpora , @Getter , @Setter @ToString, @EqualsAndHashCode @RequiredArgsContructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "livro")
public class Livro {
		
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
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
	
	
	@Column(name ="data_publicacao", nullable = false)
	private LocalDate dataPublicacao;
	
	//(cascade = CascadeType.ALL)
	
	
	// ESSE TIPO DE FETCH QUANDO EU FAÇO UM BUSCAR ELE NÃO TRAS OS DADOS DO AUTOR , SOMENTE O DO LIVRO.
	// ISSO AJUDA NA ECONOMIA DE DADOS , POR EXEMPL , SE O AUTOR TIVER MAIS COMPOSICOES PARA NAO SELECIONAR COISAS
	// COISAS QUE NAO PRECISA . 
	
	
	@ManyToOne()
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


