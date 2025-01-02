package com.example.examen;

import com.example.examen.dao.entities.Action;
import com.example.examen.dao.entities.Don;
import com.example.examen.dao.entities.Organisateur;
import com.example.examen.dao.repositories.ActionRepository;
import com.example.examen.dao.repositories.DonRepository;
import com.example.examen.dao.repositories.OrganisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@SpringBootApplication
public class ExamenApplication {
	private ActionRepository actionRepository;
	private DonRepository donRepository;
	private OrganisateurRepository organisateurRepository;
	public static void main(String[] args) {
		SpringApplication.run(ExamenApplication.class, args);
	}
	@Bean
	CommandLineRunner start() {
		return args -> {
			Organisateur organisateur=Organisateur.builder()
					.nom("John Doe")
					.email("john.doe@example.com")
					.build();

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date parsedDate = dateFormat.parse("2000-01-20");

			Action action = Action.builder()
				.titre("Action de collecte de fonds")
				.description("Une action pour collecter des fonds pour une œuvre caritative")
				.dateCreation(parsedDate)
				.montantCollecte(5000L)
				.etat(Action.Etat.OUVERTE)
				.organisateur(organisateur)
				.build();
			Don don=Don.builder()
					.titre("Don de bien")
					.montant(1000L)
					.typeDon(Don.TypeDon.BIEN)
					.action(action) // Peut être nul pour éviter la boucle si nécessaire
					.build();
			organisateurRepository.save(organisateur);
			actionRepository.save(action);
			donRepository.save(don);

		};
	}
}
