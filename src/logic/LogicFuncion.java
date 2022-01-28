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
	public void borrar(Funcion fun){
		df.borrarFuncion(fun);
	}
	public void modificar(Funcion funcionNueva, Funcion funcionAnterior) {
		df.modificarFuncion(funcionNueva, funcionAnterior);
	}
	public Funcion buscar(Funcion fun) {
		return df.buscarFuncion(fun);
	}
}
