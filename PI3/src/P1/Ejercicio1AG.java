package P1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import us.lsi.ag.IndexChromosome;
import us.lsi.ag.agchromosomes.*;
import us.lsi.ag.agchromosomes.BinaryChromosome;
import P1.Ciudad;


public class Ejercicio1AG {
	
	public static List<Ciudad> ciudades;

	public Integer getObjectsNumber() {
		return ciudades.size();
	}


	public Double fitnessFunction(List<Integer> ls) {
		Set<Ciudad> s = ls.stream()
				.flatMap(x ->ciudades.get(x).barriosList().stream())
				.collect(Collectors.toSet());
		s.add((Ciudad) ls.stream()
				.map(x -> ciudades.get(x))
				.collect(Collectors.toSet()));
		Double NC = (double)(ciudades.size()-s.size());
		Double NB = (double)ls.size();
		return -(NC * 1000000.0 + NB);
	}

	public List<Ciudad> getSolucion(BinaryChromosome cr) {		
		return cr.decode().stream()
			.map(x -> ciudades.get(x))
			.collect(Collectors.toList());
	}

}

