package servlets.sala.borrar;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Sala;
import logic.LogicSala;

/**
 * Servlet implementation class BuscarSala
 */
@WebServlet("/BuscarSalaBorrar")
public class BuscarSalaBorrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarSalaBorrar() {
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
		
		LogicSala ls = new LogicSala();
		
		if (request.getParameter("bandera")==null) {
			LinkedList<Sala> salas = ls.getAll();
			request.setAttribute("salas", salas);
			
			Integer nroSala = Integer.parseInt(request.getParameter("elegirsala"));
			
			Sala salaEncontrada = ls.buscarPorNumero(nroSala);
			request.setAttribute("salaEncontrada", salaEncontrada);
			request.setAttribute("encontrada", "encontrada");
			request.getRequestDispatcher("WEB-INF/Sala/Borrar/BorrarSala.jsp").forward(request, response);
		} else {
			Integer nroSala = Integer.parseInt(request.getParameter("numerosala"));
			Sala salaEncontrada = ls.buscarPorNumero(nroSala);
			ls.borrar(salaEncontrada);
			request.setAttribute("salaEncontrada", salaEncontrada);
			request.setAttribute("encontrada", "encontrada");
			request.setAttribute("borrada", "borrada");
			request.getRequestDispatcher("WEB-INF/Sala/Borrar/BorrarSala.jsp").forward(request, response);
		}
	}

}
