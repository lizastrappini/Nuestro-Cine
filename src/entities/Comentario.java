package entities;

import java.time.LocalDateTime;

public class Comentario {
	
	private Integer id_comentario;
	private String comentario;
	private String dni;
	private Integer codigo_pel;
	private LocalDateTime fecha_hora;
	
	public Integer getId_comentario() {
		return id_comentario;
	}
	public void setId_comentario(Integer id_comentario) {
		this.id_comentario = id_comentario;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Integer getCodigo_pel() {
		return codigo_pel;
	}
	public void setCodigo_pel(Integer codigo_pel) {
		this.codigo_pel = codigo_pel;
	}
	public LocalDateTime getFecha_hora() {
		return fecha_hora;
	}
	public void setFecha_hora(LocalDateTime fecha_hora) {
		this.fecha_hora = fecha_hora;
	}
}
