package org.factoriaf5.computershop.computers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class CompServiceTest {

    @Mock 
    private CompRepository compRepository; 
    
    @InjectMocks 
    private CompService compService; 

    private Computers computer;
    
    @BeforeEach 
    public void setUp() { 
        MockitoAnnotations.openMocks(this);
        computer = new Computers();
        computer.setTrade("Lenovo");
        computer.setMicro("i7 quad core 6300 Ghz");
        computer.setRam(64);
        computer.setOs("Windows 12");
        computer.setPrice(2000);
    }

    @Test
    void testAddOne() {
        when(compRepository.save(any(Computers.class))).thenReturn(computer);

        Computers savedComputer = compService.addOne(computer);

        System.out.println("Prueba testAddOne ejecutada");
        assertNotNull(savedComputer);
        assertEquals("Lenovo", savedComputer.getTrade());
        verify(compRepository, times(1)).save(computer);
    }

    @Test
    void testCloseConsoleScanner() {
        compService.closeConsoleScanner(); 
        assertDoesNotThrow(() -> compService.closeConsoleScanner());
    }

    @Test
    void testDeleteOneById() {
        doNothing().when(compRepository).deleteById(anyLong()); 
        compService.deleteOneById(1L); 
        verify(compRepository, times(1)).deleteById(1L); 
    }

    @Test
    void testDeleteOneByTrade() {
        doNothing().when(compRepository).deleteByTrade("Lenovo");

        compService.deleteOneByTrade("Lenovo");

        verify(compRepository, times(1)).deleteByTrade("Lenovo");
    }

    @Test
    void testFindOneByTrade() {
        when(compRepository.findByTrade("Lenovo")).thenReturn(Arrays.asList(computer));

        List<Computers> result = compService.findOneByTrade("Lenovo");

        assertFalse(result.isEmpty());
        assertEquals("Lenovo", result.get(0).getTrade());
        verify(compRepository, times(1)).findByTrade("Lenovo");
    }

    @Test
    void testGetAll() {
        Computers computer2 = new Computers();
        computer2.setTrade("HP");

        List<Computers> computers = Arrays.asList(computer, computer2);

        when(compRepository.findAll()).thenReturn(computers);

        List<Computers> result = compService.getAll();

        assertEquals(2, result.size());
        verify(compRepository, times(1)).findAll();
    }

    @Test
    void testShowMenu() {

    }
}