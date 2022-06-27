package entities;
import java.time.LocalDate;
import java.time.LocalTime;

public class Compra {
	private LocalDate fecha;
	private Double total;
	private Integer cantidad;
	private LocalTime hora;
	private String nombre;
	
	
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Compra [fecha=" + fecha + ", total=" + total + ", cantidad=" + cantidad + ", hora=" + hora + ", nombre="
				+ nombre + "]";
	}

	
}
