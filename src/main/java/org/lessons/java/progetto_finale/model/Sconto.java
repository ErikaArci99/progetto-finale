package org.lessons.java.progetto_finale.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    private Integer percentuale;

    @NotNull(message = "La data di inizio dello sconto è obbligatoria")
    @Column(nullable = false)
    private LocalDate dataInizio;

    @NotNull(message = "La data di fine dello sconto è obbligatoria")
    @Column(nullable = false)
    private LocalDate dataFine;

    @OneToMany(mappedBy = "sconto")
    @JsonManagedReference // indica a Jackson che questa lista è il lato gestito della relazione con Borsa
    private List<Borsa> borse = new ArrayList<>();

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

    public List<Borsa> getBorse() {
        return borse;
    }

    public void setBorse(List<Borsa> borse) {
        this.borse = borse;
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
