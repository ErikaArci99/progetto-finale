package org.lessons.java.progetto_finale.service;

import org.lessons.java.progetto_finale.model.Borsa;
import org.lessons.java.progetto_finale.repository.BorsaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorsaService {

    private final BorsaRepository borsaRepository;

    public BorsaService(BorsaRepository borsaRepository) {
        this.borsaRepository = borsaRepository;
    }

    public List<Borsa> findAll() {
        return borsaRepository.findAll();
    }

    public Optional<Borsa> findById(Long id) {
        return borsaRepository.findById(id);
    }

    public Borsa save(Borsa borsa) {
        return borsaRepository.save(borsa);
    }

    public void deleteById(Long id) {
        borsaRepository.deleteById(id);
    }
}
