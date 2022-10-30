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
				
				String cod_pelianterior = request.getParameter("pelianterior");
				
				
				Pelicula pelicambiada = new Pelicula();
				LogicPelicula lp = new LogicPelicula();
				Pelicula anterior = lp.buscarPorCodigo(Integer.parseInt(cod_pelianterior));
				
				Integer codigo = Integer.parseInt(request.getParameter("codigo"));
				
				String nombre = request.getParameter("nombre");
				
				Integer cod_genero = Integer.parseInt(request.getParameter("elegirGenero"));
				
				Integer cod_calif = Integer.parseInt(request.getParameter("elegirCalificacion"));

				String sinopsis = request.getParameter("sinopsis");
				

				String director = request.getParameter("director");

				double duracion = Double.parseDouble(request.getParameter("duracion"));

				String portada = request.getParameter("portada");
				
				String fecha1=request.getParameter("estreno");
				
				Date fecha;
				try {
					fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fecha1);
					pelicambiada.setFecha_estreno(fecha);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
				
				pelicambiada.setCodigo(codigo);
				pelicambiada.setNombre(nombre);
				pelicambiada.setId_genero(cod_genero);
				pelicambiada.setCodigo_calificacion(cod_calif);
				pelicambiada.setSinopsis(sinopsis);
				pelicambiada.setDirector(director);
				pelicambiada.setDuracion(duracion);
				pelicambiada.setPortada(portada);
		
				if(
					pelicambiada.getCodigo().toString().equals(anterior.getCodigo()) &&
					pelicambiada.getNombre().toString().equals(anterior.getNombre()) &&
					pelicambiada.getId_genero().toString().equals(anterior.getId_genero()) &&
					pelicambiada.getCodigo_calificacion().toString().equals(anterior.getCodigo_calificacion()) &&
					pelicambiada.getSinopsis().toString().equals(anterior.getSinopsis()) &&
					pelicambiada.getDirector().toString().equals(anterior.getDirector()) &&
					(pelicambiada.getDuracion()==(anterior.getDuracion())) &&
					pelicambiada.getPortada().toString().equals(anterior.getPortada()) ) 
				{
					lp.modificar(pelicambiada);
					request.setAttribute("editada", "editada");
					request.getRequestDispatcher("WEB-INF/Pelicula/EditarPelicula.jsp").forward(request, response);
				} else {
					request.setAttribute("nocambio", "nocambio");
					request.getRequestDispatcher("WEB-INF/Pelicula/EditarPelicula.jsp").forward(request, response);
				}
	
				
			}
			}
				
	}

}
