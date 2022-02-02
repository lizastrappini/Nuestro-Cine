package servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Funcion;
import entities.Pelicula;
import entities.Sala;
import logic.LogicButFun;
import logic.LogicCostoEntrada;
import logic.LogicPelicula;
import logic.LogicSala;
import entities.ButacaFuncion;
import entities.CostoEntrada;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Servlet implementation class MostrarAsientos
 */
@WebServlet({"/MostrarAsientos", "/Mostrarasientos"})
public class MostrarAsientos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarAsientos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer cod=Integer.parseInt(request.getParameter("codigopeli"));
		Integer nro_sala=Integer.parseInt(request.getParameter("nrosala"));
		String fecha=request.getParameter("fechahora");
		
		Sala sala = new Sala();
		
		sala.setNumero(nro_sala);
		LogicSala ls = new LogicSala();
		Sala salaElegida = ls.buscar(sala);
		
		LogicPelicula lp = new LogicPelicula();
		Pelicula peli = lp.buscarPorCodigo(cod);
		
		
		
		
		LogicCostoEntrada lce = new LogicCostoEntrada();
		CostoEntrada ce = lce.costoActual();
		
		Double costo = ce.getCosto();
		
		
		request.setAttribute("fechafuncion", fecha);
		request.setAttribute("costo", costo);
		request.setAttribute("peli", peli);
		request.setAttribute("salaElegida", salaElegida);
		request.getRequestDispatcher("WEB-INF/Asientos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
