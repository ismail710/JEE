package com.example.examen.service;

import com.example.examen.dao.entities.Action;
import com.example.examen.dao.entities.Don;
import com.example.examen.dao.repositories.ActionRepository;
import com.example.examen.dto.ActionDto;
import com.example.examen.dto.DonDto;
import com.example.examen.mapper.ActionMapper;
import com.example.examen.mapper.DonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IactionServiceImp implements IActionService{
    @Autowired
    private ActionRepository actionRepository;
    @Autowired
    private ActionMapper actionMapper;
    @Autowired
    private DonMapper donMapper;
    @Override
    public ActionDto addAction(ActionDto action) {
        return actionMapper.ActiontoActionDto(actionRepository.save(actionMapper.ActionDtotoAction(action)));
    }

    @Override
    public List<DonDto> getDons(Long id) {
        List<Don> dons=actionRepository.findById(id).get().getDons();
        return dons.stream().map(donMapper::DontoDonDto).collect(Collectors.toList());
    }

    @Override
    public List<ActionDto> getAllActions() {
        List<Action> actions= actionRepository.findAll();
        return actions.stream().map(actionMapper::ActiontoActionDto).collect(Collectors.toList());
    }
}
