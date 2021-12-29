package entities;

public class Sala {
	private Integer numero;
	private Integer cupo;
	
	@Override
	public String toString() {
		return "Sala[nro_sala="+numero+", cupo="+cupo+"]";
	}
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero=numero;
	}
	public Integer getCupo() {
		return cupo;
	}
	public void setCupo(Integer cupo) {
		this.cupo=cupo;
	}
}