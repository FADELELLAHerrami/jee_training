package Controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IDao.DaoImpl;


@WebServlet(name= "modifierPersonne",urlPatterns = "/modifPersonne")

public class ModifierPersonne extends HttpServlet {
	
	public boolean verifChaine(String s) {
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
	
	public boolean idExist(String id) {
		if(id == "") {
			return false;
		}
		return true;
	}
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			// TODO Auto-generated method stub
			req.getRequestDispatcher("/WEB-INF/modifierPersonne.jsp").forward(req, res);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String id = req.getParameter("id");
			
			String nom = req.getParameter("nom");
			String prenom = req.getParameter("prenom");
			DaoImpl oo = new DaoImpl();
			boolean nomVerif = verifChaine(nom);
			boolean prenomVerif = verifChaine(prenom);
			
			
			if(!nomVerif) req.setAttribute("nomIncorect", "format incorect");
			if(!prenomVerif) req.setAttribute("prenomIncorect", "format incorect");
			int Iid = -1;
			if(idExist(id)) {				
				Iid = Integer.parseInt(id);
			}
			else if(Iid == -1) {
				req.setAttribute("MissingId", "L'id n'exite pas");
				req.getRequestDispatcher("/WEB-INF/modifierPersonne.jsp").forward(req, res);
			}
			
			if(!oo.existPersonne(Iid)){
				req.setAttribute("errorID", "L'id n'exite "+Iid+" pas dans la base de donnée");	
				req.getRequestDispatcher("/WEB-INF/modifierPersonne.jsp").forward(req, res);

			}	
			
			else if(!nomVerif && !prenomVerif ) {				
					req.setAttribute("nomSaisi", nom);
					req.setAttribute("prenomSaisi", prenom);
					req.getRequestDispatcher("/WEB-INF/modifierPersonne.jsp").forward(req, res);
					
				}
				else  {
					oo.update(Integer.parseInt(id), prenom, nom);
					req.getRequestDispatcher("/WEB-INF/confirmationDeModification.jsp").forward(req, res);
					
				
			}
		}
	}












