package org.lessons.java.progetto_finale.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "collezione")
public class Collezione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Il nome della collezione è obbligatorio")
    @Column(nullable = false, length = 100)
    private String nome; // es. "Autunno 2025"

    @NotBlank(message = "La stagione della collezione è obbligatoria")
    @Column(nullable = false, length = 50)
    private String stagione; // Autunno/Inverno

    @NotBlank(message = "La descrizione della collezione è obbligatoria")
    @Column(nullable = false, length = 500)
    private String descrizione;

    // Relazione con Borsa: una collezione può avere molte borse
    @OneToMany(mappedBy = "collezione", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Borsa> borse = new ArrayList<>();

    // Costruttore vuoto
    public Collezione() {
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStagione() {
        return stagione;
    }

    public void setStagione(String stagione) {
        this.stagione = stagione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public List<Borsa> getBorse() {
        return borse;
    }

    public void setBorse(List<Borsa> borse) {
        this.borse = borse;
    }

    @Override
    public String toString() {
        return "Collezione{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", stagione='" + stagione + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", numeroBorse=" + borse.size() +
                '}';
    }
}
