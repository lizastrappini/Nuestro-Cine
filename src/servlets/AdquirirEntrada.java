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
 * Servlet implementation class AquirirEntrada
 */
@WebServlet("/AdquirirEntrada")
public class AdquirirEntrada extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdquirirEntrada() {
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
		
	
		String precio = request.getParameter("preciototal").toString();
		String index = request.getParameter("indexes").toString();
		Integer cod = Integer.parseInt(request.getParameter("codigopeli"));
		Integer nrosala = Integer.parseInt(request.getParameter("nrosala"));
		String fecha1=request.getParameter("fechahora");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime dateTime2 = LocalDateTime.parse(fecha1, formatter);

		LogicButFun lbf = new LogicButFun();
		LinkedList<ButacaFuncion> listaButacas = new LinkedList<>();
		String[] split = index.split(","); //para dividir el string y recuperar cada asiento
		
        for (int i=0; i<split.length; i++) {
   
        	ButacaFuncion bf = new ButacaFuncion();
        	bf.setCod_pelicula(cod);
        	bf.setFecha_hora_funcion(dateTime2);
        	bf.setNro_sala(nrosala);     	
        	bf.setNumero(Integer.parseInt(split[i])+1); //le sumo 1 al index porque en la bd empiezan desde el 1
        	//lbf.cambiarEstado(bf);
            listaButacas.add(bf);
        }
        
		
        request.setAttribute("indexes", index);
		request.setAttribute("listaButacas", listaButacas);
		request.getRequestDispatcher("WEB-INF/FinalizarCompra.jsp").forward(request, response);
	}

}
