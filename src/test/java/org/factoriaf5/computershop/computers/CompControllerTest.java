package org.factoriaf5.computershop.computers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

public class CompControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CompService compService;

    @InjectMocks
    private CompController compController;

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

        mockMvc = MockMvcBuilders.standaloneSetup(compController).build();
    }

    @Test
    void testGetAll() throws Exception {
        List<Computers> computers = Arrays.asList(computer);

        when(compService.getAll()).thenReturn(computers);

        mockMvc.perform(get("/api/computers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].trade").value("Lenovo"))
                .andExpect(jsonPath("$[0].micro").value("i7 quad core 6300 Ghz"))
                .andExpect(jsonPath("$[0].ram").value(64))
                .andExpect(jsonPath("$[0].os").value("Windows 12"))
                .andExpect(jsonPath("$[0].price").value(2000));

        verify(compService, times(1)).getAll();
    }

    @Test
    void testAddOne() throws Exception {
        when(compService.addOne(any(Computers.class))).thenReturn(computer);

        mockMvc.perform(post("/api/computers")
                .contentType("application/json")
                .content(new ObjectMapper().writeValueAsString(computer)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.trade").value("Lenovo"))
                .andExpect(jsonPath("$.micro").value("i7 quad core 6300 Ghz"))
                .andExpect(jsonPath("$.ram").value(64))
                .andExpect(jsonPath("$.os").value("Windows 12"))
                .andExpect(jsonPath("$.price").value(2000));

        verify(compService, times(1)).addOne(any(Computers.class));
    }
}

