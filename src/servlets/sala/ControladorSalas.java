package servlets.sala;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControladorSalas
 */
@WebServlet({"/EditSalas","/Controladorsalas","/ControladorSalas"})
public class ControladorSalas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorSalas() {
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
		
		if(! (request.getParameter("opc1")==(null)) ){
			
			request.getRequestDispatcher("WEB-INF/Sala/AgregarSala.jsp").forward(request, response);
		}
		
		else if (! (request.getParameter("opc2")==(null))  ) {
			 
			request.getRequestDispatcher("WEB-INF/Sala/EditarSala.jsp").forward(request, response);
			
		}
		
		else if (! (request.getParameter("opc3")==(null))  ) {

			request.getRequestDispatcher("WEB-INF/Sala/BorrarSala.jsp").forward(request, response);
		}
	}

}
