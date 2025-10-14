package org.lessons.java.progetto_finale.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import java.time.LocalDate;

@Entity
@Table(name = "sconto")
public class Sconto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La percentuale di sconto è obbligatoria")
    @Min(value = 0, message = "Lo sconto non può essere negativo")
    @Max(value = 100, message = "Lo sconto non può superare il 100%")
    @Column(nullable = false)
    private Integer percentuale; // percentuale di sconto da 0 a 100

    @NotNull(message = "La data di inizio dello sconto è obbligatoria")
    @Column(nullable = false)
    private LocalDate dataInizio;

    @NotNull(message = "La data di fine dello sconto è obbligatoria")
    @Column(nullable = false)
    private LocalDate dataFine;

    // Costruttore vuoto
    public Sconto() {
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPercentuale() {
        return percentuale;
    }

    public void setPercentuale(Integer percentuale) {
        this.percentuale = percentuale;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    @Override
    public String toString() {
        return "Sconto{" +
                "id=" + id +
                ", percentuale=" + percentuale +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                '}';
    }
}
