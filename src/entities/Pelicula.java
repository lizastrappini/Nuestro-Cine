package entities;
import java.util.Date;

public class Pelicula {
	private Integer codigo;
	private String nombre;
	private String director;
	private String genero;
	private String calificacion;
	private double duracion;
	private String sinopsis;
	private String portada;
	private Date fecha_estreno;
	
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	
	public double getDuracion() {
		return duracion;
	}
	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public String getPortada() {
		return portada;
	}
	public void setPortada(String portada) {
		this.portada = portada;
	}
	public Date getFecha_estreno() {
		return fecha_estreno;
	}
	public void setFecha_estreno(Date fecha_estreno) {
		this.fecha_estreno = fecha_estreno;
	}
	@Override
	public String toString() {
		return "Pelicula [codigo=" + codigo + ", nombre=" + nombre + ", director=" + director + ", genero=" + genero
				+ ", calificacion=" + calificacion + ", duracion=" + duracion + ", sinopsis=" + sinopsis + ", portada="
				+ portada + ", fecha_estreno=" + fecha_estreno + "]";
	}
	
	
}
