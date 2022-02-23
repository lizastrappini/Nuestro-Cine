package logic;

import java.util.LinkedList;

import data.DataGenero;
import entities.Genero;

public class LogicGenero {
	private DataGenero dgen;
	
	public LogicGenero() {
		dgen = new DataGenero();
	}
	
	public void cargar(Genero g) {
		dgen.cargarGenero(g);
	}
	
	public void editar(Genero g) {
		dgen.modificar(g);
	}
	
	public LinkedList<Genero> getAll(){
		return dgen.listarGeneros();
	}
	
	public Genero buscar(Genero g) {
		return dgen.buscarGenero(g);
	}
	
	public void borrar(Genero g) {
		dgen.borrarGenero(g);
	}
}

