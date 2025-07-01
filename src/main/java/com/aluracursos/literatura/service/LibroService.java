package com.aluracursos.literatura.service;

import com.aluracursos.literatura.repository.AutorRepository;
import com.aluracursos.literatura.repository.LibroRepository;
import com.aluracursos.literatura.dto.LibroDTO;
import com.aluracursos.literatura.model.Autor;
import com.aluracursos.literatura.model.Libro;
import com.aluracursos.literatura.model.RespuestaLibros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
@Service
public class LibroService {
    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;

    public LibroService(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public Libro guardarLibroConAutor(Libro libro) {
        // Verifica si el libro ya existe por su título
        Optional<Libro> libroExistente = libroRepository.findByTitulo(libro.getTitulo());
        if (libroExistente.isPresent()) {
            return libroExistente.get();
        }

        // Verifica si el autor ya existe
        Autor autor = libro.getAutor();
        Optional<Autor> autorExistente = autorRepository.findByNombre(autor.getNombre());
        if (autorExistente.isPresent()) {
            libro.setAutor(autorExistente.get());
        } else {
            Autor autorGuardado = autorRepository.save(autor);
            libro.setAutor(autorGuardado);
        }

        return libroRepository.save(libro);
    }
    // Nuevo método para obtener libros por idioma desde la base de datos
    public List<Libro> obtenerLibrosPorIdioma(String idioma) {
        return libroRepository.buscarLibrosPorIdioma(idioma);
    }




}
