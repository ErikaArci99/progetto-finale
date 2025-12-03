package org.lessons.java.progetto_finale.api;

import org.lessons.java.progetto_finale.model.Borsa;
import org.lessons.java.progetto_finale.service.BorsaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/borse")
@CrossOrigin(origins = "http://localhost:5173") // consente chiamate da React
public class BorsaRestController {

    @Autowired
    private BorsaService borsaService;

    public BorsaRestController(BorsaService borsaService) {
        this.borsaService = borsaService;
    }

    @GetMapping
    public List<Borsa> getAll() {
        return borsaService.findAll();
    }

    @GetMapping("/{id}")
    public Borsa getById(@PathVariable Long id) {
        return borsaService.findById(id)
                .orElseThrow(() -> new RuntimeException("Borsa non trovata"));
    }
}
