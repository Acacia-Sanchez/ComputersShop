package org.factoriaf5.computershop.computers;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class CompService {

    String color1 = "\033[96m";
    String color1b = "\033[1;96m";
    String color2 = "\033[35m";
    String color3 = "\033[94m";
    String color4 = "\033[91m";
    String color5 = "\033[92m";
    String color6 = "\033[97m";
    String color7 = "\033[93m";
    String color10 = "\033[38;5;206;48;5;57m";
    String reset = "\033[0m";

    private final Scanner console = new Scanner(System.in);
    private final CompRepository compRepository;

    public CompService(CompRepository compRepository) {
        this.compRepository = compRepository;
    }

    
    public short showMenu() {
        System.out.println("\n");
        System.out.println(color1 + "     ==========================" + color7);
        System.out.println("      MENÚ GESTIÓN ORDENADORES");
        System.out.println(color1 + "     ==========================" + reset);
        System.out.println("       1. AÑADIR ORDENADOR");
        System.out.println("       2. LISTAR ORDENADORES");
        System.out.println("       3. BUSCAR ORDENADOR POR MARCA");
        System.out.println("       4. ELIMINAR ORDENADOR POR MARCA");
        System.out.println("       5. SALIR DEL PROGRAMA");
        System.out.print(color7 + "\n       Elije una opción: ");
        short choosenMenuOption = console.nextShort();
        System.out.println(reset + "");
        return choosenMenuOption;
    }
    
        // opción 1. AÑADIR ORDENADOR
    public Computers addOne(Computers computers) {
        return compRepository.save(computers);
    }
        // opción 2. LISTAR ORDENADORES
    public List<Computers> getAll() {
        return compRepository.findAll();
    }
        // opción 3. BUSCAR ORDENADOR POR MARCA
    public List<Computers> findOneByTrade(String trade) {
        return compRepository.findByTrade(trade);
    }
        // opción 4. ELIMINAR ORDENADOR POR MARCA
    public void deleteOneByTrade(String trade) {
        compRepository.deleteByTrade(trade);
    }
        // opción 
    public void deleteOneById(Long id) {
        compRepository.deleteById(id);
    }


    public void closeConsoleScanner() {
        console.close();
    }

}