package org.factoriaf5.computershop;

import java.util.concurrent.TimeUnit;

import org.factoriaf5.computershop.computers.CompService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ComputershopApplication implements CommandLineRunner {
    // implements CommandLineRunner para ejecutar código al iniciar la aplicación

    String color1 = "\033[96m";  // cyan
    String color1b = "\033[1;96m";  // cyan bold
    String color2 = "\033[35m";  // morado
    String color3 = "\033[94m";  // azul
    String color4 = "\033[91m";  // rojo
    String color5 = "\033[92m";  // verde
    String color6 = "\033[97m";
    String color7 = "\033[93m";  // amarillo
    String color10 = "\033[38;5;206;48;5;57m";
    String reset = "\033[0m";  // blanco

    private boolean loopMenu = true;

    @Autowired // instancia automática de CompService (inyección dependencias)
    private CompService compService;

    public static void main(String[] args) {
        // inicia la aplicación Spring Boot y permite que Spring gestione los beans
        SpringApplication.run(ComputershopApplication.class, args);
    }

    @Override
    public void run(String... args) {

        while (loopMenu) {
                // Muestra el menú y obtiene la elección del usuario
            short choosenMenuOption = compService.showMenu();

                // Llama al método correspondiente según la opción seleccionada
            methodDependsOnChoosenMenu(choosenMenuOption);

        }
        compService.closeConsoleScanner();
    }

    public void methodDependsOnChoosenMenu(short choosenMenuOption) {
        switch (choosenMenuOption) { 
            case 1: 
                System.out.println("1. Añadir ordenador ");
                break; 
            case 2: 
                System.out.println("2. Listar ordenadores");
                break; 
            case 3: 
                System.out.println("3. Buscar ordenador por marca");
                break; 
            case 4: 
                System.out.println("4. Eliminar ordenador por marca"); 
                break; 
            case 5: 
                System.out.println(color4 + "5. Saliendo del programa... ¡ Hasta pronto !" + reset); 
                loopMenu = false;
                break; 
            default: 
                System.out.println(color4 + "Opción no válida. Elije entre 1 y 5" + reset); 
                try {
                    TimeUnit.SECONDS.sleep(2); // pausa el programa 2 segundos para que se vea bien el mensaje
                } catch (InterruptedException e) {
                    // e.printStackTrace();
                    Thread.currentThread().interrupt();
                    System.out.println("¡ Interrupción inesperada !");
                }
        }
    }



}