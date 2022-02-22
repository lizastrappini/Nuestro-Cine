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
 * Servlet implementation class ActualizarCalificacion
 */
@WebServlet("/ActualizarCalificacion")
public class ActualizarCalificacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarCalificacion() {
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
			request.getRequestDispatcher("WEB-INF/Calificacion/Editar/EditarCalificacion.jsp").forward(request, response);
		} else {
			Integer codigoCalificacion = Integer.parseInt(request.getParameter("codigocali"));
			String descripcion = request.getParameter("descripcion");
			Calificacion calificacionEncontrada = lc.buscarPorCodigo(codigoCalificacion);
			calificacionEncontrada.setDescripcion(descripcion);
			lc.modificar(calificacionEncontrada);
			request.setAttribute("calificacionEncontrada", calificacionEncontrada);
			request.setAttribute("encontrada", "encontrada");
			request.setAttribute("editada", "editada");
			request.getRequestDispatcher("WEB-INF/Calificacion/Editar/EditarCalificacion.jsp").forward(request, response);
		}
	}
}
