package entities;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
public class Costo_funcion {
	private String dateFormat = "dd/MM/yyyy";
	private String timeFormat = "HH:mm:ss";
	private String dateTimeFormat = dateFormat + " " + timeFormat;
	
	private Integer cod_pelicula;
	private LocalDate fecha_actualizacion;
	private double costo;
	private LocalDateTime fecha_hora_fun;
	private Integer nro_sala;
	public String getDateFormat() {
		return dateFormat;
	}
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	public String getTimeFormat() {
		return timeFormat;
	}
	public void setTimeFormat(String timeFormat) {
		this.timeFormat = timeFormat;
	}
	public String getDateTimeFormat() {
		return dateTimeFormat;
	}
	public void setDateTimeFormat(String dateTimeFormat) {
		this.dateTimeFormat = dateTimeFormat;
	}
	public Integer getCod_pelicula() {
		return cod_pelicula;
	}
	public void setCod_pelicula(Integer cod_pelicula) {
		this.cod_pelicula = cod_pelicula;
	}
	public LocalDate getFecha_actualizacion() {
		return fecha_actualizacion;
	}
	public void setFecha_actualizacion(LocalDate fecha_actualizacion) {
		this.fecha_actualizacion = fecha_actualizacion;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public LocalDateTime getFecha_hora_fun() {
		return fecha_hora_fun;
	}
	public void setFecha_hora_fun(LocalDateTime fecha_hora_fun) {
		this.fecha_hora_fun = fecha_hora_fun;
	}
	public Integer getNro_sala() {
		return nro_sala;
	}
	public void setNro_sala(Integer nro_sala) {
		this.nro_sala = nro_sala;
	}
	@Override
	public String toString() {
		DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern(dateTimeFormat);
		
		return "Costo_funcion [cod_pelicula=" + cod_pelicula + ", fecha_actualizacion=" + fecha_actualizacion
				+ ", costo=" + costo + ", fecha_hora_fun=" + 
				fecha_hora_fun + (fecha_hora_fun==null?null:fecha_hora_fun.format(dtFormat)) + ", nro_sala=" + nro_sala + "]";
	}

}
