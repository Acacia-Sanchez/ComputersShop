package org.factoriaf5.computershop.computers;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CompRepositoryTest {

    @Mock
    private CompRepository compRepository;

    @InjectMocks
    private CompService compService;

    private Computers computer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        
        // Inicializar el objeto Computers
        computer = new Computers();
        computer.setTrade("Lenovo");
        computer.setMicro("i7 quad core 6300 Ghz");
        computer.setRam(64);
        computer.setOs("Windows 12");
        computer.setPrice(2000);
    }

    @Test
    void testDeleteByTrade() {
        doNothing().when(compRepository).deleteByTrade("Lenovo");

        compService.deleteOneByTrade("Lenovo");

        verify(compRepository, times(1)).deleteByTrade("Lenovo");
    }

    @Test
    void testFindByTrade() {
        when(compRepository.findByTrade("Lenovo")).thenReturn(Arrays.asList(computer));

        List<Computers> result = compService.findOneByTrade("Lenovo");

        assertFalse(result.isEmpty());
        assertEquals("Lenovo", result.get(0).getTrade());
        verify(compRepository, times(1)).findByTrade("Lenovo");
    }
}