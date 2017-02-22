package org.isen;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.dmetzler.isen.puissance4.web.Inject;
import org.dmetzler.isen.puissance4.web.Puissance4Bean;

/**
 * Servlet implementation class GameJDDServlet
 */
@WebServlet("/game")
public class GameJDDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameJDDServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName").trim();
		if(userName == null || "".equals(userName)){
			userName = "Guest";
		}
		
		String greetings = "Hello " + userName;
		
		response.setContentType("text/plain");
		response.getWriter().write(greetings);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	 private String getTokenFromRequest(HttpServletRequest request) {
	        if (request == null) {
	            return "";
	        }

	        String token = request.getRequestURI().substring(
	                request.getContextPath().length()
	                        + request.getServletPath().length() + 1);

	        return token;

	    }
	 private void redirectToGameRoot(HttpServletResponse response,
	            HttpServletRequest request) throws IOException {
	        response.sendRedirect(request.getContextPath()
	                + request.getServletPath() + "/" + game.getToken());
	    }

}
