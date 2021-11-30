package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
<<<<<<< HEAD
	
	
	
=======
>>>>>>> a6760af12af7a65bffacfd867909991be141020f
	@Override
	public String toString() {
		DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern(dateTimeFormat);
		
		return "Funcion [codigo_pelicula=" + codigo_pelicula + 
				", fecha_hora=" + fecha_hora + (fecha_hora==null?null:fecha_hora.format(dtFormat))
				+ ", numero_sala=" + numero_sala + "]";
	}
	
	
<<<<<<< HEAD
}
=======
}
>>>>>>> a6760af12af7a65bffacfd867909991be141020f
