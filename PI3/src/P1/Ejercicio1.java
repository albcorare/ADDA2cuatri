package P1;

import java.util.Arrays;

import us.lsi.lpsolve.solution.AlgoritmoPLI;
import us.lsi.lpsolve.solution.SolutionPLI;

public class Ejercicio1 {
	
	public static void main(String[] args) {
		SolutionPLI alg = AlgoritmoPLI.getSolutionFromFile("./ficheros/Ejercicio1.txt");
		System.out.println("El valor resustante: " + alg.getGoal());
		System.out.println("Valor de las variables: " + Arrays.toString(alg.getSolution()));
	}
}
