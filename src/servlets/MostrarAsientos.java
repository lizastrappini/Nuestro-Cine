package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Funcion;
import logic.LogicButFun;
import entities.ButacaFuncion;
import java.time.LocalDate;
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Integer cod=Integer.parseInt(request.getParameter("codigopeli"));
		Integer nro_sala=Integer.parseInt(request.getParameter("nrosala"));
		String fecha1=request.getParameter("fechahora");
		
		Funcion fun = new Funcion();
		
		fun.setCodigo_pelicula(cod);
		fun.setNumero_sala(nro_sala);
		
		DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		LocalDate fecha = LocalDate.parse(fecha1, inputFormat);

        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(fecha.format(outputFormat));
		//fun.setFecha_hora(fecha);
		
		LogicButFun lbf = new LogicButFun();
		
		LinkedList<ButacaFuncion> butacas = lbf.buscar(fun);

		request.setAttribute("listabutacas", butacas);
		request.getRequestDispatcher("WEB-INF/FunManagement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
