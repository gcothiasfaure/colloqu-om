package tsi.gasmel.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tsi.gasmel.models.Participant;


//Notre repository étend le CrudRepository, pas besoin de redéfinir les méthode pour faire persister les données

@Repository
public interface ParticipantRepository extends CrudRepository<Participant, Integer> {

}
