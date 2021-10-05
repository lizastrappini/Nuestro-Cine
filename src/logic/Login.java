package logic;

import entities.*;


import data.DataCliente;

import java.util.LinkedList;

public class Login {
	
	private DataCliente dp;
	
	
	public Login() {
		dp = new DataCliente();
		
	}
	public LinkedList<Cliente>getAll() {
		return dp.getAll();
	}
	public Cliente validate(Cliente cli) {
		return dp.getByUser(cli);
	}
	//public Cliente getByDocumento(Cliente cli) {
		//return dp.getByDocumento(cli);
	//}
	public LinkedList<Cliente> search(Cliente cli) {
		return dp.search(cli);
	}
	
	public Cliente newCli(Cliente cli) {
		return dp.add(cli);
	}
	//public void edit(Cliente cli) {
	//	dp.edit(cli);
	//}
	//public void delete(Cliente cli) {
		//dp.delete(cli);
	//}
	
}

