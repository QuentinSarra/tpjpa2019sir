package TP2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Participant {

	private String mail;
	private String prenom;
	private String nom;

	private List<Allergie> allergies = new ArrayList<Allergie>();
	private List<Preference> preferences = new ArrayList<Preference>();
	private List<Reunion> reunions = new ArrayList<Reunion>();
	private List<Sondage> sondages = new ArrayList<Sondage>();

	@Id
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@ManyToMany
	@JoinTable(name = "PARTICIPANT_ALLERGIE", joinColumns = @JoinColumn(name = "mail"), inverseJoinColumns = @JoinColumn(name = "name"))
	public List<Allergie> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<Allergie> allergies) {
		this.allergies = allergies;
	}
	
	public void addAllergie(Allergie a) {
		allergies.add(a);
	}

	@ManyToMany
	@JoinTable(name = "PARTICIPANT_PREFERENCE", joinColumns = @JoinColumn(name = "mail"), inverseJoinColumns = @JoinColumn(name = "name"))
	public List<Preference> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<Preference> preferences) {
		this.preferences = preferences;
	}

	@ManyToMany
	@JoinTable(name = "PARTICIPANT_REUNION", joinColumns = @JoinColumn(name = "mail"), inverseJoinColumns = @JoinColumn(name = "lien"))
	public List<Reunion> getReunions() {
		return reunions;
	}

	public void setReunions(List<Reunion> reunion) {
		this.reunions = reunion;
	}

	@ManyToMany
	@JoinTable(name = "PARTICIPANT_SONDAGE", joinColumns = @JoinColumn(name = "mail"), inverseJoinColumns = @JoinColumn(name = "lien"))
	public List<Sondage> getSondages() {
		return sondages;
	}

	public void setSondages(List<Sondage> sondages) {
		this.sondages = sondages;
	}

}
