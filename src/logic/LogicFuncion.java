package logic;

import data.DataFuncion;
import entities.Funcion;

public class LogicFuncion {
private DataFuncion df;
	
	public LogicFuncion() {
		df = new DataFuncion();
	}
	
	public void cargar(Funcion fun) {
		df.cargarFuncion(fun);
	}
}
