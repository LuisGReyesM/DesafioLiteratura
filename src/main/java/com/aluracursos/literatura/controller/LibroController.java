package com.aluracursos.literatura.controller;

import com.aluracursos.literatura.model.RespuestaLibros;
import com.aluracursos.literatura.service.ConsumoApi;
import com.aluracursos.literatura.service.ConvierteDatos;
import com.aluracursos.literatura.view.LibroView;

public class LibroController {
    private final ConsumoApi consumoApi;
    private final ConvierteDatos conversor;
    private final LibroView libroView;

    public LibroController(ConsumoApi consumoApi, ConvierteDatos conversor, LibroView libroView) {
        this.consumoApi = consumoApi;
        this.conversor = conversor;
        this.libroView = libroView;
    }

    public void buscarLibros(String terminoBusqueda) {
        String url = "https://gutendex.com/books/?search=" + terminoBusqueda.replace(" ", "%20");
        String json = consumoApi.obtenerDatos(url);

        RespuestaLibros respuestaLibros = conversor.obtenerDatos(json, RespuestaLibros.class);

        libroView.mostrarLibros(respuestaLibros);
    }
}
