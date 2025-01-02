package com.example.examen.dto;

import com.example.examen.dao.entities.Action;
import com.example.examen.dao.entities.Don;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DonDto {
    private Long id;
    private String titre;
    private Long montant;

    private String typeDon;
    private Action action;

}
