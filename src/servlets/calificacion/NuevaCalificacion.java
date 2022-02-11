package servlets.calificacion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Calificacion;
import logic.LogicCalificacion;

/**
 * Servlet implementation class NuevaCalificacion
 */
@WebServlet("/NuevaCalificacion")
public class NuevaCalificacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevaCalificacion() {
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
		Calificacion cali = new Calificacion();
		LogicCalificacion lc = new LogicCalificacion();
		
		cali.setDescripcion(request.getParameter("descripcion"));
		lc.cargar(cali);
		request.setAttribute("cargada", "cargada");
		request.getRequestDispatcher("WEB-INF/Calificacion/Agregar/AgregarCalificacion.jsp").forward(request, response);
	}

}
