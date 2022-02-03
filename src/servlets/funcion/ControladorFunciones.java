package servlets.funcion;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Pelicula;
import logic.LogicPelicula;


/**
 * Servlet implementation class ControladorFunciones
 */
@WebServlet({"/ControladorFunciones", "/EditFunciones", "/Controladorfunciones"})
public class ControladorFunciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorFunciones() {
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
		
		LogicPelicula lp = new LogicPelicula();
		
		LinkedList<Pelicula>peliculas= lp.getAll();
		
		request.setAttribute("peliculas", peliculas);
	
		if(! (request.getParameter("opc1")==(null)) ){
			
			request.getRequestDispatcher("WEB-INF/Funcion/Agregar/AgregarFuncion.jsp").forward(request, response);
		}
		
		else if (! (request.getParameter("opc2")==(null))  ) {
			 
			request.getRequestDispatcher("WEB-INF/Funcion/Editar/EditarFuncion.jsp").forward(request, response);
			
		}
		
		else if (! (request.getParameter("opc3")==(null))  ) {

			request.getRequestDispatcher("WEB-INF/Funcion/Borrar/BorrarFuncion.jsp").forward(request, response);
		}
	}

}
