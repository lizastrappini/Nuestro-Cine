package entities;

import java.util.Date;
public class CostoEntrada {
	
	private Date fecha_desde;
	private double costo;
	
	public Date getFecha_desde() {
		return fecha_desde;
	}
	public void setFecha_desde(Date fecha_desde) {
		this.fecha_desde = fecha_desde;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public java.sql.Date convertirFecha(Date fecha) {
		java.util.Date utilDate = fecha;
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    return sqlDate;
	}
	
	@Override
	public String toString() {
		return "Costo_funcion [fecha_desde=" + fecha_desde + ", costo=" + costo + "]";
	}
}
