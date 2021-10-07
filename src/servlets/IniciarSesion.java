package servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Cliente;
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
		// TODO Auto-generated method stub
		Cliente cli = new Cliente();
		Login ctrl = new Login();
		
		
		String email = request.getParameter("email");
		String contraseña = request.getParameter("contraseña");
		//validar email y password
		
		cli.setEmail(email);
		cli.setContraseña(contraseña);
		
		cli=ctrl.validate(cli);
		
		
		request.getSession().setAttribute("usuario", cli);
		
		request.getRequestDispatcher("WEB-INF/CliManagement.jsp").forward(request, response);
		//response.getWriter().append("Bienvenido: ").append(cli.getNombre()).append(" ").append(cli.getApellido());
	}

}
