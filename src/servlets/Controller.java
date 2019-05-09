package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		this.processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//System.out.println(request.getParameter("opcion"));
		
		//creamos el dispatcher
		ServletContext ctx = request.getServletContext();
		RequestDispatcher rd;
		String url;
		String opcion = request.getParameter("opcion");
		System.out.println(opcion);
		switch (opcion) {
		case "invitado": url = "/createOrSelect.jsp"; break;
		case "login": url = "/login.jsp"; break;
		case "signup": url = "/signup.jsp"; break;
		case "dosignup": url = "/doSignUp.jsp"; break;
		case "logout": url= "/doLogout.jsp"; break;
		default: url="/";break; 
		}
		
		System.out.println(url);
		rd = ctx.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}

}
