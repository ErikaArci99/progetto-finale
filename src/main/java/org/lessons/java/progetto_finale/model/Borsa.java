package org.lessons.java.progetto_finale.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "borsa")
public class Borsa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Il nome della borsa è obbligatorio")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "Il brand della borsa è obbligatorio")
    @Column(nullable = false, length = 100)
    private String brand;

    @NotBlank(message = "La descrizione della borsa è obbligatoria")
    @Column(nullable = false, length = 500)
    private String descrizione;

    @NotNull(message = "Il prezzo della borsa è obbligatorio")
    @Column(nullable = false)
    private Double prezzo;

    @NotBlank(message = "Il colore della borsa è obbligatorio")
    @Column(nullable = false, length = 50)
    private String colore;

    @NotBlank(message = "Le dimensioni della borsa sono obbligatorie")
    @Column(nullable = false, length = 50)
    private String dimensioni;

    @NotBlank(message = "L'immagine della borsa è obbligatoria")
    @Column(nullable = false, length = 255)
    private String immagine;

    // Relazione con Collezione
    @ManyToOne
    @JoinColumn(name = "collezione_id")
    private Collezione collezione;

    // Relazione con Sconto
    @ManyToOne
    @JoinColumn(name = "sconto_id")
    private Sconto sconto;

    // Costruttore vuoto
    public Borsa() {
    }

    // Metodo per calcolare il prezzo finale con lo sconto applicato

    @Transient
    public Double getPrezzoScontato() {
        if (sconto != null) {
            return prezzo * (1 - sconto.getPercentuale() / 100.0);
        }
        return prezzo;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public String getDimensioni() {
        return dimensioni;
    }

    public void setDimensioni(String dimensioni) {
        this.dimensioni = dimensioni;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public Collezione getCollezione() {
        return collezione;
    }

    public void setCollezione(Collezione collezione) {
        this.collezione = collezione;
    }

    public Sconto getSconto() {
        return sconto;
    }

    public void setSconto(Sconto sconto) {
        this.sconto = sconto;
    }

    @Override
    public String toString() {
        return "Borsa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", prezzo=" + prezzo +
                ", colore='" + colore + '\'' +
                ", dimensioni='" + dimensioni + '\'' +
                ", immagine='" + immagine + '\'' +
                ", collezione=" + (collezione != null ? collezione.getNome() : "null") +
                ", sconto=" + (sconto != null ? sconto.getPercentuale() + "%" : "null") +
                '}';
    }
}
