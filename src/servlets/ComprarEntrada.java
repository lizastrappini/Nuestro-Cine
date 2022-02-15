package servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.ButacaFuncion;
import logic.LogicButFun;

/**
 * Servlet implementation class ComprarEntrada
 */
@WebServlet("/ComprarEntrada")
public class ComprarEntrada extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComprarEntrada() {
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
		String indexes = request.getParameter("listaButacas").toString();
		Integer codPeli = Integer.parseInt(request.getParameter("codigo").toString());
		Integer nroSala = Integer.parseInt(request.getParameter("numeroSala").toString());
		String fecha1=request.getParameter("fechahora");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime dateTime2 = LocalDateTime.parse(fecha1, formatter);
		
		LogicButFun logicbf = new LogicButFun();
		

		String[] split = indexes.split(","); //para dividir el string y recuperar cada asiento
		
        for (int i=0; i<split.length; i++) {
   
        	ButacaFuncion bf = new ButacaFuncion();
        	bf.setCod_pelicula(codPeli);
        	bf.setFecha_hora_funcion(dateTime2);
        	bf.setNro_sala(nroSala);     	
        	bf.setNumero(Integer.parseInt(split[i])+1);
        	//sumo 1 porque viene del jsp MostrarAsientos donde el indice de los asientos empieza en 0 	
            logicbf.cambiarEstado(bf);
            
        }
		
		request.setAttribute("entradasCompradas", "entradasCompradas");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
