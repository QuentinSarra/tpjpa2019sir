package TP2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Sondage {

	private String lien;
	private Reunion reunion;
	private List<Participant>participants = new ArrayList<Participant>();
	
	@Id
	public String getLien() {
		return lien;
	}
	public void setLien(String lien) {
		this.lien = lien;
	}
	
	@OneToOne
	public Reunion getReunion() {
		return reunion;
	}
	
	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}
	
	@ManyToMany(mappedBy="sondages")
	public List<Participant> getParticipants() {
		return participants;
	}
	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}
	
}
