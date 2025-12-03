package org.lessons.java.progetto_finale.api;

import org.lessons.java.progetto_finale.model.Sconto;
import org.lessons.java.progetto_finale.service.ScontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sconti")
@CrossOrigin(origins = "http://localhost:5173")
public class ScontoRestController {

    @Autowired
    private ScontoService scontoService;

    public ScontoRestController(ScontoService scontoService) {
        this.scontoService = scontoService;
    }

    @GetMapping
    public List<Sconto> getAll() {
        return scontoService.findAll();
    }

    @GetMapping("/{id}")
    public Sconto getById(@PathVariable Long id) {
        return scontoService.findById(id)
                .orElseThrow(() -> new RuntimeException("Sconto non trovato"));
    }
}
