package P1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import us.lsi.ag.ValuesInRangeChromosome;
import us.lsi.ag.ValuesInRangeProblemAG;
import us.lsi.common.Streams2;




public class Ejercicio1AG implements ValuesInRangeProblemAG<Integer, List<Barrio>>{
	
	private List<Barrio> vecinos;
	private Double fit = null;

	public Ejercicio1AG(String f) {
		this.vecinos = cargar(f);
	}
	
	private static List<Barrio> cargar(String f){
		return Streams2.fromFile(f)
				.map(Barrio::create)
				.collect(Collectors.toList());
	}

	@Override
	public Integer getVariableNumber() {
		return vecinos.size();
	}

	@Override
	public Integer getMax(Integer i) {
		return 1;
	}


	@Override
	public Integer getMin(Integer i) {
		return 0;
	}

	public List<Integer> posEstaciones(ValuesInRangeChromosome<Integer> cr){
		List<Integer> lista = cr.decode();
		List<Integer> res = new ArrayList<Integer>();
		for(int i = 0;i<lista.size();i++) {
			if(lista.get(i)==1) {
				res.add(i);
			}
		}
		return res;
	}

	@Override
	public Double fitnessFunction(ValuesInRangeChromosome<Integer> cr) {
		Set<Barrio> barrioC = posEstaciones(cr).stream()
				.flatMap(x-> vecinos.get(x).getVecinos().stream())
						.collect(Collectors.toSet());
		
		barrioC.addAll(posEstaciones(cr).stream()
				.map(x -> vecinos.get(x))
				.collect(Collectors.toSet()));
		
		Integer NC = vecinos.size() - barrioC.size();
		Integer NB = posEstaciones(cr).size();
		fit = -(NC *1000000.0 +NB);
		
		
		return fit;
	}


	@Override
	public List<Barrio> getSolucion(ValuesInRangeChromosome<Integer> cr) {
		List<Integer> lista = cr.decode();
		List<Barrio> res = new ArrayList<Barrio>();
		for(int i =0; i<lista.size(); i++) {
			res.add(vecinos.get(i));
		}
		return res;
	}

}

