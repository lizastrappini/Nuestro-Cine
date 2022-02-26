package logic;

import data.DataEntrada;
import entities.Entrada;
import java.util.LinkedList;

public class LogicEntrada {
	private DataEntrada de;
	
	public LogicEntrada() {
		de = new DataEntrada();
	}
	
	public LinkedList<Entrada> buscar(Entrada ent) {
		return de.buscarEntrada(ent);
	}
	
	public void cargar(Entrada ent) {
		de.cargarEntrada(ent);
	}
}
