package tsi.gasmel.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "participant")
public class Participant {
	
	// Définition des attributs de la classe Participant => tous seront des colonnes de la table 'participant'

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment",strategy="increment")
	@Column(name="partcipantId")
	private int partcipantId;
	
	@Column(name="firstName",nullable=false)
	private String firstName;
	
	@Column(name="lastName",nullable=false)
	private String lastName;
	
	@Column(name="email",nullable=false)
	private String email;
	
	@Column(name="birthDate",nullable=false)
	private String birthDate;
	
	@Column(name="organization",nullable=false)
	private String organization;
	
	@Column(name="observations",nullable=false)
	private String observations;
	
	// Cet attribut event (objet Event) est joint a la table 'partcipant' avec la colonne 'eventId' et designe l'eventId de l'Event auqel le participant participe
	// Lorsque l'evenement associé est supprimé, cela supprime egalement le participant
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne
    @JoinColumn(name="eventId")
	private Event event;

	
	// Constructeur vide
	public Participant() {
		super();
	}

	
	// Constructeur avec tous les attributs sauf l'id généré tout seul
	public Participant(String firstName, String lastName, String email, String birthDate, String organization,
			String observations,Event event) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.birthDate = birthDate;
		this.organization = organization;
		this.observations = observations;
		this.event = event;
	}
	
	
	// Getteurs et setteurs
	
	public int getId() {
		return partcipantId;
	}

	public void setId(int id) {
		this.partcipantId = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}
	
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}
