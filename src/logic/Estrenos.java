package logic;

import java.util.LinkedList;

import data.DataPelicula;
import entities.Pelicula;

public class Estrenos {
	private DataPelicula dp;
	

	
	public LinkedList<Pelicula>getAll() {
		return dp.listarPeliculas();
	}	


}
