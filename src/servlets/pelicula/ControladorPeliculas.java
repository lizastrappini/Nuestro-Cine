package servlets.pelicula;

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
 * Servlet implementation class ControladorPeliculas
 */
@WebServlet({ "/EditPeliculas", "/Controladorpeliculas", "/ControladorPeliculas" })
public class ControladorPeliculas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorPeliculas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LogicPelicula lp = new LogicPelicula();
		
		LinkedList<Pelicula>peliculas= lp.getAll();
		
		request.setAttribute("peliculas", peliculas);
		
		if(! (request.getParameter("opc1")==(null)) ){
			request.getRequestDispatcher("WEB-INF/Pelicula/AgregarPelicula.jsp").forward(request, response);
		}
		
		else if (! (request.getParameter("opc2")==(null))  ) {
			request.getRequestDispatcher("WEB-INF/Pelicula/EditarPelicula.jsp").forward(request, response);
			
		}
		
		else if (! (request.getParameter("opc3")==(null))  ) {
			request.getRequestDispatcher("WEB-INF/Pelicula/BorrarPelicula.jsp").forward(request, response);
		}
	}

}
