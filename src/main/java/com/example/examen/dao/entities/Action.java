package com.example.examen.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String titre;
    private String description;
    private Date dateCreation;
    private Long montantCollecte;
    @Enumerated(EnumType.STRING)
    private Etat etat;
    public enum Etat{
        PREPARATION,OUVERTE ,SUSPENDUE,TERMINEE
    }
    @ManyToOne
    private Organisateur organisateur;
    @OneToMany(mappedBy = "action")
    private List<Don> dons;

}
