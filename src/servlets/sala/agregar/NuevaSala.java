package servlets.sala.agregar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Sala;
import logic.LogicSala;

/**
 * Servlet implementation class NuevaSala
 */
@WebServlet("/NuevaSala")
public class NuevaSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevaSala() {
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
		
		Sala sal = new Sala();
		LogicSala ls = new LogicSala();
		
		sal.setNumero(Integer.parseInt(request.getParameter("numero")));
		Sala salaEncontrada = ls.buscar(sal);
		if (salaEncontrada == null) {
			ls.cargar(sal);
			request.setAttribute("cargada", "cargada");
			request.getRequestDispatcher("WEB-INF/Sala/Agregar/AgregarSala.jsp").forward(request, response);
		} else {
			request.setAttribute("Noencontrada", "Noencontrada");
			request.getRequestDispatcher("WEB-INF/Sala/Agregar/AgregarSala.jsp").forward(request, response);
		}
	}

}
