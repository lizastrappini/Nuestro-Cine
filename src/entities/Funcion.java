package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import logic.LogicFuncion;
import logic.LogicPelicula;

import java.util.LinkedList;
public class Funcion {
	
	private String dateFormat = "dd/MM/yyyy";
	private String timeFormat = "HH:mm:ss";
	private String dateTimeFormat = dateFormat + " " + timeFormat;
	
	private Integer codigo_pelicula;
	private LocalDateTime fecha_hora;
	private Integer numero_sala;
	
	public Integer getCodigo_pelicula() {
		return codigo_pelicula;
	}
	public void setCodigo_pelicula(Integer codigo_pelicula) {
		this.codigo_pelicula = codigo_pelicula;
	}
	public LocalDateTime getFecha_hora() {
		return fecha_hora;
	}	
	public void setFecha_hora(LocalDateTime fecha_hora) {
		this.fecha_hora = fecha_hora;
	}
	public Integer getNumero_sala() {
		return numero_sala;
	}
	public void setNumero_sala(Integer numero_sala) {
		this.numero_sala = numero_sala;
	}		
	@Override
	public String toString() {
		DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern(dateTimeFormat);
		
		return "Funcion [codigo_pelicula=" + codigo_pelicula + 
				", fecha_hora=" + fecha_hora + (fecha_hora==null?null:fecha_hora.format(dtFormat))
				+ ", numero_sala=" + numero_sala + "]";
	}
	public Boolean validarFuncion(Funcion fun) {
		LogicFuncion lf = new LogicFuncion();
		LinkedList<Funcion>funciones = lf.listar();

		LogicPelicula lp = new LogicPelicula();
		Pelicula pel = new Pelicula();

		for (Funcion f: funciones) {
			if (f.getNumero_sala()==fun.getNumero_sala()) {
				LocalDateTime fh_inicio1 = fun.getFecha_hora();
				pel = lp.buscarPorCodigo(fun.getCodigo_pelicula());
				LocalDateTime fh_fin1 = fun.getFecha_hora().plusMinutes((long)pel.getDuracion());
				 
				LocalDateTime fh_inicio2 = f.getFecha_hora();
				pel = lp.buscarPorCodigo(f.getCodigo_pelicula());
				LocalDateTime fh_fin2 = f.getFecha_hora().plusMinutes((long)pel.getDuracion());

				if (fun.getFecha_hora().equals(f.getFecha_hora())) {
					return false;
				}
				if ( fh_inicio2.isBefore(fh_inicio1) && fh_fin2.isAfter(fh_inicio1) ) {
					return false;
				}

				if ( fh_inicio2.isBefore(fh_fin1) && fh_fin2.isAfter(fh_fin1) ) {
					return false;
				}
			}
		}

		return true;
	}
}

