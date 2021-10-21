package servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Pelicula;
import logic.LogicPelicula;

/**
 * Servlet implementation class ActualizarPelicula
 */
@WebServlet({ "/ActualizarPelicula", "/actualizarPelicula", "/actualizarpelicula", "/Actualizarpelicula" })
public class ActualizarPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarPelicula() {
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
		Pelicula peli = new Pelicula();
		LogicPelicula lp = new LogicPelicula();
		
		
		String nombre = request.getParameter("nombre");
		String genero = request.getParameter("genero");
		String edad = request.getParameter("edad");
		String sinopsis = request.getParameter("sinopsis");
		String director = request.getParameter("director");
		int duracion = Integer.parseInt(request.getParameter("duracion"));
		String portada = request.getParameter("portada");
		Date estreno=Date.valueOf(request.getParameter("estreno") .toString());
		int codigo = lp.buscaCodigo(peli);
		
		
		
		
		//BUSCAR CODIGO DE PELICULA PORQUE SI NO NO SE ACTUALIZA
		
		peli.setCodigo(codigo);
		peli.setNombre(nombre);
		peli.setGenero(genero);
		peli.setCalificacion(edad);
		peli.setSinopsis(sinopsis);
		peli.setDirector(director);
		peli.setDuracion(duracion);
		peli.setPortada(portada);
		peli.setFecha_estreno(estreno);
		peli = lp.validate(peli);
		
		if ( !(peli==(null)) ) {
			lp.modificar(peli);
			System.out.println("modificada");
			String bandera2 = "modificada";
			request.setAttribute("bandera2", bandera2);
			request.getRequestDispatcher("WEB-INF/EditarPelicula.jsp").forward(request, response);
		}

//		//String bandera1 = "encontrada";
//		String bandera2 = "modificada";
//		request.setAttribute("bandera2", bandera2);
//		//request.setAttribute("bandera1", bandera1);
//		request.getRequestDispatcher("WEB-INF/EditarPelicula.jsp").forward(request, response);
		
		
	}

}
