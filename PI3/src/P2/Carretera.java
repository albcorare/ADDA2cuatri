package P2;

public class Carretera {

	private static int numObjs = 0;
	private Ciudad v1, v2;
	private String nombre;
	private Double tiempo;
	private Double coste;
	private int id;

	public static Carretera create(Ciudad c1, Ciudad c2, String[] tokens) {
		return new Carretera(c1, c2, tokens[2], Double.parseDouble(tokens[3]), Double.parseDouble(tokens[4]));
	}

	public static Carretera create() {
		return new Carretera(null, null, "", null, null);
	}

	public Carretera(Ciudad v1, Ciudad v2, String nombre, Double tiempo, Double coste) {
		super();
		this.v1 = v1;
		this.v2 = v2;
		this.nombre = nombre;
		this.tiempo = tiempo;
		this.coste = coste;
		id = ++numObjs;
	}

	public Ciudad getV1() {
		return v1;
	}

	public Ciudad getV2() {
		return v2;
	}

	public String getNombre() {
		return nombre;
	}

	public Double getTiempo() {
		return tiempo;
	}

	public Double getCoste() {
		return coste;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Carretera other = (Carretera) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getNombre() + "(" + getTiempo() + " minutos)" + "(" + getCoste() + " euros)";
	}

}
