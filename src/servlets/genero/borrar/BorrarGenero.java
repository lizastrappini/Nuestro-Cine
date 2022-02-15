package servlets.genero.borrar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Genero;
import logic.LogicGenero;

/**
 * Servlet implementation class BorrarGenero
 */
@WebServlet("/BorrarGenero")
public class BorrarGenero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarGenero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("idGenero"));
		LogicGenero lg = new LogicGenero();
		Genero g = new Genero();
		g.setId(id);
		lg.borrar(g);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descripcion = request.getParameter("GeneroPelicula").toString();
		
		Genero g = new Genero();
		LogicGenero lg = new LogicGenero();
		
		g.setDescripcion(descripcion);
		Genero gen = lg.buscar(g);
		if( gen==null ) {
			String noEncontrado = "noEncontrado";
			request.setAttribute("noEncontrado", noEncontrado);
			request.getRequestDispatcher("WEB-INF/Genero/Borrar/BorrarGenero.jsp").forward(request, response);
		} else {
			String Encontrado = "Encontrado";
			request.setAttribute("Encontrado", Encontrado);
			request.setAttribute("idGenero", gen.getId());
			request.getRequestDispatcher("WEB-INF/Genero/Borrar/BorrarGenero.jsp").forward(request, response);
			
		}
	}

}
