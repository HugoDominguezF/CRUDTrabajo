package clase;

public class Profesor {
	
	int id;
	String nombre;
	String apellido;
	String especialidad;
	String email;
	
	public Profesor(String nombre, String apellido, String especialidad, String email) {
		
		if(nombre != null && !nombre.isBlank()) {
			this.nombre = nombre;
		}

		if(apellido != null && !apellido.isBlank()) {
		this.apellido = apellido;
		}
		
		if(especialidad != null && !especialidad.isBlank()) {
		this.especialidad = especialidad;
		}
		
		if(email != null && !email.isBlank()) {
		this.email = email;
		}
		
	}
	public Profesor(int id,String nombre, String apellido, String especialidad, String email) {
		
		if(id >0) {
			this.id=id;
		}
		
		if(nombre != null && !nombre.isBlank()) {
			this.nombre = nombre;
		}

		if(apellido != null && !apellido.isBlank()) {
		this.apellido = apellido;
		}
		
		if(especialidad != null && !especialidad.isBlank()) {
		this.especialidad = especialidad;
		}
		
		if(email != null && !email.isBlank()) {
		this.email = email;
		}
		
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEspecialidad() {
		return especialidad;
	}
	
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return id+" "+nombre+" "+apellido+" "+especialidad+" "+email;
	}
	
}
