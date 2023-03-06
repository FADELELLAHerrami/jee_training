package Controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IDao.DaoImpl;

@WebServlet(name = "SupprPersonne",urlPatterns = "SupprPersonne")

public class SupprPersonne  extends HttpServlet{
	public boolean idExist(String id) {
		if(id == "") {
			return false;
		}
		return true;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		DaoImpl oo = new DaoImpl();
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
		
		else {
				oo.removePersonne(Iid);
				req.getRequestDispatcher("/WEB-INF/confirmationDeModification.jsp").forward(req, res);	
		}	
	}
}
