package com.example.examen.web;

import com.example.examen.dao.entities.Action;
import com.example.examen.dao.entities.Organisateur;
import com.example.examen.dao.repositories.DonRepository;
import com.example.examen.dao.repositories.OrganisateurRepository;
import com.example.examen.dto.ActionDto;
import com.example.examen.dto.DonDto;
import com.example.examen.service.IActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class ActionController {
    @Autowired
    private IActionService actionService;
    @Autowired
    private OrganisateurRepository organisateurRepository;
    @Autowired
    private DonRepository donRepository;
    @GetMapping("")
    public String listActions(Model model) {
        List<ActionDto> actions = actionService.getAllActions();
        model.addAttribute("actions", actions);
        return "index";
    }
    @GetMapping("/listDons")
    public String listDons(Model model, @RequestParam (name="id") Long id){
        List<DonDto> dons= actionService.getDons(id);
        double montantTotal = actionService.getMontantTotal(id);
        double montantACollecter = actionService.getMontantACollecter(id); // Récupérez ce montant depuis votre service ou dépôt

        model.addAttribute("dons", dons);
        model.addAttribute("montantTotal", montantTotal);
        model.addAttribute("montantACollecter", montantACollecter);
        return "/listDons";

    }
    @GetMapping("/addAction")
    public String addAction(Model model  ){
        List<Organisateur> organisateurs=organisateurRepository.findAll();

        model.addAttribute("organisateurs",organisateurs);
        return "addAction";
    }
    @PostMapping("/addAction")
    public String addAction(
            Model model,
            @RequestParam(name = "titre") String titre,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "montant") Long montant,
            @RequestParam(name = "etat") String etat,
            @RequestParam(name = "orga_id") Long orgaId) {

        // Debugging: Afficher les paramètres reçus
        System.out.println("Titre: " + titre);
        System.out.println("Description: " + description);
        System.out.println("Montant: " + montant);
        System.out.println("État: " + etat);
        System.out.println("Organisateur ID: " + orgaId);


        if (montant < 0) {
            model.addAttribute("error", "Le montant doit être positif");
            return "index";
        }

        Optional<Organisateur> organisateurOpt = organisateurRepository.findById(orgaId);
        if (organisateurOpt.isEmpty()) {
            model.addAttribute("error", "Organisateur introuvable");
            return "index";
        }

        Date dateActuelle = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateFormatee = formatter.format(dateActuelle);
        System.out.println("Date actuelle formatée: " + dateFormatee);

        Organisateur organisateur = organisateurOpt.get();
        ActionDto action = ActionDto.builder()
                .titre(titre)
                .description(description)
                .dateCreation(dateActuelle) // Pas besoin de formatage
                .montantCollecte(montant)
                .etat(etat)
                .organisateur(organisateur)
                .build();


        System.out.println("Action à ajouter: " + action);
        actionService.addAction(action);
        return "index";
    }


}
