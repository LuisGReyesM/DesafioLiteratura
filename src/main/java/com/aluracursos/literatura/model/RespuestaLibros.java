package com.aluracursos.literatura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record RespuestaLibros(int count,
                              String next,
                              String previous,
                              List<Libro> results) {
}
