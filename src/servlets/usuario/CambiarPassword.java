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
 * Servlet implementation class CambiarPassword
 */
@WebServlet({ "/CambiarPassword", "/cambiarPassword", "/cambiarpassword" })
public class CambiarPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CambiarPassword() {
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
		Persona per = (Persona)request.getSession().getAttribute("usuario");
		Login ctrl = new Login();
		String pass= ctrl.obtenerPass(per);
		
		if (request.getParameter("passoriginal").toString().equals(pass)) {
				per.setPassword(request.getParameter("pass2").toString());
				ctrl.actualizarPass(per);
				String cambio="passCambiada";
				request.setAttribute("cambioPass",cambio );
				request.getRequestDispatcher("MiCuenta.jsp").forward(request, response);
			
		} else {
			String cambio="passNoCoinciden";
			request.setAttribute("cambioPass",cambio );
			request.getRequestDispatcher("MiCuenta.jsp").forward(request, response);
			
		}
		
	}

	

}
