package org.lessons.java.progetto_finale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.lessons.java.progetto_finale.model.Collezione;

@Repository
public interface CollezioneRepository extends JpaRepository<Collezione, Long> {
}
