package logic;

import entities.*;


import data.DataPersona;

import java.util.LinkedList;

public class Login {
	
	private DataPersona dp;
	
	public Login() {
		dp = new DataPersona();
		
	}
	public LinkedList<Persona>getAll() {
		return dp.getAll();
	}
	
	public Persona validate(Persona p) {
		return dp.getByUser(p);
	}

	public Persona search(Persona per) {
		return dp.search(per);
	}
	
	public Persona newCli(Persona per) {
		return dp.add(per);
	}

	
	public String buscarNombre(Persona per) {
		return dp.buscaNombre(per);
	}
	
	public String buscarPorDni(Persona per) {
		return dp.buscarPorDni(per);
	}
	
	public String buscarPorMail(Persona per) {
		return dp.buscarPorMail(per);
	}
	
	
	public String obtenerPass(Persona per) {
		return dp.obtenerPass(per);
	}
	
	public void actualizarPass(Persona per) {
		dp.editPass(per);
	}
	
}

