package com.aluracursos.literatura.service;

public interface IconvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase );
}
