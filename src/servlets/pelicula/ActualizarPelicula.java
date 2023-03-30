package servlets.pelicula;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
		

		if( request.getParameter("bandera")==null ) {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		
		Pelicula peli = new Pelicula();
		LogicPelicula lp = new LogicPelicula();
		
		peli = lp.buscarPorCodigo(codigo);

		request.setAttribute("pelicula", peli);
		request.getRequestDispatcher("WEB-INF/Pelicula/Edit.jsp").forward(request, response);
		}
		
		if( !(request.getParameter("bandera")==null)) {
			if (request.getParameter("bandera").toString().equals("cambio") ) {
				
				String pelianterior = request.getParameter("pelianterior");
				
				Pelicula pelicambiada = new Pelicula();
				LogicPelicula lp = new LogicPelicula();
				
				Integer codigo = Integer.parseInt(request.getParameter("codigo"));
				pelicambiada.setCodigo(codigo);
				
				Pelicula peli = new Pelicula();
				
				peli = lp.buscarPorCodigo(codigo);

				request.setAttribute("pelicula", peli);
				
				String nombre = request.getParameter("nombre");
				pelicambiada.setNombre(nombre);
				
				Integer cod_genero = Integer.parseInt(request.getParameter("elegirGenero"));
				pelicambiada.setId_genero(cod_genero);
				
				Integer cod_calif = Integer.parseInt(request.getParameter("elegirCalificacion"));
				pelicambiada.setCodigo_calificacion(cod_calif);

				String sinopsis = request.getParameter("sinopsis");
				pelicambiada.setSinopsis(sinopsis);

				String director = request.getParameter("director");
				pelicambiada.setDirector(director);

				double duracion = Double.parseDouble(request.getParameter("duracion"));
				pelicambiada.setDuracion(duracion);

				String portada = request.getParameter("portada");
				pelicambiada.setPortada(portada);
				
				String fecha1=request.getParameter("estreno");
				
				try {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate parsedDate = LocalDate.parse(fecha1, formatter);
					pelicambiada.setFecha_estreno(parsedDate);
					if ( !(pelianterior.equals(pelicambiada.toString())) ) {
						
						lp.modificar(pelicambiada);
						request.setAttribute("editada", "editada");
						request.getRequestDispatcher("WEB-INF/Pelicula/EditarPelicula.jsp").forward(request, response);
					
					} else if ( pelianterior.equals(pelicambiada.toString()) ){ 
						request.setAttribute("nocambio", "nocambio");
						request.getRequestDispatcher("WEB-INF/Pelicula/EditarPelicula.jsp").forward(request, response);

					}
				} catch (DateTimeException e) {
					e.printStackTrace();
					request.setAttribute("errorFormatoFecha", e.getMessage());
					request.setAttribute("pelicula", peli);
					request.getRequestDispatcher("WEB-INF/Pelicula/Edit.jsp").forward(request, response);
				}  
				
			}
		}
				
	}

}
