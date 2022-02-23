package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ButacaFuncion {
	
	private String dateFormat = "dd/MM/yyyy";
	private String timeFormat = "HH:mm:ss";
	private String dateTimeFormat = dateFormat + " " + timeFormat;
	
	private Integer numero;
	private Integer nro_sala;
	private Integer cod_pelicula;
	private LocalDateTime fecha_hora_funcion;
	private Integer estado;
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Integer getNro_sala() {
		return nro_sala;
	}
	public void setNro_sala(Integer nro_sala) {
		this.nro_sala = nro_sala;
	}
	public Integer getCod_pelicula() {
		return cod_pelicula;
	}
	public void setCod_pelicula(Integer cod_pelicula) {
		this.cod_pelicula = cod_pelicula;
	}
	public LocalDateTime getFecha_hora_funcion() {
		return fecha_hora_funcion;
	}
	public void setFecha_hora_funcion(LocalDateTime fecha_hora_funcion) {
		this.fecha_hora_funcion = fecha_hora_funcion;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern(dateTimeFormat);
		
		return "Butaca_funcion [numero=" + numero + ", nro_sala=" + nro_sala + ", cod_pelicula=" + cod_pelicula
				+ ", fecha_hora_funcion=" + fecha_hora_funcion + 
				(fecha_hora_funcion==null?null:fecha_hora_funcion.format(dtFormat)) + ", estado=" + estado + "]";
	}
	
}
