package logic;

import data.DataComentario;
import entities.Comentario;
import java.util.LinkedList;

public class LogicComentario {
	
	private DataComentario dc;
	
	public LogicComentario() {
		dc = new DataComentario();
	}
	
	public void cargar(Comentario com) {
		dc.cargarComentario(com);
	}
	public LinkedList<Comentario> buscarComentarioPorPeli(Comentario com){
		return dc.buscarComentarioPorPeli(com);
	}
}
