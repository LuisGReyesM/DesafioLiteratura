package com.aluracursos.literatura;

import com.aluracursos.literatura.controller.LibroController;
import com.aluracursos.literatura.service.ConsumoApi;
import com.aluracursos.literatura.service.ConvierteDatos;
import com.aluracursos.literatura.view.LibroView;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


@SpringBootApplication
public class LiteraturaApplication implements CommandLineRunner {
	private ConsumoApi consumoApi = new ConsumoApi();
	private ConvierteDatos conversor = new ConvierteDatos();
	LibroView libroView = new LibroView();
	LibroController libroController = new LibroController(consumoApi, conversor, libroView);
	private final String URL_BASE = "https://gutendex.com/books/";

	public static void main(String[] args) {
		SpringApplication.run(LiteraturaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		mostrarMenu();
	}

	private void mostrarMenu() {
		Scanner scanner = new Scanner(System.in);
		boolean salir = false;

		while (!salir) {
			System.out.println("\n--- Menú de Literatura ---");
			System.out.println("1. Insertar libro");
			System.out.println("2. Consultar libro por título");
			System.out.println("3. Listar todos los libros");
			System.out.println("4. Salir");
			System.out.print("Seleccione una opción: ");

			String opcion = scanner.nextLine();

			switch (opcion) {
				case "1":
					insertarLibro(scanner);
					break;
				case "2":
					consultarLibroPorTitulo(scanner);
					break;
				case "3":
					listarLibros();
					break;
				case "4":
					salir = true;
					System.out.println("Saliendo de la aplicación...");
					break;
				default:
					System.out.println("Opción inválida. Intente nuevamente.");
			}
		}

		scanner.close();
	}

	private void insertarLibro(Scanner scanner) {
		System.out.println("\n--- Insertar nuevo libro ---");
		System.out.print("Ingrese el título: ");
		String titulo = scanner.nextLine();
		// Podés pedir más datos según tu modelo
		// Por ejemplo, autores, idioma, etc.
		System.out.println("Libro '" + titulo + "' insertado (simulado).");
	}

	private void consultarLibroPorTitulo(Scanner scanner) {
		System.out.print("\nIngrese el título a buscar: ");
		String titulo = scanner.nextLine();
		libroController.buscarLibros(titulo);
	}

	private void listarLibros() {
		System.out.println("\n--- Listado de libros populares ---");
		libroController.buscarLibros("book"); // Puedes usar "" para todos, o un término común
	}
}
