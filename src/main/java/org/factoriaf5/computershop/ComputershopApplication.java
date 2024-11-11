package org.factoriaf5.computershop;

import org.factoriaf5.computershop.computers.CompService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ComputerShopApplication implements CommandLineRunner {
    // implements CommandLineRunner para ejecutar código al iniciar la aplicación

    @Autowired // instancia automática de CompService (inyección dependencias)
    private CompService compService;

    public static void main(String[] args) {
        // inicia la aplicación Spring Boot y permite que Spring gestione los beans
        SpringApplication.run(ComputerShopApplication.class, args);
    }

    @Override
	public void run(String... args) {
		// Mostrar el menú y obtener la elección del usuario
		short choosenMenuOption = compService.showMenu();
		System.out.println("opcion elegida + " + choosenMenuOption);

	}

/*     @Override
    public void run(String... args) {

        // Muestra el menú y obtiene la elección del usuario
        short choosenMenuOption = compService.showMenu();
        System.out.println("opcion elegida + " + choosenMenuOption);

        // Llama a otros métodos según la opción seleccionada
        //methodDependsOnChoosenMenu(choosenMenuOption);

        // compService.closeConsoleScanner();
    } */

/*     public void methodDependsOnChoosenMenu(short choosenMenuOption) {
        // short option = compService.showMenu();
		System.out.println("entra aquí??, opcion a ejecutar " + choosenMenuOption);
        switch (choosenMenuOption) { 
            case 1: 
                System.out.println("Añadir ordenador ");
                break; 
            case 2: 
                // Listar ordenadores 
                break; 
            case 3: 
                // Buscar ordenador por marca
                break; 
            case 4: 
                // Eliminar ordenador por marca 
                break; 
            case 5: 
                // Salir del programa 
                break; 
            default: 
                System.out.println("Opción no válida. Elije entre 1 y 5"); 
				short newOption = compService.showMenu(); 
				methodDependsOnChoosenMenu(newOption);
                //compService.showMenu();
        }
		System.out.println("estoy fuera del switch");

    } */

}