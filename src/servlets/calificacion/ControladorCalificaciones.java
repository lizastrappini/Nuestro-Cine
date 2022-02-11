package servlets.calificacion;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Calificacion;
import logic.LogicCalificacion;

/**
 * Servlet implementation class ControladorCalificaciones
 */
@WebServlet("/ControladorCalificaciones")
public class ControladorCalificaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorCalificaciones() {
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
		LogicCalificacion lc = new LogicCalificacion();
		LinkedList<Calificacion> calificaciones = lc.getAll();
		
		request.setAttribute("calificaciones", calificaciones);
		
		if(request.getParameter("opc1")!=null){
			
			request.getRequestDispatcher("WEB-INF/Calificacion/Agregar/AgregarCalificacion.jsp").forward(request, response);
		}
		
		else if (! (request.getParameter("opc2")==(null))  ) {
			 
			request.getRequestDispatcher("WEB-INF/Sala/Editar/EditarSala.jsp").forward(request, response);
			
		}
		
		else if (! (request.getParameter("opc3")==(null))  ) {

			request.getRequestDispatcher("WEB-INF/Calificacion/Borrar/BorrarCalificacion.jsp").forward(request, response);
		}

	}

}
