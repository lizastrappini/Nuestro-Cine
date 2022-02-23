package logic;

import data.DataSala;
import entities.Sala;
import java.util.LinkedList;

public class LogicSala {
	
	private DataSala ds;
	
	public LogicSala() {
		ds = new DataSala();
	}
	
	public void cargar(Sala sal) {
		ds.cargarSala(sal);
	}
	
	public Sala buscar(Sala sal) {
		return ds.buscarSala(sal);
	}
	
	public void modificar(Sala sal) {
		ds.modificar(sal);
	}
	
	public void borrar(Sala sal) {
		ds.borrarSala(sal);
	}
	
	public LinkedList<Sala> getAll(){
		return ds.listarSalas();
	}
	public Sala buscarPorNumero(Integer nro) {
		return ds.buscarPorNumero(nro);
	}
}
