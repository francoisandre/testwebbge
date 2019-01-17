package testweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OpenSession extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		session.setAttribute("login", "Francois");
		resp.setContentType("text/html");
		resp.getWriter().println("Session: " + session.getId() + "<br>");
		String url = getServletContext().getContextPath() + "/displaySession.html";
		String urlEncodee = resp.encodeRedirectURL(url);
		resp.getWriter().println("<a href='" + urlEncodee + "'>Voir le resultat</a>");
		// resp.sendRedirect(resp.encodeRedirectURL("page.jsp"));
	}

}
