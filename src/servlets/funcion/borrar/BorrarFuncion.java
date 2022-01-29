package servlets.funcion.borrar;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Funcion;
import logic.LogicFuncion;

/**
 * Servlet implementation class Borrar
 */
@WebServlet("/BorrarFuncion")
public class BorrarFuncion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarFuncion() {
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
		Funcion fun = new Funcion();
		LogicFuncion lf = new LogicFuncion();
		
		Integer codigo = Integer.parseInt(request.getParameter("codigopeli"));
		fun.setCodigo_pelicula(codigo);
		Integer numero = Integer.parseInt(request.getParameter("nrosala"));
		fun.setNumero_sala(numero);
		String str = (request.getParameter("fechahora"));
		LocalDateTime dateTime = LocalDateTime.parse(str);
		fun.setFecha_hora(dateTime);
		lf.borrar(fun);
		String borrada= "borrada";
		request.setAttribute("borrada", borrada);
		
		request.getRequestDispatcher("Empleados.jsp").forward(request, response);
	}

}
