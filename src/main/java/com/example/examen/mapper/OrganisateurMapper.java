package com.example.examen.mapper;

import com.example.examen.dao.entities.Action;
import com.example.examen.dao.entities.Organisateur;
import com.example.examen.dto.ActionDto;
import com.example.examen.dto.OrganisateurDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrganisateurMapper {
    ModelMapper mapper =new ModelMapper();
    public Organisateur organisatuerDtotoorganisateur(OrganisateurDto organisateur){
        return mapper.map(organisateur, Organisateur.class);
    }
    public OrganisateurDto organisateurtoorganisateurDto(Organisateur organisateur){
        return mapper.map(organisateur, OrganisateurDto.class);
    }
}
