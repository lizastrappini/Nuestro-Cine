package logic;

import data.DataEntrada;
import entities.Entrada;

public class LogicEntrada {
	private DataEntrada de;
	
	public LogicEntrada() {
		de = new DataEntrada();
	}
	
	public Entrada buscar(Entrada ent) {
		return de.buscarEntrada(ent);
	}
}
