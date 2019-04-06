package P1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ciudad {
	private String barrio;
	private static String vecinos;

	private Ciudad(String s) {
		String[] a = s.split(",");
		barrio = a[0];
		vecinos = a[1];
	}

	public static Ciudad create(String s) {
		return new Ciudad(s);
	}
	
	public static Set<String> barriosList(){
		Set<String> barrios = new HashSet<String>();
		String[] a = vecinos.split("-");
		for(int i = 0; i < a.length;i++) {
			barrios.add(a[i]);
		}
		return barrios;
	}


	public String getBarrio() {
		return barrio;
	}

	public String getVecinos() {
		return vecinos;
	}

	


}
