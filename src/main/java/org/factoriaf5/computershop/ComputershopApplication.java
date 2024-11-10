package org.factoriaf5.computershop;

import javax.swing.Spring;

import org.factoriaf5.computershop.computers.CompRepository;
import org.factoriaf5.computershop.computers.CompService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ComputerShopApplication implements CommandLineRunner {
	// implements CommandLineRunner para ejecutar código al iniciar la aplicación

	@Autowired  // instancia automática de CompService (inyección dependencias)
	private	CompService compService;  
	
	public static void main(String[] args) {
		// inicia la aplicación Spring Boot y permite que Spring gestione los beans
		SpringApplication.run(ComputerShopApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// Mostrar el menú y obtener la elección del usuario
		short choosenMenuOption = compService.showMenu();
		
		throw new UnsupportedOperationException("Unimplemented method 'run'");
	}
	
	// Llamar a otros métodos según la opción seleccionada
	
	//compService.console.close();

}