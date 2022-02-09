package servlets.funcion.editar;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Funcion;
import logic.LogicFuncion;

/**
 * Servlet implementation class EditaFuncion
 */
@WebServlet("/BuscarFuncionesDePeliculaEditar")
public class BuscarFuncionesDePeliculaEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarFuncionesDePeliculaEditar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer cod=Integer.parseInt(request.getParameter("codigoPel"));
		Funcion fun = new Funcion();

		LogicFuncion lf = new LogicFuncion();
		
		fun.setCodigo_pelicula(cod);
		LinkedList<Funcion> funciones = lf.buscarFuncionesPorPeli(fun);

		request.setAttribute("listafunciones", funciones);
		request.getRequestDispatcher("WEB-INF/Funcion/Editar/MostrarFuncionesDePelicula.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
