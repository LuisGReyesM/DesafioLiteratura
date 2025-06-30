package com.aluracursos.literatura;

import com.aluracursos.literatura.controller.LibroController;
import com.aluracursos.literatura.service.ConsumoApi;
import com.aluracursos.literatura.view.LibroView;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class LiteraturaApplication {

	public static void main(String[] args) {
		String url = "https://gutendex.com/books/?search=harry+potter";
		ConsumoApi consumoApi = new ConsumoApi();
		LibroView libroView = new LibroView();
		LibroController controller = new LibroController(consumoApi, libroView);

		// Por ahora, búsqueda fija. Luego puedes pedir por consola.
		controller.buscarLibros("harry potter");
	}
	}


