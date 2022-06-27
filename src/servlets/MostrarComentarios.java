package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataComentario;
import entities.Comentario;
import entities.Pelicula;
import logic.LogicPelicula;

/**
 * Servlet implementation class MostrarComentarios
 */
@WebServlet("/MostrarComentarios")
public class MostrarComentarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarComentarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer cod=Integer.parseInt(request.getParameter("codigo"));
		Comentario com = new Comentario();

		Pelicula pel = new Pelicula();
		LogicPelicula lp = new LogicPelicula();
		
		com.setCodigo_pel(cod);
		DataComentario dc= new DataComentario();
		
		LinkedList<Comentario> comentarios = dc.buscarComentarioPorPeli(com);
		
		pel = lp.buscarPorCodigo(cod);
		request.setAttribute("pel", pel);

		request.setAttribute("listacomentarios", comentarios);
		request.getRequestDispatcher("WEB-INF/Comentario/MostrarComentarios.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
