package tsi.gasmel.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "event")
public class Event {
	
	// Définition des attributs de la classe Event => tous seront des colonnes de la table 'event'

	@Id
    @GeneratedValue(generator="increment")
	@GenericGenerator(name="increment",strategy="increment")
	@Column(name="eventId")
	private int eventId;
	
	@Column(name="title",nullable=false)
	private String title;
	
	@Column(name="theme",nullable=false)
	private String theme;
	
	@Column(name="startDate",nullable=false)
	private String startDate;
	
	@Column(name="duration",nullable=false)
	private int duration;
	
	@Column(name="maxParticipants",nullable=false)
	private int maxParticipants;
	
	@Column(name="description",nullable=false)
	private String description;
	
	@Column(name="organizer",nullable=false)
	private String organizer;
	
	@Column(name="eventType",nullable=false)
	private String eventType;
	
	
	// Constructeur vide
	public Event() {
		super();
	}

	
	// Constructeur avec tous les attributs sauf l'id généré tout seul
	public Event(String title, String theme, String startDate, int duration, int maxParticipants,
			String description, String organizer, String eventType) {
		super();
		this.title = title;
		this.theme = theme;
		this.startDate = startDate;
		this.duration = duration;
		this.maxParticipants = maxParticipants;
		this.description = description;
		this.organizer = organizer;
		this.eventType = eventType;
	}
	
	
	// Getteurs et setteurs

	public int getId() {
		return eventId;
	}

	public void setId(int id) {
		this.eventId = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getMaxParticipants() {
		return maxParticipants;
	}

	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

}
