package entities;

import java.time.LocalDateTime;
public class Entrada {
	private Integer id_entrada;
	private Integer numero_butaca;
	private Integer nro_sala;
	private Integer cod_pelicula;
	private LocalDateTime fecha_hora_funcion;
	private Double total;
	private String dni;
	
	public Integer getId_entrada() {
		return id_entrada;
	}
	public void setId_entrada(Integer id_entrada) {
		this.id_entrada = id_entrada;
	}
	public Integer getNumero_butaca() {
		return numero_butaca;
	}
	public void setNumero_butaca(Integer numero_butaca) {
		this.numero_butaca = numero_butaca;
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
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
}
