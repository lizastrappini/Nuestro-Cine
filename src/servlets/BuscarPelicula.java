package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entities.Pelicula;
import logic.LogicPelicula;

/**
 * Servlet implementation class BuscarPelicula
 */
@WebServlet({ "/BuscarPelicula", "/buscarPelicula", "/Buscarpeliculas" })
public class BuscarPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarPelicula() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LogicPelicula lp = new LogicPelicula();
		
		String nombre = request.getParameter("nombre").toString();

		
		LinkedList<Pelicula> pelis = lp.buscar(nombre);
		
		if ( !(pelis.isEmpty()) ) {
			String encontrada = "encontrada";
			request.setAttribute("encontrada", encontrada);
			request.setAttribute("peliculas", pelis);
			request.getRequestDispatcher("WEB-INF/Pelicula/BorrarPelicula.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LogicPelicula lp = new LogicPelicula();
		
		String nombre = request.getParameter("nombre").toString();

		
		LinkedList<Pelicula> pelis = lp.buscar(nombre);
		
		if ( !(pelis.isEmpty()) ) {
			String bandera1 = "encontrada";
			request.setAttribute("bandera1", bandera1);
			request.setAttribute("peliculas", pelis);
			request.getRequestDispatcher("WEB-INF/Pelicula/EditarPelicula.jsp").forward(request, response);
			
		}   
		
		
		
		
		
	
		
//		
		
		
		
	}

}
