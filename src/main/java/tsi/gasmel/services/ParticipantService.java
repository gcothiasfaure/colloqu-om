package tsi.gasmel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tsi.gasmel.models.Participant;
import tsi.gasmel.repositories.ParticipantRepository;


//On utilise les méthode du CrudRepository pour faire persister les données

@Service
public class ParticipantService {
	
	@Autowired
    private ParticipantRepository repository;
	
	// Sauvegarde un nouvel participant dans la BDD
	public void save(Participant participant) {
        repository.save(participant);
    }

}
