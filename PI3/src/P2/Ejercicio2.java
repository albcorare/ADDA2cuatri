package P2;

import java.io.PrintWriter;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.io.DOTExporter;
import org.jgrapht.io.IntegerComponentNameProvider;
import us.lsi.common.Files2;
import us.lsi.graphs.GraphsReader;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph<Ciudad, Carretera> g = cargarGrafo("./ficheros/Andalucia.txt");
		Graph<Ciudad, Carretera> g2 = cargarGrafo("./ficheros/Andalucia.txt");
		g.edgeSet().forEach(a -> g.setEdgeWeight(a, a.getCoste())); // repesar aristas
		g2.edgeSet().forEach(a -> g2.setEdgeWeight(a, a.getTiempo())); // repesar aristas
		apartadoA(g, "Huelva", "Almeria");
		apartadoA2(g2, "Huelva", "Almeria");
	}

	private static void apartadoA(Graph<Ciudad, Carretera> g, String o, String d) { // jgraph
		System.out.println("----------------APARTADO A----------------");
		ShortestPathAlgorithm<Ciudad, Carretera> alg = new DijkstraShortestPath<>(g);
		Ciudad from = Ciudad.create(o);
		Ciudad to = Ciudad.create(d);
		GraphPath<Ciudad, Carretera> gp = alg.getPath(from, to);
		System.out.println("Lista de ciudades: " + gp.getVertexList());
		System.out.println("Coste total: " + gp.getWeight());
		System.out.println("Numero de carreteras: " + gp.getLength());
	}

	private static void apartadoA2(Graph<Ciudad, Carretera> g, String o, String d) { // jgraph
		System.out.println("----------------APARTADO A2----------------");
		ShortestPathAlgorithm<Ciudad, Carretera> alg = new DijkstraShortestPath<>(g);
		Ciudad from = Ciudad.create(o);
		Ciudad to = Ciudad.create(d);
		GraphPath<Ciudad, Carretera> gp = alg.getPath(from, to);
		System.out.println("Lista de ciudades: " + gp.getVertexList());
		System.out.println("Coste total: " + gp.getWeight());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	private static void exportarGrafo(Graph<Ciudad, Carretera> g, String nf) { // nf = nombre fichero
		DOTExporter<Ciudad, Carretera> de = new DOTExporter<Ciudad, Carretera>(new IntegerComponentNameProvider<>(),
				v -> v.getNombre(), a -> a.getNombre() + " (" + a.getTiempo() + ")");

		PrintWriter pw = Files2.getWriter(nf);
		de.exportGraph(g, pw);

	}

	private static Graph<Ciudad, Carretera> cargarGrafo(String nombreFichero) { // cargar grafo
		return GraphsReader.newGraph(nombreFichero, Ciudad::create, // primer create para ciudad , el largo
				Carretera::create, // primero para caretera
				() -> new SimpleWeightedGraph<>(Ciudad::create, Carretera::create)); // los creates vacios
	}

}
