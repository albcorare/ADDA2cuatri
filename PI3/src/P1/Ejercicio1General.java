package P1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import us.lsi.common.Streams2;
import us.lsi.lpsolve.solution.AlgoritmoPLI;
import us.lsi.lpsolve.solution.SolutionPLI;





public class Ejercicio1General {
	
	private static final Integer MAX_INVERSION = 6, VM = 1;
	//lee el fichero y sacas del el una lista de objetos *
	public static void main(String[] args) {
		/* * */List<Ciudad> datos = cargarDatos("./ficheros/Ejercicio1General.txt");
		String def = definirProblema(datos);
		
		SolutionPLI alg = AlgoritmoPLI.getSolution(def);
		System.out.println("El valor resustante: " + alg.getGoal());
		System.out.println("Valor de las variables: " + Arrays.toString(alg.getSolution()));
	}



	private static List<Ciudad> cargarDatos(String f) {
		/* * */return Streams2.fromFile(f).map(Ciudad::create).collect(Collectors.toList());
	}
	//-----------------------------------------------------
	private static String definirProblema(List<Ciudad> datos) {
		String res = defFuncObj(datos);
		res = res + minInver(datos);
		return res + restVbles(datos);
		
		
	}


	private static String restVbles(List<Ciudad> e) { 
		return IntStream.range(0, e.size()).boxed()// ya que da valores int pequeños los boxeamos
				.map(i->"b" +i+ "+"+ e.get(i).getVecinos().replaceAll("-","+") + ">=" + VM)
				.collect(Collectors.joining(";\n", "", ";"));
	}



	private static String minInver(List<Ciudad> e) {
		return IntStream.range(0, e.size()).boxed()// ya que da valores int pequeños los boxeamos
				.map(i-> "b"+ i)
				.collect(Collectors.joining("+", "", "<=" + MAX_INVERSION +";\n"));

	}



	private static String defFuncObj(List<Ciudad> e) {
		return IntStream.range(0, e.size()).boxed()// ya que da valores int pequeños los boxeamos
				.map(i-> "b" + i)
				.collect(Collectors.joining("+", "min:", ";\n"));
	}

}
