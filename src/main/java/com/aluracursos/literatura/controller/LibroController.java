package com.aluracursos.literatura.controller;


import com.aluracursos.literatura.dto.LibroDTO;
import com.aluracursos.literatura.model.Autor;
import com.aluracursos.literatura.model.Libro;
import com.aluracursos.literatura.model.RespuestaLibros;
import com.aluracursos.literatura.service.AutorService;
import com.aluracursos.literatura.service.ConsumoApi;
import com.aluracursos.literatura.service.ConvierteDatos;
import com.aluracursos.literatura.service.LibroService;
import com.aluracursos.literatura.view.LibroView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class LibroController {
    private final ConsumoApi consumoApi;
    private final ConvierteDatos conversor;
    private final LibroView libroView;
    private final LibroService libroService;
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private final List<Libro> librosBuscados = new ArrayList<>();
    private AutorService autorService;

    public LibroController(ConsumoApi consumoApi, ConvierteDatos conversor, LibroView libroView, LibroService libroService,AutorService autorService) {
        this.consumoApi = consumoApi;
        this.conversor = conversor;
        this.libroView = libroView;
        this.libroService = libroService;
        this.autorService = autorService;
    }

    public void buscarLibroPorTitulo(String titulo) {
        String json = consumoApi.obtenerDatos(URL_BASE + titulo.replace(" ", "%20"));
        RespuestaLibros respuesta = conversor.obtenerDatos(json, RespuestaLibros.class);

        if (respuesta.getResults().isEmpty()) {
            System.out.println("No se encontró el libro.");
            return;
        }

        // Obtener el primer resultado y convertirlo a LibroDTO
        LibroDTO libroDTO = respuesta.getResults().get(0);
        Libro libro = libroDTO.toModelo();

        libroService.guardarLibroConAutor(libro);
        librosBuscados.add(libro);
        libroView.mostrarLibro(libro);
    }

    public void mostrarLibrosBuscados() {
        libroView.mostrarListadoLibros(librosBuscados);
    }

    /*public void mostrarLibrosPorIdioma(String idioma) {
        List<Libro> filtrados = librosBuscados.stream()
                .filter(l -> l.getIdiomas().contains(idioma))
                .toList();
        libroView.mostrarListadoLibros(filtrados);
    }*/

    public void mostrarLibrosPorIdiomaDesdeBD(String idioma) {
        List<Libro> libros = libroService.obtenerLibrosPorIdioma(idioma);

        libros.stream()
                .forEach(libro -> System.out.println(
                        "Título: " + libro.getTitulo() +
                                ", Idiomas: " + libro.getIdiomas() +
                                ", Descargas: " + libro.getCantidadDescargas()
                ));
    }


    public void mostrarAutores() {
        List<Autor> autores = autorService.listarAutores();
        if (autores.isEmpty()) {
            System.out.println("No se encontraron autores.");
        } else {
            autores.forEach(a -> System.out.println(
                    "Nombre: " + a.getNombre() + ", Nacimiento: " + a.getAnioNacimiento() +
                            ", Fallecimiento: " + a.getAnioFallecimiento()
            ));
        }
    }

    public void mostrarAutoresVivosEnAnio(int anio) {
        List<Autor> autores = autorService.listarAutoresVivosEnAnio(anio);
        if (autores.isEmpty()) {
            System.out.println("No se encontraron autores vivos en el año " + anio);
        } else {
            autores.forEach(a -> System.out.println(
                    "Nombre: " + a.getNombre() + ", Nacimiento: " + a.getAnioNacimiento()
            ));
        }
    }

}