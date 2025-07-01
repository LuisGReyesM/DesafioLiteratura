package com.aluracursos.literatura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Libro {
    @JsonAlias("id")
    private int id;

    @JsonAlias("title")
    private String titulo;

    @JsonAlias("authors")
    private List<Autor> autores;

    @JsonAlias("languages")
    private List<String> idiomas;

    @JsonAlias("media_type")
    private String tipoMedia;

    @JsonAlias("formats")
    private Map<String, String> formatos;

    @JsonAlias("download_count")
    private int cantidadDescargas;

    // Getters y setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public List<Autor> getAutores() { return autores; }
    public void setAutores(List<Autor> autores) { this.autores = autores; }

    public List<String> getIdiomas() { return idiomas; }
    public void setIdiomas(List<String> idiomas) { this.idiomas = idiomas; }

    public String getTipoMedia() { return tipoMedia; }
    public void setTipoMedia(String tipoMedia) { this.tipoMedia = tipoMedia; }

    public Map<String, String> getFormatos() { return formatos; }
    public void setFormatos(Map<String, String> formatos) { this.formatos = formatos; }

    public int getCantidadDescargas() { return cantidadDescargas; }
    public void setCantidadDescargas(int cantidadDescargas) { this.cantidadDescargas = cantidadDescargas; }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autores=" + autores +
                ", idiomas=" + idiomas +
                ", tipoMedia='" + tipoMedia + '\'' +
                ", formatos=" + formatos +
                ", cantidadDescargas=" + cantidadDescargas +
                '}';
    }
}