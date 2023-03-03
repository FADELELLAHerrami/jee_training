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
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			// TODO Auto-generated method stub
			req.getRequestDispatcher("/WEB-INF/modifierPersonne.jsp").forward(req, res);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String id = req.getParameter("id");
			int Iid = Integer.parseInt(id);
			DaoImpl oo = new DaoImpl();
			if(oo.existPersonne(Iid)) {
				req.getRequestDispatcher("/WEB-INF/confirmationDeModification.jsp").forward(req, res);
			}else {
				req.setAttribute("errorID", "Id "+Iid+" n'existe pas");
			}
		}
}











