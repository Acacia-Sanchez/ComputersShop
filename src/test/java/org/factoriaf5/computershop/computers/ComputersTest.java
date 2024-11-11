package org.factoriaf5.computershop.computers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComputersTest {

    private Computers computer;

    @BeforeEach
    public void setUp() {
        computer = new Computers(1L, "Lenovo", 64, "i7 quad core 6300 Ghz", "Windows 12", 2000);
    }

    @Test
    public void testGettersAndSetters() {
        // Prueba de getters
        assertEquals(1L, computer.getId());
        assertEquals("Lenovo", computer.getTrade());
        assertEquals(64, computer.getRam());
        assertEquals("i7 quad core 6300 Ghz", computer.getMicro());
        assertEquals("Windows 12", computer.getOs());
        assertEquals(2000, computer.getPrice());

        // Prueba de setters
        computer.setId(2L);
        computer.setTrade("HP");
        computer.setRam(32);
        computer.setMicro("i5 dual core 3200 Ghz");
        computer.setOs("Linux");
        computer.setPrice(1500);

        assertEquals(2L, computer.getId());
        assertEquals("HP", computer.getTrade());
        assertEquals(32, computer.getRam());
        assertEquals("i5 dual core 3200 Ghz", computer.getMicro());
        assertEquals("Linux", computer.getOs());
        assertEquals(1500, computer.getPrice());
    }

    @Test
    public void testEmptyConstructor() {
        Computers emptyComputer = new Computers();
        
        assertNull(emptyComputer.getId());
        assertNull(emptyComputer.getTrade());
        assertEquals(0, emptyComputer.getRam());
        assertNull(emptyComputer.getMicro());
        assertNull(emptyComputer.getOs());
        assertEquals(0, emptyComputer.getPrice());
    }
}
