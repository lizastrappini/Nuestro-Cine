package servlets;

import java.io.IOException;
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pelicula pel = new Pelicula();
		LogicPelicula lp = new LogicPelicula();
		
		String nombre = request.getParameter("nombre");
		
		
		//pel.setNombre(nombre);
		
		pel=lp.buscar(nombre);
		
		if ( !(pel==null) ) {
			String bandera1 = "encontrada";
			request.setAttribute("bandera1", bandera1);
			request.setAttribute("pelicula", pel);
			request.getRequestDispatcher("WEB-INF/EditarPelicula.jsp").forward(request, response);
			
		}   //no esta encontrando la pelicula 
		
		
		
		
		
	
		
//		} else { System.out.println("no existe la pelicula");}
		
		
		
	}

}
