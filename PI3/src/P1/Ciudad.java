package P1;

public class Ciudad {
	private String barrio;
	private String vecinos;

	private Ciudad(String s) {
		String[] a = s.split(",");
		barrio = a[0];
		vecinos = a[1];
	}

	public static Ciudad create(String s) {
		return new Ciudad(s);
	}

//	public static List<String> listaVecinos(String s) {
//		Integer i = 0;
//		List<String> lista = new ArrayList<>();
//		String[] a = s.split("-");
//		for (i = 0; i < a.length; i++) {
//			lista.add(a[i]);
//		}
//		return lista;
//
//	}

	public String getBarrio() {
		return barrio;
	}

	public String getVecinos() {
		return vecinos;
	}
	//---------------------------------------------------------
//	private static String restVbles(String n) {
//		Integer i = 0;
//		String res = "";
//		String[] a = n.split("-");
//		for(i=0; i<a.length;i++) {
//			
//			res = res + a[i];
//		}
//		return res;
//	}
//	
//	public static void main(String[] args) {
//		String n = "a-d-s";
//		System.out.println(restVbles(n));
//	}
//	

}
