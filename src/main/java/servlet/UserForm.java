package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import TP2.Participant;
import jpa.EntityManagerHelper;

@WebServlet(name = "userform", urlPatterns = { "/UserForm" })
public class UserForm extends HttpServlet {
	
	@PersistenceContext
	EntityManager manager = EntityManagerHelper.getEntityManager();
	EntityTransaction tx = manager.getTransaction();
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		
		tx.begin();
		out.println("<HTML>\n<BODY>\n" + "<H1>Recapitulatif des informations</H1>\n" + "<UL>\n" + " <LI>Nom: "
				+ request.getParameter("name") + "\n" + " <LI>Prenom: " + request.getParameter("firstname") + "\n"
				+ " <LI>Mail: " + request.getParameter("mail") + "\n" + "</UL>\n" + "</BODY></HTML>");
		
		
			
		try {
			Participant p1 = new Participant();
			p1.setMail(request.getParameter("mail"));
			p1.setPrenom(request.getParameter("firstname"));
			p1.setNom(request.getParameter("name"));
			manager.persist(p1);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		

		//EntityManagerHelper.closeEntityManagerFactory();
				//		factory.close();
		//manager.close();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<HTML>\n<BODY>\n" + "<H1>Recapitulatif des informations</H1>" );
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		try {
			List<Participant> resultList = manager.createQuery("Select a From Participant a", Participant.class).getResultList();
			out.println("<p> num of employes:" + resultList.size() + "</p>");
			out.println("\n");
			for (Participant next : resultList) {
				out.println("<ul><li> Mail: " + next.getMail() + "</li>");
				out.println("<li> Prénom: " + next.getPrenom() + "</li>");
				out.println("<li> Nom: " + next.getNom() + "</li> " + " </ul>\n " );
			
			}
			out.println("");

			out.println("</BODY></HTML>");
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		

		//manager.close();

		
	} 
	
	
	
	

}
