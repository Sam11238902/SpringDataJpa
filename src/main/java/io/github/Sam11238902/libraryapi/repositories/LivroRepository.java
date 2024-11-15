package io.github.Sam11238902.libraryapi.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.Sam11238902.libraryapi.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, UUID> {

}
