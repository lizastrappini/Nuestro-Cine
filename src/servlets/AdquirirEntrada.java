package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AquirirEntrada
 */
@WebServlet("/AdquirirEntrada")
public class AdquirirEntrada extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdquirirEntrada() {
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
		
		
		Integer tot = Integer.parseInt(request.getParameter("total2"));
		Integer cant = Integer.parseInt(request.getParameter("count2"));
		
		String index = request.getParameter("indexes");
		
		
		
		System.out.println("Total de asientos: "+tot);
		System.out.println("precio total: "+cant);
		System.out.println("numeros de asientos: "+index);
		//hay que sumarle 1 al index porque empieza desde el 0
		//cambiar estado del asiento
	}

}
