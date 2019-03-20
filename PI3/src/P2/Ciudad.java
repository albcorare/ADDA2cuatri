package P2;

public class Ciudad {
	private String nombre;
	
	public static Ciudad create(String [] tokens) {
		return new Ciudad(tokens[0]);
	}
	public static Ciudad create() {
		return new Ciudad("");
	}
	public static Ciudad create(String nombre) {
		return new Ciudad(nombre);
	}
	public Ciudad(String nombre) {
		super();
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ciudad other = (Ciudad) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return getNombre();
	}
	

}
