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
import tsi.gasmel.services.EventService;

@Controller
public class EventControler {
	
	@Autowired
	private EventService service;
		
	
	////Affichage simple de la vue index (vue d'accueil) ///
	
	@GetMapping("/index")
	public String showIndex(Model model) {
		return "index";
	}
	
	
	////Affichage simple de la vue success (apres chaque modifications) ///
	
	@GetMapping("/success")
	public String showSuccess(Model model) {
		return "success";
	}
	
	
	//// Affichage de tous les événements ////
	
	@GetMapping("/events")
	public String showAllEvents(Model model) {
		
		// Recupere tous les événements dans la BDD
		List<Event> events = service.findAll();
		
		// Si il en existe, on l'indique à la vue (via 'exists') et on lui fait passer les événements pour les afficher (via 'events')
		if (events.size()>0) 
		{
			model.addAttribute("exists",true);
			model.addAttribute("events",events);
		}
		
		// Si il en existe pas, on l'indique à la vue (via 'exists')
		else 
		{
			model.addAttribute("exists",false);
		}

		return "events";
	}
	
	
	//// Affichage du formulaire d'ajout d'un evenement ////
	
	@GetMapping("/form-add-event")
	public String showAddEvent(Model model) {
		return "form-add-event";
	}
	
	
	//// Ajout d'un événement ////
	
	@RequestMapping(value = "/add-event",  method = RequestMethod.POST)
	public RedirectView addEvent(
			// On récupère tous les champs du formulaire (vue 'form-add-event') necessaires a la création d'un objet Event
			@RequestParam(name="title", required=true) String title,
			@RequestParam(name="theme", required=true) String theme,
			@RequestParam(name="startDate", required=true) String startDate,
			@RequestParam(name="duration", required=true) int duration,
			@RequestParam(name="maxParticipants", required=true) int maxParticipants,
			@RequestParam(name="description", required=true) String description,
			@RequestParam(name="organizer", required=true) String organizer,
			@RequestParam(name="eventType", required=true) String eventType,
			Model model)
	{
		// Création de l'événement correspondant aux champs rentrés par l'utilisateur
		Event event = new Event(title,theme,startDate,duration,maxParticipants,description,organizer,eventType);
		
		// Sauvegarde de l'événement
		service.save(event);

		// Redirection vers la vue 'success' pour eviter une nouvelle soumission du formulaire
		// En indiquant quelle requete vient d'être effectuée
		RedirectView redirectView= new RedirectView("/success",true);
		redirectView.addStaticAttribute("query","event-add");
	    return redirectView;
	}
	
	
	//// Affichage du formulaire de suppression d'un événement ////
	
	@GetMapping("/form-del-event")
	public String showFormDelEvent(Model model) {
		
		// Recupere tous les événements dans la BDD
		List<Event> events = service.findAll();
		
		// Passe les evenements a la vue pour choisir quel evenement supprimer
		model.addAttribute("events",events);
		return "form-del-event";
	}
	
	
	//// Suppression d'un événement ////
	
	@RequestMapping(value = "/del-event",  method = RequestMethod.POST)
	public RedirectView delEvent(
			// Recuperation de l'id de l'evenement a supprimer
			@RequestParam(name="eventId", required=true) int eventId,
			Model model)
	{
		// Supression de l'evenement
		service.delete(eventId);

		// Redirection vers la vue 'success' pour eviter une nouvelle soumission du formulaire
		// En indiquant quelle requete vient d'être effectuée
		RedirectView redirectView= new RedirectView("/success",true);
		redirectView.addStaticAttribute("query","event-del");
	    return redirectView;
	}
	
	
	//// Affichage du formulaire de choix d'événement à modifier ////
	
	@GetMapping("/choose-update-event")
	public String showChooseUpdateEvent(Model model) {
		
		// Recupere tous les événements dans la BDD
		List<Event> events = service.findAll();
		
		// Passe les evenements a la vue pour choisir quel evenement modifier
		model.addAttribute("events",events);
		
		return "choose-update-event";
	}
	
	
	//// Affichage du formulaire de modification d'événement ////	
	
	@RequestMapping(value = "/form-update-event",  method = RequestMethod.POST)
	public String showFormUpdateEvent(
			// Recuperation de l'id de l'evenement a modifier
			@RequestParam(name="eventId", required=true) int eventId,
			Model model) {
		
		// Recupere l'evenement a modifier
		Event event = service.getEventById(eventId);
		
		// Transmet a la vue l'evenement a modifier (pour une plus imple modification les anciens champs sont deja pre remplis)
		model.addAttribute("event",event);
		return "form-update-event";
	}
	
	
	//// Modification d'événement ////	
	
	@RequestMapping(value = "/update-event",  method = RequestMethod.POST)
	public RedirectView updateEvent(
			// On récupère tous les champs du formulaire (vue 'form-update-event') necessaires a la modification d'un objet Event
			@RequestParam(name="id", required=true) int id,
			@RequestParam(name="title", required=true) String title,
			@RequestParam(name="theme", required=true) String theme,
			@RequestParam(name="startDate", required=true) String startDate,
			@RequestParam(name="duration", required=true) int duration,
			@RequestParam(name="maxParticipants", required=true) int maxParticipants,
			@RequestParam(name="description", required=true) String description,
			@RequestParam(name="organizer", required=true) String organizer,
			@RequestParam(name="eventType", required=true) String eventType,
			Model model)
	{
		// Modification de l'obet Event
		service.updateEvent(id,title,theme,startDate,duration,maxParticipants,description,organizer,eventType);

		// Redirection vers la vue 'success' pour eviter une nouvelle soumission du formulaire
		// En indiquant quelle requete vient d'être effectuée
		RedirectView redirectView= new RedirectView("/success",true);
		redirectView.addStaticAttribute("query","event-update");
	    return redirectView;
	}

}
