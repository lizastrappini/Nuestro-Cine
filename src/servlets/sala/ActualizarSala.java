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
 * Servlet implementation class ActualizarSala
 */
@WebServlet({"/ActualizarSala", "/actualizarSala", "/actualizarsala", "/Actualizarsala" })
public class ActualizarSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarSala() {
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
		
		if( request.getParameter("bandera")==null ) {
			Integer numero = Integer.parseInt(request.getParameter("numerosala"));
			
			Sala sal = new Sala();
			sal.setNumero(numero);
			
			LogicSala ls = new LogicSala();
			
			sal = ls.buscar(sal);
			
			request.setAttribute("sala", sal);
			request.getRequestDispatcher("WEB-INF/Sala/Edit.jsp").forward(request, response);
			}
			
			if( !(request.getParameter("bandera")==null)) {
				if (request.getParameter("bandera").toString().equals("cambio") ) {
					
					String salaanterior = request.getParameter("salaanterior");
					
					Sala salacambiada = new Sala();
					LogicSala ls = new LogicSala();
					
					Integer numero = Integer.parseInt(request.getParameter("numero"));
					
					Integer cupo = Integer.parseInt(request.getParameter("cupo"));					
				
					salacambiada.setNumero(numero);
							
					if ( !(salaanterior.equals(salacambiada.toString())) ) {
						
						ls.modificar(salacambiada);
						String modificada = "modificada";
						request.setAttribute("modificada", modificada);
						request.getRequestDispatcher("Empleados.jsp").forward(request, response);
					
					} else if ( salaanterior.equals(salacambiada.toString()) ){ 
						String nocambio = "nocambio";
						request.setAttribute("nocambio", nocambio);
						request.getRequestDispatcher("Empleados.jsp").forward(request, response);

					}
					
					
				}
			}
					
	}

}
