package com.aluracursos.literatura.view;

import com.aluracursos.literatura.model.Libro;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class LibroView {

    public void mostrarLibro(Libro libro) {
        System.out.println("Título: " + libro.getTitulo());
        System.out.println("Autor(es):");
        if (libro.getAutor() != null) {
            System.out.println("\t" + libro.getAutor().getNombre() + " (" + libro.getAutor().getAnioNacimiento() + " - " + libro.getAutor().getAnioFallecimiento() + ")");
        } else {
            System.out.println("\tAutor desconocido");
        }
        System.out.println("Idioma: " + (libro.getIdiomas().isEmpty() ? "Desconocido" : libro.getIdiomas().get(0)));
        System.out.println("Descargas: " + libro.getCantidadDescargas());
        System.out.println("-----------");
    }


    public void mostrarListadoLibros(List<Libro> libros) {
        if (libros.isEmpty()) {
            System.out.println("No hay libros para mostrar.");
            return;
        }

        for (Libro libro : libros) {
            mostrarLibro(libro);
        }
    }
}
