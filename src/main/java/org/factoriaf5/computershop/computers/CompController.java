package org.factoriaf5.computershop.computers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/computers")
public class CompController {
    
    private final CompService compService;

    public CompController(CompService compService) {
        this.compService = compService;
    }

    @GetMapping
    public List<Computers> getAll() {
        return compService.getAll();
    }

    @PostMapping
    public Computers addOne(@RequestBody Computers computers) {
        return compService.addOne(computers);
    }
    
}