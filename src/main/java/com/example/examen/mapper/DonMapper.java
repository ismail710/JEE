package com.example.examen.mapper;

import com.example.examen.dao.entities.Don;
import com.example.examen.dto.DonDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DonMapper {
    ModelMapper mapper =new ModelMapper();
    public Don DonDtotoDon(DonDto don){
        return mapper.map(don, Don.class);
    }
    public DonDto DontoDonDto(Don don){
        return mapper.map(don, DonDto.class);
    }
}
