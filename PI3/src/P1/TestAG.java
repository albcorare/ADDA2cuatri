package P1;

import java.util.List;

import us.lsi.ag.ValuesInRangeChromosome;
import us.lsi.ag.ValuesInRangeProblemAG;
import us.lsi.ag.agchromosomes.AlgoritmoAG;
import us.lsi.ag.agchromosomes.ChromosomeFactory;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.ag.agchromosomes.ChromosomeFactory.CrossoverType;
import us.lsi.ag.agstopping.StoppingConditionFactory;
import us.lsi.ag.agstopping.StoppingConditionFactory.StoppingConditionType;

public class TestAG {

	public static void main(String[] args) {
		AlgoritmoAG.ELITISM_RATE  = 0.20;
		AlgoritmoAG.CROSSOVER_RATE = 0.8;
		AlgoritmoAG.MUTATION_RATE = 0.8;
		AlgoritmoAG.POPULATION_SIZE = 40;
		
		StoppingConditionFactory.NUM_GENERATIONS = 3000;
		StoppingConditionFactory.SOLUTIONS_NUMBER_MIN = 1;
		StoppingConditionFactory.FITNESS_MIN = 0.;
		StoppingConditionFactory.stoppingConditionType = StoppingConditionType.SolutionsNumber;
		
		ChromosomeFactory.crossoverType = CrossoverType.OnePoint;
		
		
		ValuesInRangeProblemAG<Integer,List<Barrio>> p = new Ejercicio1AG("./ficheros/EjercicioAG.txt");
		AlgoritmoAG<ValuesInRangeChromosome<Integer>> ap = AlgoritmoAG.create(ChromosomeType.Binary, p);
		ap.ejecuta();
		ValuesInRangeChromosome<Integer> cr = ap.getBestChromosome();
		System.out.println("================================");
		System.out.println(cr.decode());
		System.out.println(-cr.fitness());
		System.out.println("================================");

	}

}
