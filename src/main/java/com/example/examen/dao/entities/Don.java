package com.example.examen.dao.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Don {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titre;
    private Long montant;
    @Enumerated(EnumType.STRING)
    private TypeDon typeDon;
    public enum TypeDon{
        ARGENT,BIEN
    }
    @ManyToOne
    private Action action;
    @ManyToOne
    private Donateur donateur;
}
