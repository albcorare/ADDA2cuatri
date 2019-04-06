package P1;

import java.util.ArrayList;
import java.util.List;

public class Barrio {
	
	private String barrio;
	private List<Barrio> vecinos;
	
	
	public Barrio(String barrio, List<Barrio> vecinos) {
		super();
		this.barrio = barrio;
		this.vecinos = vecinos;
	}
	
	public static Barrio create(String a) {
		return new Barrio(a);
	}
	
	private Barrio(String a) {
		String[] t = a.split(",");
		this.barrio = t[0];
		List<Barrio> vecinos = new ArrayList<Barrio>();
		for(int i = 1; i<t.length;i++) {
			Barrio barrioVec = new Barrio(t[i], new ArrayList<Barrio>());
			vecinos.add(barrioVec);
		}
		this.vecinos = vecinos;
	}
	
	public String getBarrio() {
		return barrio;
	}
	public List<Barrio> getVecinos() {
		return vecinos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barrio == null) ? 0 : barrio.hashCode());
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
		Barrio other = (Barrio) obj;
		if (barrio == null) {
			if (other.barrio != null)
				return false;
		} else if (!barrio.equals(other.barrio))
			return false;
		return true;
	}


	

}
