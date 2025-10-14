package org.lessons.java.progetto_finale.service;

import org.lessons.java.progetto_finale.model.Sconto;
import org.lessons.java.progetto_finale.repository.ScontoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScontoService {

    private final ScontoRepository scontoRepository;

    public ScontoService(ScontoRepository scontoRepository) {
        this.scontoRepository = scontoRepository;
    }

    public List<Sconto> findAll() {
        return scontoRepository.findAll();
    }

    public Optional<Sconto> findById(Long id) {
        return scontoRepository.findById(id);
    }

    public Sconto save(Sconto sconto) {
        return scontoRepository.save(sconto);
    }

    public void deleteById(Long id) {
        scontoRepository.deleteById(id);
    }
}
