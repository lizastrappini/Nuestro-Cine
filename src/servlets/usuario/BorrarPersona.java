package servlets.usuario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Persona;
import logic.Login;

/**
 * Servlet implementation class BorrarPersona
 */
@WebServlet("/BorrarPersona")
public class BorrarPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarPersona() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Persona user = (Persona)request.getSession().getAttribute("usuario");
		Login lp = new Login();
		String password = lp.obtenerPass(user);
		if(request.getParameter("pass").toString().equals(password)) {
			lp.borrar(user);
			
			//Redirecciono a index.jsp
	        response.sendRedirect("index.jsp");
	        
		} else {
			String cambio="passNoCoinciden";
			request.setAttribute("cambioPass",cambio );
			request.getRequestDispatcher("MiCuenta.jsp").forward(request, response);
		}
	}

}
