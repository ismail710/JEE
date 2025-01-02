package com.example.examen.dao.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity

public class Donateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private  String email;
    @Enumerated(EnumType.STRING)
    private Evaluation evaluation;
    public enum Evaluation{
        DEBUTANT,DONATEUR_ACTIF,DONATEUR_FIDELE

    }
    @OneToMany(mappedBy = "donateur")
    private List<Don> dons;
}
