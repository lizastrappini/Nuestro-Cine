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
 * Servlet implementation class BuscarCalificacionBorrar
 */
@WebServlet("/BuscarCalificacionBorrar")
public class BuscarCalificacionBorrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarCalificacionBorrar() {
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
		
		if (request.getParameter("bandera")==null) {
			LinkedList<Calificacion> calificaciones = lc.getAll();
			request.setAttribute("calificaciones", calificaciones);
			
			Integer codigoCalificacion = Integer.parseInt(request.getParameter("elegircalificacion"));
			
			Calificacion calificacionEncontrada = lc.buscarPorCodigo(codigoCalificacion);
			request.setAttribute("calificacionEncontrada", calificacionEncontrada);
			request.setAttribute("encontrada", "encontrada");
			request.getRequestDispatcher("WEB-INF/Calificacion/Borrar/BorrarCalificacion.jsp").forward(request, response);
		} else {
			Integer codigoCalificacion = Integer.parseInt(request.getParameter("codigocali"));
			Calificacion calificacionEncontrada = lc.buscarPorCodigo(codigoCalificacion);
			lc.borrar(calificacionEncontrada);
			request.setAttribute("calificacionEncontrada", calificacionEncontrada);
			request.setAttribute("encontrada", "encontrada");
			request.setAttribute("borrada", "borrada");
			request.getRequestDispatcher("WEB-INF/Calificacion/Borrar/BorrarCalificacion.jsp").forward(request, response);
		}
	}

}
