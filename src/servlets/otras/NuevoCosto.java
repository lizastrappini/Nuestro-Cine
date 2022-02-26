package servlets.otras;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.CostoEntrada;
import logic.LogicCostoEntrada;

/**
 * Servlet implementation class NuevoCosto
 */
@WebServlet("/NuevoCosto")
public class NuevoCosto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoCosto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CostoEntrada ce = new CostoEntrada();
		LogicCostoEntrada lce = new LogicCostoEntrada();
		
		ce.setCosto(Double.parseDouble(request.getParameter("costo")));
		lce.cargar(ce);
		
		String cargada = "cargada";
		request.setAttribute("cargada", cargada);
		request.getRequestDispatcher("Empleados.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
