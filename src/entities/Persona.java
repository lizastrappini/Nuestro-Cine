package entities;

public class Persona {
	private String dni;
	private String nombre;
	private String apellido;
	private String email;
<<<<<<< HEAD:src/entities/Persona.java
	private String password;
=======
	private String contrasena;
>>>>>>> a6760af12af7a65bffacfd867909991be141020f:src/entities/Cliente.java
	private Integer edad;
	private String telefono;
	private Integer habilitado;
	
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
<<<<<<< HEAD:src/entities/Persona.java
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
=======
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
>>>>>>> a6760af12af7a65bffacfd867909991be141020f:src/entities/Cliente.java
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", password=" + password + ", edad=" + edad + ", telefono=" + telefono + "]";
	}
	public Integer getHabilitado() {
		return habilitado;
	}
	public void setHabilitado(Integer habilitado) {
		this.habilitado = habilitado;
	}
	
	
	
	

}
