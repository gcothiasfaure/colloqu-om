package tsi.gasmel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tsi.gasmel.repositories.EventRepository;
import tsi.gasmel.models.Event;


// On utilise les méthode du CrudRepository pour faire persister les données
@Service
public class EventService {
	
	@Autowired
    private EventRepository repository;

	// Recupere tous les événements de la BDD
    public List<Event> findAll() {
    	return (List<Event>) repository.findAll();
    }
    
    // Sauvegarde un nouvel événement dans la BDD
    public void save(Event event) {
        repository.save(event);
    }
    
    // Supprime un événement dans la BDD
    public void delete(int id) {
        repository.deleteById(id);
    }
    
    // Recupère un événement dans la BDD grace à son id
    public Event getEventById(int id) {
        return repository.findById(id).orElse(null);
    }
    
    // Modifie un événement dans la BDD 
    // On recupere l'id de l'Event a modifier et ses nouveaux attributs
    public Event updateEvent(int id,String title,String theme,String startDate,int duration,int maxParticipants,String description,String organizer,String eventType) {
    	
    	// On recupere l'événement existant
    	Event existingEvent = repository.findById(id).orElse(null);
    	
    	// On modifie l'événement grace aux nouveaux attributs
    	existingEvent.setTitle(title);
    	existingEvent.setTheme(theme);
    	existingEvent.setStartDate(startDate);
    	existingEvent.setDuration(duration);
    	existingEvent.setMaxParticipants(maxParticipants);
    	existingEvent.setDescription(description);
    	existingEvent.setOrganizer(organizer);
    	existingEvent.setEventType(eventType);
    	
    	// On sauvegarde l'événement modifié
        return repository.save(existingEvent);
    }

}
