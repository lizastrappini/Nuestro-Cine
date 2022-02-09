package servlets.funcion.editar;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import logic.LogicPelicula;
import logic.LogicFuncion;
import logic.LogicSala;

/**
 * Servlet implementation class ActualizarFuncion
 */
@WebServlet("/ActualizarFuncion")
public class ActualizarFuncion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarFuncion() {
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
					
			Funcion funcionActual = new Funcion();
				
			Integer numero = Integer.parseInt(request.getParameter("numSalaAct"));
			funcionActual.setNumero_sala(numero);
				
			String str = (request.getParameter("fechaHoraAct"));
			LocalDateTime dateTime = LocalDateTime.parse(str);
			funcionActual.setFecha_hora(dateTime);
		
			Integer codigoPel = Integer.parseInt(request.getParameter("codigoPelAct"));
			funcionActual.setCodigo_pelicula(codigoPel);
		
			LogicPelicula lp = new LogicPelicula();
			Pelicula pelActual = lp.buscarPorCodigo(codigoPel);
			
			LinkedList<Pelicula>peliculas= lp.getAll();
			
			LogicSala ls = new LogicSala();
			LinkedList<Sala> salas = ls.getAll();
		
			request.setAttribute("funcionActual", funcionActual);
			request.setAttribute("pelActual", pelActual);
			request.setAttribute("peliculas", peliculas);
			request.setAttribute("salas", salas);
			
		if ( request.getParameter("bandera")==null){
			request.getRequestDispatcher("WEB-INF/Funcion/Editar/FormActualizarFuncion.jsp").forward(request, response);
		}
		
		if( (request.getParameter("bandera")!=null)) {
				
			Funcion nuevafuncion = new Funcion();
				
			Integer numero_sala = Integer.parseInt(request.getParameter("elegirsala"));
			nuevafuncion.setNumero_sala(numero_sala);
				
			Integer codigo_peli = Integer.parseInt(request.getParameter("elegirpelicula"));
			nuevafuncion.setCodigo_pelicula(codigo_peli);
				
			String str2 = (request.getParameter("fechahora"));
			try {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
				LocalDateTime dateTime2 = LocalDateTime.parse(str2, formatter);
				nuevafuncion.setFecha_hora(dateTime2);
			} catch (DateTimeParseException e) {
				e.printStackTrace();
				request.setAttribute("errorFormatoFecha", e.getMessage());
				request.getRequestDispatcher("WEB-INF/Funcion/Editar/FormActualizarFuncion.jsp").forward(request, response);
			}
				
			if ( !(funcionActual.equals(nuevafuncion)) ) {
					
				if (nuevafuncion.validarFuncion(nuevafuncion)) {
					LogicFuncion lf = new LogicFuncion();
					lf.modificar(nuevafuncion, funcionActual);
					request.setAttribute("modificada", "modificada");
				} else {
					request.setAttribute("fechaExiste", "fechaExiste");
				}
				
				request.getRequestDispatcher("WEB-INF/Funcion/Editar/FormActualizarFuncion.jsp").forward(request, response);
				
			}
			request.getRequestDispatcher("WEB-INF/Funcion/Editar/FormActualizarFuncion.jsp").forward(request, response);
		}
	}
}


