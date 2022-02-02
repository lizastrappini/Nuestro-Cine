package logic;

import data.DataCostoEntrada;
import entities.CostoEntrada;

public class LogicCostoEntrada {
private DataCostoEntrada dce;
	
	public LogicCostoEntrada() {
		dce = new DataCostoEntrada();
	}
	
	public void cargar(CostoEntrada ce) {
		dce.cargarCostoEntrada(ce);
	}
	
	public CostoEntrada costoActual() {
		return dce.buscarCostoActual();
	}
}
