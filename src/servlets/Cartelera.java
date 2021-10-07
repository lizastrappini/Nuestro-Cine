package servlets;

import java.io.IOException;

import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataPelicula;
import entities.Pelicula;

//import logic.Estrenos;



/**
 * Servlet implementation class Cartelera
 */
@WebServlet({ "/Cartelera", "/cartelera" })
public class Cartelera extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cartelera() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 String todas= "todas";
		 //String genero = request.getParameter("genero");
		 
		 
		
		while(!(request.getParameter("genero")==(null))) {
			String genero = request.getParameter("genero");
		 
		if(!(genero.equals(todas)) ) {
			
			DataPelicula dp= new DataPelicula();
			
			LinkedList<Pelicula> peliculas = dp.buscarPorGenero(genero);
			
			request.setAttribute("listapeliculas", peliculas);
			request.getRequestDispatcher("WEB-INF/PelManagement.jsp").forward(request, response);
		}
		
		if(genero.equals(todas)) {
			
			DataPelicula dp= new DataPelicula();

			LinkedList<Pelicula> peliculas = dp.listarPeliculas();
			
			request.setAttribute("listapeliculas", peliculas);
			request.getRequestDispatcher("WEB-INF/PelManagement.jsp").forward(request, response);
		}}
		
		while(!(request.getParameter("edad")==(null))) {
			String edad = request.getParameter("edad");
			 
			if (!(edad.equals(todas))) {
				DataPelicula dp= new DataPelicula();
				
				LinkedList<Pelicula> peliculas = dp.buscarPorEdad(edad);
				
				request.setAttribute("listapeliculas", peliculas);
				request.getRequestDispatcher("WEB-INF/PelManagement.jsp").forward(request, response);
			}
			
			if(edad.equals(todas)) {
				DataPelicula dp= new DataPelicula();

				LinkedList<Pelicula> peliculas = dp.listarPeliculas();
				
				request.setAttribute("listapeliculas", peliculas);
				request.getRequestDispatcher("WEB-INF/PelManagement.jsp").forward(request, response);
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
				request.getRequestDispatcher("WEB-INF/PelManagement.jsp").forward(request, response);
		 
		 
				
		 
	}

}
