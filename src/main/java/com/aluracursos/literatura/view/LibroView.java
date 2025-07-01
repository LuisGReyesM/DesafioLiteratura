package com.aluracursos.literatura.view;

import com.aluracursos.literatura.model.Autor;
import com.aluracursos.literatura.model.Libro;
import org.springframework.stereotype.Component;

import java.util.List;
@Component

public class LibroView {

    public void mostrarLibro(Libro libro) {
        System.out.println("\n📚 Libro encontrado:");
        System.out.println("Título: " + libro.getTitulo());
        System.out.println("Autor: " + (libro.getAutor() != null ? libro.getAutor().getNombre() : "Desconocido"));
        System.out.println("Media Type: " + libro.getTipoMedia());
        System.out.println("Descargas: " + libro.getCantidadDescargas());
        System.out.println("Idiomas: " + String.join(", ", libro.getIdiomas()));
    }

    public void mostrarListadoLibros(List<Libro> libros) {
        if (libros.isEmpty()) {
            System.out.println("No hay libros para mostrar.");
            return;
        }

        System.out.println("\n📖 Lista de libros:");
        libros.forEach(libro -> {
            System.out.println("- " + libro.getTitulo() + " (Autor: " +
                    (libro.getAutor() != null ? libro.getAutor().getNombre() : "Desconocido") + ")");
        });
    }

    public void mostrarListadoAutores(List<Autor> autores) {
        System.out.println("\n👤 Lista de autores:");
        for (Autor autor : autores) {
            System.out.println("- " + autor.getNombre() +
                    " | Nacimiento: " + (autor.getAnioNacimiento() != null ? autor.getAnioNacimiento() : "¿?") +
                    " | Fallecimiento: " + (autor.getAnioFallecimiento() != null ? autor.getAnioFallecimiento() : "¿?")
            );
        }
    }
}