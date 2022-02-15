package servlets.genero.editar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Genero;
import logic.LogicGenero;

/**
 * Servlet implementation class EditarGenero
 */
@WebServlet("/EditarGenero")
public class EditarGenero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarGenero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descripcion = request.getParameter("descripcion");
		Integer id = Integer.parseInt(request.getParameter("idGenero"));
		
		Genero g = new Genero();
		g.setDescripcion(descripcion);
		
		LogicGenero lg = new LogicGenero();	
		Genero gen = lg.buscar(g); //busco si esa descripcion del genero ya existe para no duplicarlo
		
		if ( gen==null) {
		g.setId(id);
		lg.editar(g);
		String Cambiado = "Cambiado";
		request.setAttribute("Cambiado", Cambiado );
		request.getRequestDispatcher("Empleados.jsp").forward(request, response);}
		else {
			String noAgregado = "noAgregado";
			request.setAttribute("noAgregado", noAgregado );
			request.getRequestDispatcher("Empleados.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descripcion = request.getParameter("GeneroPelicula");
		LogicGenero lg = new LogicGenero();
		Genero g = new Genero();
		g.setDescripcion(descripcion);
		
		Genero gen = lg.buscar(g);
		
		if(  gen == (null) ) {
			String noEncontrado = "noEncontrado";
			request.setAttribute("noEncontrado", noEncontrado );
			request.getRequestDispatcher("WEB-INF/Genero/Editar/EditGenero.jsp").forward(request, response);
		} else {
			
			String Encontrado = "Encontrado";
			request.setAttribute("Encontrado", Encontrado );
			request.setAttribute("idGenero", gen.getId() );
			request.getRequestDispatcher("WEB-INF/Genero/Editar/EditGenero.jsp").forward(request, response);
		}
			
			
		
	}

}
