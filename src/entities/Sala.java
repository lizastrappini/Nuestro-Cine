package entities;

public class Sala {
	private Integer numero;
	private String descripcion;
	
	@Override
	public String toString() {
		return "Sala[nro_sala="+numero+"]";
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero=numero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}