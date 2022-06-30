package servlets;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Comentario;
import logic.LogicComentario;

/**
 * Servlet implementation class NuevoComentario
 */
@WebServlet({ "/NuevoComentario", "/nuevocomentario", "/Nuevocomentario", "/nuevoComentario" })
public class NuevoComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoComentario() {
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
		// TODO Auto-generated method stub
		LogicComentario lc = new LogicComentario();
		Comentario c = new Comentario();
		c.setCodigo_pel(Integer.parseInt(request.getParameter("codigo")));
		c.setComentario(request.getParameter("comentario"));
		c.setDni(request.getParameter("dni"));
        c.setFecha_hora(LocalDateTime.now());
		lc.cargar(c);
		
		request.setAttribute("publicado", "publicado");
		request.setAttribute("codigopeli", Integer.parseInt(request.getParameter("codigo")) );
		request.getRequestDispatcher("WEB-INF/Comentario/MostrarComentarios.jsp").forward(request, response);
	}

}
