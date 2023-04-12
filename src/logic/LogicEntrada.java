package logic;

import data.DataEntrada;
import entities.Entrada;
import entities.Funcion;

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
	public void borrar(Entrada ent) {
		de.borrarEntrada(ent);
	}
	public Entrada buscarPorId(Integer id) {
		return de.buscarEntradaPorId(id);
	}
	public int contarEntradasPorFuncion(Funcion f) {
		return de.contarEntradasPorFuncion(f);
	}
}
