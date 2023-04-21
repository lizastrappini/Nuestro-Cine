package servlets.funcion;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entities.Funcion;
import entities.Pelicula;
import logic.LogicFuncion;
import logic.LogicPelicula;


/**
 * Servlet implementation class Funciones
 */
@WebServlet("/Funciones")
public class Funciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Funciones() {
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
		/*TRAE LA FECHA DEL JSP PELMANAGMENT Y LA CONVIERTE A LOCALDATETIME PARA BUSCARLA EN LA BASE*/
		String fechaTraida=request.getParameter("elegirFecha");
		System.out.println(fechaTraida);
		LocalDateTime fecha= LocalDateTime.parse(fechaTraida);
		
		//LinkedList<String> dias= new LinkedList<String>(); 
		Integer cod=Integer.parseInt(request.getParameter("codigo"));
		LogicFuncion lf= new LogicFuncion();
		Funcion fun = new Funcion();

		Pelicula pel = new Pelicula();
		LogicPelicula lp = new LogicPelicula();
		
		fun.setCodigo_pelicula(cod);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		
		/* RECORRE LAS FUNCIONES QUE SE TRAJO CON EL CODIGO DE LA PELICULA PARA SELECCIONAR LAS DEL DIA*/

		LinkedList<Funcion> funciones= lf.buscarFuncionPorfecha(fun,fecha);
		
		pel = lp.buscarPorCodigo(cod);
		request.setAttribute("pel", pel);
		//request.setAttribute("funDelDia",dias);
		request.setAttribute("listafunciones", funciones);
		request.getRequestDispatcher("WEB-INF/Funcion/FunManagement.jsp").forward(request, response);
	}
		
		
}


