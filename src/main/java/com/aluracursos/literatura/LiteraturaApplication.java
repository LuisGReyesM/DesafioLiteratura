package com.aluracursos.literatura;

import com.aluracursos.literatura.controller.LibroController;
import com.aluracursos.literatura.service.ConsumoApi;
import com.aluracursos.literatura.service.ConvierteDatos;
import com.aluracursos.literatura.service.LibroService;
import com.aluracursos.literatura.view.LibroView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


@SpringBootApplication
public class LiteraturaApplication implements CommandLineRunner {

	@Autowired
	private LibroService libroService;
	private ConsumoApi consumoApi = new ConsumoApi();
	private ConvierteDatos conversor = new ConvierteDatos();
	LibroView libroView = new LibroView();
	@Autowired
	private LibroController libroController;

	private final String URL_BASE = "https://gutendex.com/books/";

	public static void main(String[] args) {
		SpringApplication.run(LiteraturaApplication.class, args);
	}

	@Override
	public void run(String... args) {
		mostrarMenu(libroController);
	}

	private void mostrarMenu(LibroController libroController) {
		Scanner scanner = new Scanner(System.in);
		boolean salir = false;

		while (!salir) {
			System.out.println("\n--- Menú de Literatura ---");
			System.out.println("1. Buscar libro por título");
			System.out.println("2. Listar todos los libros buscados");
			System.out.println("3. Listar libros por idioma");
			System.out.println("4. Listar todos los autores");
			System.out.println("5. Listar autores vivos en un año");
			System.out.println("6. Salir");
			System.out.print("Seleccione una opción: ");
			String opcion = scanner.nextLine();

			switch (opcion) {
				case "1":
					System.out.print("Ingrese el título del libro: ");
					String titulo = scanner.nextLine();
					libroController.buscarLibroPorTitulo(titulo);
					break;
				case "2":
					libroController.mostrarLibrosBuscados();
					break;
				case "3":
					System.out.print("Ingrese el idioma (ej: en, es, fr): ");
					String idioma = scanner.nextLine();
					libroController.mostrarLibrosPorIdiomaDesdeBD(idioma);
					break;
				case "4":
					libroController.mostrarAutores();
					break;
				case "5":
					System.out.print("Ingrese el año para buscar autores vivos: ");
					int anio = Integer.parseInt(scanner.nextLine());
					libroController.mostrarAutoresVivosEnAnio(anio);
					break;
				case "6":
					salir = true;
					System.out.println("Saliendo...");
					break;
				default:
					System.out.println("Opción no válida.");
			}
		}
	}
}