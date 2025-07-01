package com.aluracursos.literatura.view;

import com.aluracursos.literatura.model.Libro;
import com.aluracursos.literatura.model.RespuestaLibros;

public class LibroView {

    public void mostrarLibros(RespuestaLibros respuesta) {
        System.out.println("Total de libros encontrados: " + respuesta.count());
        for (Libro libro : respuesta.results()) {
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autores:");
            libro.getAutores().forEach(a ->
                    System.out.println("\t" + a.getNombre() + " (" + a.getAnioNacimiento() + "-" + a.getAnioFallecimiento() + ")")
            );
            System.out.println("Formatos disponibles: " + libro.getFormatos().keySet());
            System.out.println("-----------");
        }
    }
}
