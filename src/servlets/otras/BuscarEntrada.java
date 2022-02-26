package servlets.otras;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Entrada;
import logic.LogicEntrada;
import java.util.LinkedList;

/**
 * Servlet implementation class BuscarEntrada
 */
@WebServlet("/BuscarEntrada")
public class BuscarEntrada extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarEntrada() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String documento = request.getParameter("documento");
		Entrada ent = new Entrada();
		ent.setDni(documento);
		LogicEntrada le = new LogicEntrada();
		LinkedList<Entrada> entradas = new LinkedList<Entrada>();
		entradas = le.buscar(ent);
		if (!(entradas.isEmpty())) {
			request.setAttribute("encontrada", "encontrada");
			request.setAttribute("entradas", entradas);
			request.getRequestDispatcher("WEB-INF/Otras/FormVerificarEntrada.jsp").forward(request, response);
		}
		else {
			request.setAttribute("Noencontrada", "Noencontrada");
			request.getRequestDispatcher("WEB-INF/Otras/FormVerificarEntrada.jsp").forward(request, response);
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
