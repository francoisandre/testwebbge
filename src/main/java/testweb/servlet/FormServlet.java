package testweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");

		PrintWriter writer = resp.getWriter();
		writer.println("Nom: " + req.getParameter("nom"));
		writer.println("Prenom: " + req.getParameter("prenom"));
		writer.println("Sexe: " + req.getParameter("sexe"));
		writer.println("Commentaire: " + req.getParameter("commentaire"));
	}

}
