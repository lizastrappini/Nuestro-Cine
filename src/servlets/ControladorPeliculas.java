package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class ControladorPeliculas
 */
@WebServlet({ "/EditPeliculas", "/Controladorpeliculas", "/ControladorPeliculas" })
public class ControladorPeliculas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorPeliculas() {
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
		
		
		if(! (request.getParameter("opc1")==(null)) ){
			
//			 String opc1 = request.getParameter("opc1"); 
//			 request.setAttribute("opc",opc1);
			 
			request.getRequestDispatcher("WEB-INF/Pelicula/AgregarPelicula.jsp").forward(request, response);
		}
		
		else if (! (request.getParameter("opc2")==(null))  ) {
			
//			 String opc2 = request.getParameter("opc2"); 
//			 request.setAttribute("opc", opc2);
			 
			request.getRequestDispatcher("WEB-INF/Pelicula/EditarPelicula.jsp").forward(request, response);
			
		}
		
		else if (! (request.getParameter("opc3")==(null))  ) {
//			String opc3 = request.getParameter("opc3");
//			request.setAttribute("opc", opc3);
			request.getRequestDispatcher("WEB-INF/Pelicula/BorrarPelicula.jsp").forward(request, response);
		}
		
		
		
		
		
		

	}

}
