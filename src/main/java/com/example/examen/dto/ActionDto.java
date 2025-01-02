package com.example.examen.dto;

import com.example.examen.dao.entities.Action;
import com.example.examen.dao.entities.Organisateur;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ActionDto {
    private  Long id;
    private String titre;
    private String description;
    private Date dateCreation;
    private Long montantCollecte;

    private String etat;

    private Organisateur organisateur;
}
