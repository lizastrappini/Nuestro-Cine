package logic;

import java.util.LinkedList;

import data.DataPelicula;
import entities.Pelicula;



public class LogicPelicula {
	
	private DataPelicula dpel;
	
	public LogicPelicula() {
		dpel = new DataPelicula();
	}

	public LinkedList<Pelicula>getAll() {
		return dpel.listarPeliculas();
	}	
	
	public LinkedList<Pelicula> buscarPorGenero(String genero) {
		return dpel.buscarPorGenero(genero);
	}	
	
	public LinkedList<Pelicula> buscarPorEdad(String genero) {
		return dpel.buscarPorEdad(genero);
	}	
	
	public LinkedList<Pelicula> buscar(String nombre) {
		return dpel.buscarPorNombre(nombre);
	}
	
	public Pelicula validate(Pelicula p) {
		return dpel.buscarPelicula(p);
	}
	
	public void modificar(Pelicula pel) {
		 dpel.modificar(pel);
	}
	
	public int buscaCodigo(Pelicula pel) {
		return dpel.buscarCodigo(pel);
	}
}