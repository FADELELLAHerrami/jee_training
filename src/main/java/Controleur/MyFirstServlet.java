package Controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modele.Personne;


@WebServlet(name= "ls",urlPatterns = "*.php")


public class MyFirstServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<String> sport = new ArrayList<String>();
		sport.add( "football" );
		sport.add( "tennis" );
		sport.add( "rugby");
		sport.add( "basketball" );
		req.setAttribute( "sport" , sport );

		req.getRequestDispatcher("/WEB-INF/Vue.jsp").forward(req, res);
		// getRequestDispatcher("/WEB-INF/vue.jsp") : permet d’indiquer l’emplacement de la vue et de la recupérer
		// forward(request, response) : pour envoyer la requete et la r ˆ eponse (on les utilisera plus tard). ´
		
		
	}
}
