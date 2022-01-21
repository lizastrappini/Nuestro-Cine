package servlets.pelicula;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

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
		
		
		pel.setNombre(request.getParameter("nombre").toString());
		pel.setGenero(request.getParameter("genero").toString());
		pel.setCalificacion(request.getParameter("edad").toString());
		pel.setSinopsis(request.getParameter("sinopsis").toString());
		pel.setDirector(request.getParameter("director").toString());
		pel.setDuracion(Integer.parseInt(request.getParameter("duracion").toString()));
		pel.setPortada(request.getParameter("portada").toString());
		String fecha1=request.getParameter("estreno").toString();
		
		Date fecha;
		try {
			fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fecha1);
			pel.setFecha_estreno(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
		
		lp.cargar(pel);
		
		String cargada = "cargada";
		request.setAttribute("cargada", cargada);
		request.getRequestDispatcher("Empleados.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
