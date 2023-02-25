package Controleur;

import java.io.IOException;
import java.io.PrintWriter;

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
		Personne perso =new Personne();
		perso.setNum(100);
		perso.setNom("ERRAMI");
		perso.setPrenom("Fadel Ellah");
		PrintWriter out = res.getWriter();
		out.print(perso);
	}
}
