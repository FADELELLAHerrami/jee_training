package Controleur;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IDao.DaoImpl;
import Modele.Personne;


@WebServlet(name= "MyFirstServlet",urlPatterns = "/ajoutPersonne")

public class MyFirstServlet extends HttpServlet{
	
	// Vérification d'une chaîne de charactère

	public boolean verifCahine(String s) {
		if(s == null || s.length()< 2) {
			return false;
		}
		char c = s.charAt(0);
		if(!(c<='Z') && !(c>='A')) {
			return false;
		}
		for(int i=0;i<s.length();i++) {
			char x = s.charAt(i);
			if(!Character.isLetter(x)) return false;
		}
		return true;
	}
	
	//
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/WEB-INF/ajoutPersonne.jsp").forward(req, res);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		boolean nomVerif = verifCahine(nom);
		boolean prenomVerif = verifCahine(prenom);
		if(!nomVerif) req.setAttribute("nomIncorect", "format incorect");
		if(!prenomVerif) req.setAttribute("prenomIncorect", "format incorect");
		if(!nomVerif || !prenomVerif) {
			req.setAttribute("nomSaisi", nom);
			req.setAttribute("prenomSaisi", prenom);
			req.getRequestDispatcher("/WEB-INF/ajoutPersonne.jsp").forward(req, res);
		}
		else {			
			Personne perso = new Personne(nom,prenom);
			DaoImpl daoimpl = new DaoImpl();
			Personne insertedPersonne = daoimpl.save(perso);
			
			req.setAttribute("personne", insertedPersonne);
			req.getRequestDispatcher("/WEB-INF/confirmation.jsp").forward(req, res);
			
		}


		//req.getRequestDispatcher("/WEB-INF/confirmation.jsp").forward(req, res);
		// getRequestDispatcher("/WEB-INF/vue.jsp") : permet d’indiquer l’emplacement de la vue et de la recupérer
		// forward(request, response) : pour envoyer la requete et la r ˆ eponse (on les utilisera plus tard). ´
		
		
	}
	
}
