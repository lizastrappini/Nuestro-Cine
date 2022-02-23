package servlets.usuario;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Persona;
import logic.Login;


/**
 * Servlet implementation class IniciarSesion
 */
@WebServlet({ "/IniciarSesion", "/iniciarSesion", "/iniciarsesion", "/Iniciarsesion" })
public class IniciarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IniciarSesion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean empleado=false;
		
		if( request.getSession().getAttribute("usuario")==null) { 
		HttpSession sesion = request.getSession();
		Persona per = new Persona();
		Login ctrl = new Login();
		
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		
		//validar email y password
		
		per.setEmail(email);
		per.setPassword(password);
		
		try {
			per=ctrl.validate(per);
			if ( per.getHabilitado() == 1) {
				empleado=true;
			} else { empleado = false;}
		
			
			sesion.setAttribute("nombre",per.getNombre());
			
			request.getSession().setAttribute("usuario", per);

			request.setAttribute("emp", empleado);
			
			request.getRequestDispatcher("SignIn.jsp").forward(request, response);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("mensaje", e.getMessage());
			request.getRequestDispatcher("SignIn.jsp").forward(request, response);
			
			
		}  
		
		
		 
		 
	} 
		
}}


