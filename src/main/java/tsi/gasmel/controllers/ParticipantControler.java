package tsi.gasmel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import tsi.gasmel.models.Event;
import tsi.gasmel.models.Participant;
import tsi.gasmel.services.EventService;
import tsi.gasmel.services.ParticipantService;

@Controller
public class ParticipantControler {
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private ParticipantService participantService;
	
	
	//// Affichage du formulaire d'ajout d'un participant ////
	
	@GetMapping("/form-add-participant")
	public String showAllParticipants(Model model) {
		
		// Recupere tous les événements dans la BDD
		List<Event> events = eventService.findAll();
		
		// Si il en existe, on l'indique à la vue (via 'exists') et on lui fait passer les événements pour les afficher (via 'events')
		if (events.size()>0) {
			model.addAttribute("exists",true);
			model.addAttribute("events",events);
		}
		else
		// Si il en existe pas, on l'indique à la vue (via 'exists')
		{
			model.addAttribute("exists",false);
		}
		return "form-add-participant";
	}
	
	
	//// Ajout d'un participant ////
	
	@RequestMapping(value = "/add-participant",  method = RequestMethod.POST)
	public RedirectView addEvent(
			// On récupère tous les champs du formulaire (vue 'form-add-participant') necessaires a la création d'un objet Participant
			@RequestParam(name="firstName", required=true) String firstName,
			@RequestParam(name="lastName", required=true) String lastName,
			@RequestParam(name="email", required=true) String email,
			@RequestParam(name="birthDate", required=true) String birthDate,
			@RequestParam(name="organization", required=true) String organization,
			@RequestParam(name="observations", required=true) String observations,
			@RequestParam(name="eventId", required=true) int eventId,
			Model model)
	{
		// Recuperation de l'evenement auquel le partcipant va etre ajoute
		Event event = eventService.getEventById(eventId);
		
		// Creation de l'objet Participant
		Participant participant= new Participant(firstName,lastName,email,birthDate,organization,observations,event);
		
		// Sauvegarde du Participant
		participantService.save(participant);

		// Redirection vers la vue 'success' pour eviter une nouvelle soumission du formulaire
		// En indiquant quelle requete vient d'être effectuée
		RedirectView redirectView= new RedirectView("/success",true);
		redirectView.addStaticAttribute("query","participant-add");
	    return redirectView;
	}

}
