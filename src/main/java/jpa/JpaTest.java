package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import TP2.Participant;

public class JpaTest {
	
	public void saveSondage() {
		
	}
	
	public void saveChoix() {
		
	}
	
	public void prefAlims() {
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();


		try {
			
			Participant p1 = new Participant();
			p1.setMail("p1@mail.com");
			p1.setPrenom("p1");
			p1.setNom("Np1");
			manager.persist(p1);
			
			Participant p2 = new Participant();
			p2.setMail("p2@mail.com");
			p2.setPrenom("p2");
			p2.setNom("Np2");
			manager.persist(p2);
			
			Participant p3 = new Participant();
			p3.setMail("p3@mail.com");
			p3.setPrenom("p3");
			p3.setNom("Np3");
			manager.persist(p3);
			
			Participant p4 = new Participant();
			p4.setMail("p4@mail.com");
			p4.setPrenom("p4");
			p4.setNom("Np4");
			manager.persist(p4);
			
			Participant p5 = new Participant();
			p5.setMail("p5@mail.com");
			p5.setPrenom("p5");
			p5.setNom("Np5");
			manager.persist(p5);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();


		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}


}
