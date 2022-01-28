package servlets.funcion;

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
					
		Funcion funcionanterior = new Funcion();
					
		Integer codigo = Integer.parseInt(request.getParameter("codigopeli"));
		funcionanterior.setCodigo_pelicula(codigo);
			
		LogicPelicula lp = new LogicPelicula();
		Pelicula pelant = lp.buscarPorCodigo(codigo);
				
		Integer numero = Integer.parseInt(request.getParameter("nrosala"));
		funcionanterior.setNumero_sala(numero);
				
		String str = (request.getParameter("fechahora"));
		LocalDateTime dateTime = LocalDateTime.parse(str);
		funcionanterior.setFecha_hora(dateTime);
			
		LinkedList<Pelicula>peliculas= lp.getAll();
			
		LogicSala ls = new LogicSala();
		LinkedList<Sala> salas = ls.getAll();
		
		request.setAttribute("funcionanterior", funcionanterior);
		request.setAttribute("pelicula", pelant);
		request.setAttribute("peliculas", peliculas);
		request.setAttribute("salas", salas);
		if (request.getParameter("bandera")==null) {
			request.getRequestDispatcher("WEB-INF/Funcion/Edit.jsp").forward(request, response);
		}
		
		if( (request.getParameter("bandera")!=null)) {
			if (request.getParameter("bandera").toString().equals("cambio") ) {
				
				Funcion nuevafuncion = new Funcion();
				
				Integer numero_sala = Integer.parseInt(request.getParameter("elegirsala"));
				nuevafuncion.setNumero_sala(numero_sala);
				
				String str2 = (request.getParameter("fechahora"));
				try {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
					LocalDateTime dateTime2 = LocalDateTime.parse(str2, formatter);
					nuevafuncion.setFecha_hora(dateTime2);
				
					Integer codigo_peli = Integer.parseInt(request.getParameter("elegirpelicula"));
					nuevafuncion.setCodigo_pelicula(codigo_peli);
				
					Funcion anteriorFuncion = new Funcion();
				
					Integer numSalaAnt = Integer.parseInt(request.getParameter("numSalaAnt"));
					anteriorFuncion.setNumero_sala(numSalaAnt);
				
					String str3 = (request.getParameter("fechaHoraAnt"));
					LocalDateTime dateTime3 = LocalDateTime.parse(str3);
					anteriorFuncion.setFecha_hora(dateTime3);
				
					Integer codigoPelAnt = Integer.parseInt(request.getParameter("codigoPelAnt"));
					anteriorFuncion.setCodigo_pelicula(codigoPelAnt);
				
					if ( !(anteriorFuncion.equals(nuevafuncion)) ) {
					
						LogicFuncion lf = new LogicFuncion();
						lf.modificar(nuevafuncion, anteriorFuncion);
						String modificada = "modificada";
						request.setAttribute("modificada", modificada);
						request.getRequestDispatcher("Empleados.jsp").forward(request, response);
				
					} else if ( anteriorFuncion.equals(nuevafuncion) ){ 
						String nocambio = "nocambio";
						request.setAttribute("nocambio", nocambio);
						request.getRequestDispatcher("Empleados.jsp").forward(request, response);

					}
				} catch (DateTimeParseException e) {
					e.printStackTrace();
					request.setAttribute("errorFormatoFecha", e.getMessage());
					request.setAttribute("bandera", null);
					request.getRequestDispatcher("WEB-INF/Funcion/Edit.jsp").forward(request, response);
				}
			}
		}
	}
}


