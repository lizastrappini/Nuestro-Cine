package servlets.pelicula;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Pelicula;
import logic.LogicPelicula;

/**
 * Servlet implementation class NuevaPelicula
 */
@WebServlet("/NuevaPelicula")
public class NuevaPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevaPelicula() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pelicula pel = new Pelicula();
		LogicPelicula lp = new LogicPelicula();
		
		
		pel.setNombre(request.getParameter("nombre"));
		pel.setId_genero(Integer.parseInt(request.getParameter("elegirGenero")));
		pel.setCodigo_calificacion(Integer.parseInt(request.getParameter("elegirCalificacion")));
		pel.setSinopsis(request.getParameter("sinopsis"));
		pel.setDirector(request.getParameter("director"));
		pel.setDuracion(Integer.parseInt(request.getParameter("duracion")));
		pel.setPortada(request.getParameter("portada"));
		String fecha1=request.getParameter("fechahora");
		
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate parsedDate = LocalDate.parse(fecha1, formatter);
			pel.setFecha_estreno(parsedDate);
			lp.cargar(pel);
			request.setAttribute("cargada", "cargada");
			request.getRequestDispatcher("WEB-INF/Pelicula/AgregarPelicula.jsp").forward(request, response);
		} catch (DateTimeParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("errorFormatoFecha", e.getMessage());
			request.getRequestDispatcher("WEB-INF/Pelicula/AgregarPelicula.jsp").forward(request, response);
		}  
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
