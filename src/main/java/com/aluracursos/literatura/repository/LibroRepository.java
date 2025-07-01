package com.aluracursos.literatura.repository;

import com.aluracursos.literatura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    Optional<Libro> findByTitulo(String titulo);
    List<Libro> findByIdiomasContaining(String idioma);

    @Query("SELECT DISTINCT l FROM Libro l JOIN FETCH l.idiomas i WHERE :idioma IN (i)")
    List<Libro> buscarLibrosPorIdioma(@Param("idioma") String idioma);
}
