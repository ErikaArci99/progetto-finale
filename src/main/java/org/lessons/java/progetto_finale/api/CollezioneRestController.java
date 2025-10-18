package org.lessons.java.progetto_finale.api;

import org.lessons.java.progetto_finale.model.Collezione;
import org.lessons.java.progetto_finale.service.CollezioneService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/collezioni")
@CrossOrigin(origins = "http://localhost:5173")
public class CollezioneRestController {

    private final CollezioneService collezioneService;

    public CollezioneRestController(CollezioneService collezioneService) {
        this.collezioneService = collezioneService;
    }

    @GetMapping
    public List<Collezione> getAll() {
        return collezioneService.findAll();
    }

    @GetMapping("/{id}")
    public Collezione getById(@PathVariable Long id) {
        return collezioneService.findById(id)
                .orElseThrow(() -> new RuntimeException("Collezione non trovata"));
    }
}
