package com.example.examen.mapper;

import com.example.examen.dao.entities.Action;
import com.example.examen.dto.ActionDto;

import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;
@Component
public class ActionMapper {
    ModelMapper mapper =new ModelMapper();
    public Action ActionDtotoAction(ActionDto action){
        return mapper.map(action, Action.class);
    }
    public ActionDto ActiontoActionDto(Action action){
        return mapper.map(action, ActionDto.class);
    }
}
