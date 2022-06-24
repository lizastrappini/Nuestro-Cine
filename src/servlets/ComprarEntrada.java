package servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.ButacaFuncion;
import entities.Entrada;
import entities.Persona;
import enviodecorreo.Correo;
import logic.LogicButFun;
import logic.LogicEntrada;
import data.DataPersona;

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
		String indexes = request.getParameter("listaButacas");
		Integer codPeli = Integer.parseInt(request.getParameter("codigo"));
		Integer nroSala = Integer.parseInt(request.getParameter("numeroSala"));
		String dni = request.getParameter("dni");
		Double precio = Double.parseDouble(request.getParameter("precio"));
		String fecha1=request.getParameter("fechahora");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime dateTime2 = LocalDateTime.parse(fecha1, formatter);
		
		LogicButFun logicbf = new LogicButFun();
		LogicEntrada le = new LogicEntrada();

		String[] split = indexes.split(","); //para dividir el string y recuperar cada asiento
		
        for (int i=0; i<split.length; i++) {
   
        	ButacaFuncion bf = new ButacaFuncion();
        	bf.setCod_pelicula(codPeli);
        	bf.setFecha_hora_funcion(dateTime2);
        	bf.setNro_sala(nroSala);     	
        	bf.setNumero(Integer.parseInt(split[i])+1);
        	//sumo 1 porque viene del jsp MostrarAsientos donde el indice de los asientos empieza en 0 	
            bf.setEstado(1);
        	logicbf.cambiarEstado(bf);
            Entrada ent = new Entrada();
            ent.setCod_pelicula(codPeli);
            ent.setFecha_hora_funcion(dateTime2);
            ent.setNro_sala(nroSala);
            ent.setNumero_butaca(Integer.parseInt(split[i])+1);
            ent.setDni(dni);
            ent.setTotal(precio);
            le.cargar(ent);
            
        }
        
        //usar o crear un cliente con un mail nuestro ej: marisooltorrees@gmail.com 
        DataPersona dp = new DataPersona();   
        Persona per = new Persona();
        per.setDni(dni); 						
        per = dp.search(per);				
        String mail = per.getEmail();			
        
        
		Correo c = new Correo("nuestrocinejava@hotmail.com",mail,"java2022");
		c.envioDeCorreos();
		
		request.setAttribute("entradasCompradas", "entradasCompradas");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
