package servlets.sala;

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
 * Servlet implementation class ActualizarSala
 */
@WebServlet({"/ActualizarSala", "/actualizarSala", "/actualizarsala", "/Actualizarsala" })
public class ActualizarSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarSala() {
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
		
		LogicSala ls = new LogicSala();
		
		if (request.getParameter("bandera")==null) {
			LinkedList<Sala> salas = ls.getAll();
			request.setAttribute("salas", salas);
			
			Integer nroSala = Integer.parseInt(request.getParameter("elegirsala"));
			
			Sala salaEncontrada = ls.buscarPorNumero(nroSala);
			request.setAttribute("salaEncontrada", salaEncontrada);
			request.setAttribute("encontrada", "encontrada");
			request.getRequestDispatcher("WEB-INF/Sala/Editar/EditarSala.jsp").forward(request, response);
		} else {
			Integer nroSala = Integer.parseInt(request.getParameter("numerosala"));
			String descripcion = request.getParameter("descripcion");
			Sala salaEncontrada = ls.buscarPorNumero(nroSala);
			salaEncontrada.setDescripcion(descripcion);
			ls.modificar(salaEncontrada);;
			request.setAttribute("salaEncontrada", salaEncontrada);
			request.setAttribute("encontrada", "encontrada");
			request.setAttribute("editada", "editada");
			request.getRequestDispatcher("WEB-INF/Sala/Editar/EditarSala.jsp").forward(request, response);
		}
		
	}

}
