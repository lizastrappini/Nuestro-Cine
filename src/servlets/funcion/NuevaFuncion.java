package servlets.funcion;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Funcion;
import logic.LogicFuncion;

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
		Funcion fun = new Funcion();
		LogicFuncion lf = new LogicFuncion();
		
		fun.setCodigo_pelicula(Integer.parseInt(request.getParameter("codigo")));
		String str = (request.getParameter("fechahora"));
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
			fun.setFecha_hora(dateTime);
			fun.setNumero_sala(Integer.parseInt(request.getParameter("numero")));
			lf.cargar(fun);
			
			String cargada = "cargada";
			request.setAttribute("cargada", cargada);
			request.getRequestDispatcher("Empleados.jsp").forward(request, response);
		} catch (DateTimeParseException e) {
			String errorFormatoFecha = "errorfecha";
			request.setAttribute("errorFormatoFecha", errorFormatoFecha);
			request.getRequestDispatcher("WEB-INF/Funcion/AgregarFuncion.jsp").forward(request, response);
		} finally {
			
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
