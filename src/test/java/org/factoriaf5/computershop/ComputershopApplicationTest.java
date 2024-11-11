package org.factoriaf5.computershop;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.factoriaf5.computershop.computers.CompService;
import org.factoriaf5.computershop.computers.Computers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ComputershopApplicationTest {

    @Mock
    private CompService compService;

    @InjectMocks
    private ComputershopApplication computershopApplication;

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
    void testMethodDependsOnChoosenMenu_AddOne() {
        when(compService.showMenu()).thenReturn((short) 1);
        when(compService.addOne(any(Computers.class))).thenReturn(computer);

        computershopApplication.methodDependsOnChoosenMenu((short) 1);

        verify(compService, times(1)).addOne(any(Computers.class));
    }


    @Test
    void testMethodDependsOnChoosenMenu_GetAll() {
        when(compService.showMenu()).thenReturn((short) 2);
        when(compService.getAll()).thenReturn(Arrays.asList(computer));

        computershopApplication.methodDependsOnChoosenMenu((short) 2);

        verify(compService, times(1)).getAll();
    }

    @Test
    void testMethodDependsOnChoosenMenu_FindOneByTrade() {
        when(compService.showMenu()).thenReturn((short) 3);
        when(compService.findOneByTrade("Lenovo")).thenReturn(Arrays.asList(computer));

        computershopApplication.methodDependsOnChoosenMenu((short) 3);

        verify(compService, times(1)).findOneByTrade("Lenovo");
    }

    @Test
    void testMethodDependsOnChoosenMenu_DeleteOneByTrade() {
        when(compService.showMenu()).thenReturn((short) 4);
        doNothing().when(compService).deleteOneByTrade("Lenovo");

        computershopApplication.methodDependsOnChoosenMenu((short) 4);

        verify(compService, times(1)).deleteOneByTrade("Lenovo");
    }

    @Test
    void testMethodDependsOnChoosenMenu_Exit() {
        when(compService.showMenu()).thenReturn((short) 5);

        computershopApplication.methodDependsOnChoosenMenu((short) 5);

        assertFalse(computershopApplication.loopMenu);
    }
} 

