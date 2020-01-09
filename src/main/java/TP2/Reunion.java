package TP2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reunion {

	public Reunion() {
	}
	
	private String lien;
	private String intitule;
	private String resume;
	private Date date;
	private String clearCode;
	private String lienPad;
	private List<Participant>participants = new ArrayList<Participant>();
	private Sondage sondage;
	
	@Id
	public String getLien() {
		return lien;
	}
	public void setLien(String lien) {
		this.lien = lien;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@ManyToMany(mappedBy="reunions")
	public List<Participant> getParticipants() {
		return participants;
	}
	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}
	
	@OneToOne
	public Sondage getSondage() {
		return sondage;
	}
	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	}
	public String getClearCode() {
		return clearCode;
	}
	public void setClearCode(String clearCode) {
		this.clearCode = clearCode;
	}
	public String getLienPad() {
		return lienPad;
	}
	public void setLienPad(String lienPad) {
		this.lienPad = lienPad;
	}
	
}
