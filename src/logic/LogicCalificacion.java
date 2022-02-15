package logic;

import java.util.LinkedList;
import data.DataCalificacion;
import entities.Calificacion;

public class LogicCalificacion {
private DataCalificacion dc;
	
	public LogicCalificacion() {
		dc = new DataCalificacion();
	}
	
	public void cargar(Calificacion cali) {
		dc.cargarCalificacion(cali);
	}
	
	public Calificacion buscar(Calificacion cali) {
		return dc.buscarCalificacion(cali);
	}
	
	public void modificar(Calificacion cali) {
		dc.modificar(cali);
	}
	
	public void borrar(Calificacion cali) {
		dc.borrarCalificacion(cali);
	}
	
	public LinkedList<Calificacion> getAll(){
		return dc.listarCalificaciones();
	}
	public Calificacion buscarPorCodigo(Integer codigo) {
		return dc.buscarPorCodigo(codigo);
	}
}
