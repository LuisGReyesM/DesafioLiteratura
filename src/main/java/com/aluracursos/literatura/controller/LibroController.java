package com.aluracursos.literatura.controller;

import com.aluracursos.literatura.service.ConsumoApi;
import com.aluracursos.literatura.view.LibroView;

public class LibroController {
    private final ConsumoApi consumoApi;
    private final LibroView libroView;

    public LibroController(ConsumoApi consumoApi, LibroView libroView) {
        this.consumoApi = consumoApi;
        this.libroView = libroView;
    }

    public void buscarLibros(String terminoBusqueda) {
        String url = "https://gutendex.com/books/?search=" + terminoBusqueda.replace(" ", "%20");
        String respuesta = consumoApi.obtenerDatos(url);
        libroView.mostrarRespuestaApi(respuesta);
    }
}
