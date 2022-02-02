package servlets.pelicula;

import java.io.IOException;

import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataPelicula;
import entities.Pelicula;
import logic.LogicPelicula;

//import logic.Estrenos;



/**
 * Servlet implementation class MostrarPelicula
 */
@WebServlet({ "/Mostrarpeliculas", "/MostrarPeliculas" })
public class MostrarPeliculas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarPeliculas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		
		if(!(request.getParameter("genero")==(null))) {
			
			String genero = request.getParameter("genero");
			LogicPelicula lp = new LogicPelicula();
		
			if(!(genero.equals("todas")) ) {
			
			
			try {
				LinkedList<Pelicula> peliculas = lp.buscarPorGenero(genero);
				request.setAttribute("listapeliculas", peliculas);
				request.getRequestDispatcher("WEB-INF/Pelicula/PelManagement.jsp").forward(request, response);
			} catch (NullPointerException e) {
				e.printStackTrace();
				String noEncontrada="noEncontrada";
				request.setAttribute("noEncontrada", noEncontrada);
				request.getRequestDispatcher("Peliculas.jsp").forward(request, response);
			}
			

		}
		
		if(genero.equals("todas")) {

			LinkedList<Pelicula> peliculas = lp.getAll();
			
			request.setAttribute("listapeliculas", peliculas);
			request.getRequestDispatcher("WEB-INF/Pelicula/PelManagement.jsp").forward(request, response);
		}}
		
		if(!(request.getParameter("edad")==(null))) {
			String edad = request.getParameter("edad");
			LogicPelicula lp = new LogicPelicula();
			
			if (!(edad.equals("todas"))) {
				
				
				LinkedList<Pelicula> peliculas = lp.buscarPorEdad(edad);
				
				request.setAttribute("listapeliculas", peliculas);
				request.getRequestDispatcher("WEB-INF/Pelicula/PelManagement.jsp").forward(request, response);
			}
			
			if(edad.equals("todas")) {
				
				LinkedList<Pelicula> peliculas = lp.getAll();
				
				request.setAttribute("listapeliculas", peliculas);
				request.getRequestDispatcher("WEB-INF/Pelicula/PelManagement.jsp").forward(request, response);
			}
		}
		
		if(!(request.getParameter("nombre")==(null))) {
			
			String nombre = request.getParameter("nombre").toString();
			LogicPelicula lp = new LogicPelicula();
			LinkedList<Pelicula> peliculas = lp.buscar(nombre);
			
			if ( !(peliculas.isEmpty()) ) {
				request.setAttribute("peliculas", peliculas);
				request.getRequestDispatcher("WEB-INF/Pelicula/PelManagement.jsp").forward(request, response);
			} else {
				String noEncontrada = "noencontrada";
				request.setAttribute("noEncontrada", noEncontrada);
				request.getRequestDispatcher("Peliculas.jsp").forward(request, response);
			}
			
		}
		 
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
				String estrenos="true";
		
			 	DataPelicula dp= new DataPelicula();
				
				LinkedList<Pelicula> peliculas = dp.listarEstrenos();
				request.setAttribute("estrenos", estrenos);
				request.setAttribute("listapeliculas", peliculas);
				request.getRequestDispatcher("WEB-INF/Pelicula/PelManagement.jsp").forward(request, response);
		 
		 
				
		 
	}

}
