package servlets.funcion;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import data.DataFuncion;
import entities.Funcion;
import entities.Pelicula;
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
		
		Integer cod=Integer.parseInt(request.getParameter("codigo"));
		Funcion fun = new Funcion();

		Pelicula pel = new Pelicula();
		LogicPelicula lp = new LogicPelicula();
		
		fun.setCodigo_pelicula(cod);
		DataFuncion df= new DataFuncion();
		
		LinkedList<Funcion> funciones = df.buscarFuncionPorPeli(fun);
		
		pel = lp.buscarPorCodigo(cod);
		request.setAttribute("pel", pel);

		request.setAttribute("listafunciones", funciones);
		request.getRequestDispatcher("WEB-INF/Funcion/FunManagement.jsp").forward(request, response);
	}

}


