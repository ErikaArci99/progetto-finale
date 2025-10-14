package org.lessons.java.progetto_finale.service;

import org.lessons.java.progetto_finale.model.Collezione;
import org.lessons.java.progetto_finale.repository.CollezioneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollezioneService {

    private final CollezioneRepository collezioneRepository;

    public CollezioneService(CollezioneRepository collezioneRepository) {
        this.collezioneRepository = collezioneRepository;
    }

    public List<Collezione> findAll() {
        return collezioneRepository.findAll();
    }

    public Optional<Collezione> findById(Long id) {
        return collezioneRepository.findById(id);
    }

    public Collezione save(Collezione collezione) {
        return collezioneRepository.save(collezione);
    }

    public void deleteById(Long id) {
        collezioneRepository.deleteById(id);
    }
}
