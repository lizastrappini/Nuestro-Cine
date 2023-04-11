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
 * Servlet implementation class EditarDatos
 */
@WebServlet("/EditarDatos")
public class EditarDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarDatos() {
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
		Persona user = (Persona)request.getSession().getAttribute("usuario");
		Login lp = new Login();
		Persona usercambiado = new Persona();
		usercambiado.setNombre(request.getParameter("nombre").toString());
		usercambiado.setApellido(request.getParameter("apellido").toString());
		usercambiado.setTelefono(request.getParameter("telefono").toString());
		usercambiado.setEdad(Integer.parseInt(request.getParameter("edad")));
		usercambiado.setDni(user.getDni());
		
		if(!user.getNombre().equals(usercambiado.getNombre())) {
			user.setNombre(usercambiado.getNombre());
		}
		if(!user.getApellido().equals(usercambiado.getApellido())) {
			user.setApellido(usercambiado.getApellido());
		}
		if(!user.getTelefono().equals(usercambiado.getTelefono())) {
			user.setTelefono(usercambiado.getTelefono());
		}
		if(!(user.getEdad()==usercambiado.getEdad())) {
			user.setEdad(usercambiado.getEdad());
		}

		lp.editar(usercambiado);
		String cambio="datoscambiados";
		request.setAttribute("cambio",cambio );
		request.getRequestDispatcher("MiCuenta.jsp").forward(request, response);
	}

}
