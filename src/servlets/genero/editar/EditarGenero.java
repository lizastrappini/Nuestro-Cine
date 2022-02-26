package servlets.genero.editar;

import java.io.IOException;
import java.util.LinkedList;

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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LogicGenero lg = new LogicGenero();
		
		if (request.getParameter("bandera")==null) {
			LinkedList<Genero> generos = lg.getAll();
			request.setAttribute("generos", generos);
			
			Integer idGenero = Integer.parseInt(request.getParameter("elegirgenero"));
			
			Genero generoEncontrado = lg.buscarPorCodigo(idGenero);
			request.setAttribute("generoEncontrado", generoEncontrado);
			request.setAttribute("encontrada", "encontrada");
			request.getRequestDispatcher("WEB-INF/Genero/Editar/EditGenero.jsp").forward(request, response);
		} else {
			Integer idGenero = Integer.parseInt(request.getParameter("idgen"));
			String descripcion = request.getParameter("descripcion");
			Genero generoEncontrado = lg.buscarPorCodigo(idGenero);
			generoEncontrado.setDescripcion(descripcion);
			lg.editar(generoEncontrado);
			request.setAttribute("generoEncontrado", generoEncontrado);
			request.setAttribute("encontrada", "encontrada");
			request.setAttribute("editada", "editada");
			request.getRequestDispatcher("WEB-INF/Genero/Editar/EditGenero.jsp").forward(request, response);
		}
	}

}
