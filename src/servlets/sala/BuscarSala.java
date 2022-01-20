package servlets.sala;

import java.io.IOException;
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
@WebServlet({"/BuscarSala", "/buscarSala", "/Buscarsalas"})
public class BuscarSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarSala() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LogicSala ls = new LogicSala();
		Integer numero = Integer.parseInt(request.getParameter("numero"));
		Sala sal = new Sala();
		
		sal.setNumero(numero);
		Sala salEncontrada = ls.buscar(sal);
		
		if (salEncontrada != null) {
			String encontrada = "encontrada";
			request.setAttribute("encontrada", encontrada);
			request.setAttribute("sala", salEncontrada);
			request.getRequestDispatcher("WEB-INF/Sala/BorrarSala.jsp").forward(request, response);
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LogicSala ls = new LogicSala();
		Integer numero = Integer.parseInt(request.getParameter("numero"));
		Sala sal = new Sala();
		
		sal.setNumero(numero);
		Sala salEncontrada = ls.buscar(sal);
		
		if (salEncontrada != null) {
			String bandera1 = "encontrada";
			request.setAttribute("bandera1", bandera1);
			request.setAttribute("sala", salEncontrada);
			request.getRequestDispatcher("WEB-INF/Sala/EditarSala.jsp").forward(request, response);
			
		}
	}

}
