package servlets.genero.agregar;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Genero;
import logic.LogicGenero;

/**
 * Servlet implementation class NuevoGenero
 */
@WebServlet("/NuevoGenero")
public class NuevoGenero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoGenero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre").toString();
		
		Genero g = new Genero();
		g.setDescripcion(nombre);
		
		LogicGenero lg = new LogicGenero();
		
		Genero gen = lg.buscar(g);
		
		if ( gen!= (null) ) {
			String noAgregado = "noAgregado";
			request.setAttribute("noAgregado", noAgregado );
			request.getRequestDispatcher("Empleados.jsp").forward(request, response);
			
		} else if( gen == (null) ){
			lg.cargar(g);
			String Agregado = "Agregado";
			request.setAttribute("Agregado", Agregado );
			request.getRequestDispatcher("Empleados.jsp").forward(request, response); }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
