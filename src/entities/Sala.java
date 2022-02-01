package entities;

public class Sala {
	private Integer numero;
	
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
}