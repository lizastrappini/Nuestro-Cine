package servlets.funcion.agregar;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Funcion;
import entities.Pelicula;
import entities.Sala;
import logic.LogicFuncion;
import logic.LogicPelicula;
import logic.LogicSala;

/**
 * Servlet implementation class NuevaFuncion
 */
@WebServlet("/NuevaFuncion")
public class NuevaFuncion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevaFuncion() {
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
		
		LogicSala ls = new LogicSala();
		LinkedList<Sala> salas = ls.getAll();
		
		Integer codigo_peli = Integer.parseInt(request.getParameter("codigoPel"));
		Pelicula pel = new Pelicula();
		pel.setCodigo(codigo_peli);
	
		request.setAttribute("pelActual", pel);
		request.setAttribute("peliculas", peliculas);
		request.setAttribute("salas", salas);
		
		if ( request.getParameter("bandera")==null){
			request.getRequestDispatcher("WEB-INF/Funcion/Agregar/FormNuevaFuncion.jsp").forward(request, response);
		}
		
		if( (request.getParameter("bandera")!=null)) {
				
			Funcion nuevafuncion = new Funcion();
			LogicFuncion lf = new LogicFuncion();
				
			Integer numero_sala = Integer.parseInt(request.getParameter("elegirsala"));
			nuevafuncion.setNumero_sala(numero_sala);
				
			nuevafuncion.setCodigo_pelicula(codigo_peli);
				
			String strFechaUser = (request.getParameter("fechahora"));
				
			Sala sala = new Sala();
			sala.setNumero(numero_sala);
			Sala salaEncontrada = ls.buscar(sala);
			if (salaEncontrada!=null) {
				request.setAttribute("encontrada", "encontrada");
			} else {
				request.setAttribute("encontrada", null);
				request.getRequestDispatcher("WEB-INF/Funcion/Agregar/FormNuevaFuncion.jsp").forward(request, response);
			}
		
			try {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
				LocalDateTime dateTimeUser = LocalDateTime.parse(strFechaUser, formatter);
				nuevafuncion.setFecha_hora(dateTimeUser);
				
				LocalDate dateUser = LocalDate.parse(strFechaUser, formatter);
				
				if (dateUser.isAfter(LocalDate.now())) {
					if ( nuevafuncion.validarFuncion(nuevafuncion) ) {
						lf.cargar(nuevafuncion);
						request.setAttribute("cargada", "cargada");
					} else {
						request.setAttribute("fechaExiste", "fechaExiste");
					}
				} else {
					request.setAttribute("fechaInvalida", "fechaInvalida");
				}
				request.getRequestDispatcher("WEB-INF/Funcion/Agregar/FormNuevaFuncion.jsp").forward(request, response);
			} catch (DateTimeParseException e) {
				e.printStackTrace();
				request.setAttribute("errorFormatoFecha", e.getMessage());
				request.getRequestDispatcher("WEB-INF/Funcion/Agregar/FormNuevaFuncion.jsp").forward(request, response);
			}
		}
	}
}

