package br.com.literalura.repository;

import br.com.literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    Optional<Livro> findByTituloContainingIgnoreCase(String titulo);

    @Query("SELECT l FROM Livro l JOIN FETCH l.autores WHERE l.idioma = :idioma")
    List<Livro> findByIdioma(String idioma);

    @Query("SELECT l FROM Livro l JOIN FETCH l.autores")
    List<Livro> findAllWithAutores();
}
