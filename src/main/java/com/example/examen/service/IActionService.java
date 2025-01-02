package com.example.examen.service;

import com.example.examen.dto.ActionDto;
import com.example.examen.dto.DonDto;

import java.util.List;

public interface IActionService {
    public ActionDto addAction(ActionDto action);
    public List<DonDto>  getDons(Long id);
    public  List <ActionDto> getAllActions();
}
