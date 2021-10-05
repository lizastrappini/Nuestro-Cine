package entities;


import java.io.InputStream;
//import java.sql.Blob;

public class Pelicula {
	private Integer codigo;
	private String nombre;
	private String director;
	private String genero;
	private String calificacion;
	private double duracion;
	private String sinopsis;
	//private Blob portada;
	InputStream Foto_Usu;
    private byte[] Recuperar_Foto_Usu;
    private String Recuperar_Foto_Base64_Usu;

    public String getRecuperar_Foto_Base64_Usu() {
        return Recuperar_Foto_Base64_Usu;
    }

    public void setRecuperar_Foto_Base64_Usu(String Recuperar_Foto_Base64_Usu) {
        this.Recuperar_Foto_Base64_Usu = Recuperar_Foto_Base64_Usu;
    }

    public byte[] getRecuperar_Foto_Usu() {
        return Recuperar_Foto_Usu;
    }

    public void setRecuperar_Foto_Usu(byte[] Recuperar_Foto_Usu) {
        this.Recuperar_Foto_Usu = Recuperar_Foto_Usu;
    }
    public InputStream getFoto_Usu() {
        return Foto_Usu;
    }

    public void setFoto_Usu(InputStream Foto_Usu) {
        this.Foto_Usu = Foto_Usu;
    }

	
	@Override
	public String toString() {
		return "Pelicula[codigo="+codigo+",nombre="+nombre+",director="+director+",genero="+genero+",calificacion="+calificacion+
				",duracion="+duracion+",calificacion="+calificacion+",sinopsis="+sinopsis+"]";
	}
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
	//public Blob getPortada() {
		//return portada;
	//}
	
	//public void setPortada(Blob portada) {
	//	this.portada=portada;
	//}
	
	
}
