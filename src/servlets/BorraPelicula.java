package servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Pelicula;
import logic.LogicPelicula;

/**
 * Servlet implementation class BorraPelicula
 */
@WebServlet("/BorraPelicula")
public class BorraPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorraPelicula() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pelicula pel = new Pelicula();
		LogicPelicula lp = new LogicPelicula();
		
		Integer cod = Integer.parseInt(request.getParameter("codigo"));
		pel = lp.buscarPorCodigo(cod);
		lp.delete(pel);
		String borrada= "borrada";
		request.setAttribute("borrada", borrada);
		
		request.getRequestDispatcher("Empleados.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
	}

}
