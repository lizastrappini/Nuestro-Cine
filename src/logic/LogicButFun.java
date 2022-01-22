package logic;

import data.DataButacaFuncion;
import entities.Funcion;
import entities.ButacaFuncion;
import java.util.LinkedList;

public class LogicButFun {
	
private DataButacaFuncion dbf;
	
	public LogicButFun() {
		dbf = new DataButacaFuncion();
	}
	public LinkedList<ButacaFuncion> buscar(Funcion fun) {
		return dbf.buscarButacasPorFuncion(fun);
	}
}
