package logic;

import java.util.LinkedList;
import data.DataCalificacion;
import entities.Calificacion;


public class LogicCalificacion {
	
		private DataCalificacion dc;
		
		public LogicCalificacion() {
			dc = new DataCalificacion();
		}
	
		public void cargar(Calificacion c) {
			dc.cargarCalificacion(c);
		}
		
		public void editar(Calificacion c) {
			dc.modificar(c);
		}
		
		public LinkedList<Calificacion> getAll(){
			return dc.listarCalificacion();
		}
		
		public Calificacion buscar(Calificacion c) {
			return dc.buscarCalificacion(c);
		}
		
		public void borrar(Calificacion c) {
			dc.borrarCalificacion(c);
		}
}
