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
 * Servlet implementation class Registrarse
 */
@WebServlet({ "/Registrarse", "/registrarse" })
public class Registrarse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registrarse() {
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
		if( request.getSession().getAttribute("usuario")==null) { 
			
			Persona per = new Persona();
			Login ctrl = new Login();
			
			per.setPassword(request.getParameter("pwd1").toString());
			per.setEmail(request.getParameter("email").toString());
			per.setNombre(request.getParameter("nombre").toString());
			per.setApellido(request.getParameter("apellido").toString()); 
			per.setDni(request.getParameter("dni").toString());
			per.setEdad(Integer.parseInt(request.getParameter("edad").toString()));
			per.setTelefono(request.getParameter("tel").toString());
			per.setHabilitado(Integer.parseInt(request.getParameter("habilitado")));
			
			Integer existe = ctrl.buscarPorDni(per);
			if ( existe == null) {
				ctrl.newCli(per);
				String registro = "registrado";
				request.setAttribute("registro", registro);
				HttpSession sesion = request.getSession();
				sesion.setAttribute("nombre",per.getNombre());
				request.getSession().setAttribute("usuario", per);
				request.getRequestDispatcher("SignUp.jsp").forward(request, response);
				}
			else if ( existe!=null) {
				String registro = "noregistrado";
				request.setAttribute("registro", registro);
				request.getRequestDispatcher("SignUp.jsp").forward(request, response);
				}
			}
			
			
		}

}
