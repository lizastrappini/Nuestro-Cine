package entities;
import java.time.LocalDate;



public class Pelicula {
	private Integer codigo;
	private String nombre;
	private String director;
	private double duracion;
	private String sinopsis;
	private String portada;
	private LocalDate fecha_estreno;
	private Integer codigo_calificacion;
	private Integer id_genero;
	
	
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
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public double getDuracion() {
		return duracion;
	}
	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}
	
	public String getPortada() {
		return portada;
	}
	public void setPortada(String portada) {
		this.portada = portada;
	}
	public LocalDate getFecha_estreno() {
		return fecha_estreno;
	}
	public void setFecha_estreno(LocalDate fecha_estreno) {
		this.fecha_estreno = fecha_estreno;
	}
	public Integer getCodigo_calificacion() {
		return codigo_calificacion;
	}
	public void setCodigo_calificacion(Integer codigo_calificacion) {
		this.codigo_calificacion = codigo_calificacion;
	}
	public Integer getId_genero() {
		return id_genero;
	}
	public void setId_genero(Integer id_genero) {
		this.id_genero = id_genero;
	}
	
	@Override
	public String toString() {
		
		return "Pelicula [codigo=" + codigo + ", nombre=" + nombre + ", director=" + director 
				+ ", duracion=" + duracion + ", sinopsis=" + sinopsis + ", portada="
<<<<<<< HEAD
				+ portada + ", fecha_estreno=" + fecha_estreno  +", id_genero=" 
				+ id_genero + ", codigo_calificacion=" + codigo_calificacion + "+]";
=======
				+ portada + ", fecha_estreno=" + fecha_estreno + ", id_genero=" + id_genero 
				+ ", codigo_calif=" + codigo_calificacion + "]";

>>>>>>> 713ed5035909c711f9a4ebfdea9a9fa279ce79f5
	}
}
