package P2;

import java.util.List;
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.alg.tour.HeldKarpTSP;
import org.jgrapht.graph.SimpleWeightedGraph;
import us.lsi.graphs.GraphsReader;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph<Ciudad, Carretera> g = cargarGrafo("./ficheros/Ejemplo.txt");
		Graph<Ciudad, Carretera> g2 = cargarGrafo("./ficheros/Ejemplo.txt");
		g.edgeSet().forEach(a -> g.setEdgeWeight(a, a.getCoste())); // repesar aristas
		g2.edgeSet().forEach(a -> g2.setEdgeWeight(a, a.getTiempo())); // repesar aristas
		apartadoA(g, "Lugar0", "Lugar9");
		apartadoA1(g2,"Lugar0", "Lugar9");
		apartadoA2(g2, "Lugar7", "Lugar0");
		apartadoA21(g2, "Lugar7", "Lugar0");
		apartadoB(g2, "Lugar0");
	}

	private static void apartadoA(Graph<Ciudad, Carretera> g, String o, String d) { // jgraph
		System.out.println("----------------APARTADO A----------------");
		ShortestPathAlgorithm<Ciudad, Carretera> alg = new DijkstraShortestPath<>(g);
		Ciudad from = Ciudad.create(o);
		Ciudad to = Ciudad.create(d);
		GraphPath<Ciudad, Carretera> gp = alg.getPath(from, to);
		System.out.println("Lista de ciudades: " + gp.getVertexList());
		System.out.println("Coste total: " + gp.getWeight()+"€");
	}
	private static void apartadoA1(Graph<Ciudad, Carretera> g, String o, String d) { // jgraph
		ShortestPathAlgorithm<Ciudad, Carretera> alg = new DijkstraShortestPath<>(g);
		Ciudad from = Ciudad.create(o);
		Ciudad to = Ciudad.create(d);
		GraphPath<Ciudad, Carretera> gp = alg.getPath(from, to);
		System.out.println("Lista de ciudades: " + gp.getVertexList());
		System.out.println("Tiempo total: " + gp.getWeight()+" mins");
	}

	private static void apartadoA2(Graph<Ciudad, Carretera> g, String o, String d) { // jgraph
		System.out.println("");
		ShortestPathAlgorithm<Ciudad, Carretera> alg = new DijkstraShortestPath<>(g);
		Ciudad from = Ciudad.create(o);
		Ciudad to = Ciudad.create(d);
		GraphPath<Ciudad, Carretera> gp = alg.getPath(from, to);
		System.out.println("Lista de ciudades: " + gp.getVertexList());
		System.out.println("Coste total: " + gp.getWeight()+"€");
	}
	private static void apartadoA21(Graph<Ciudad, Carretera> g, String o, String d) { // jgraph
		ShortestPathAlgorithm<Ciudad, Carretera> alg = new DijkstraShortestPath<>(g);
		Ciudad from = Ciudad.create(o);
		Ciudad to = Ciudad.create(d);
		GraphPath<Ciudad, Carretera> gp = alg.getPath(from, to);
		System.out.println("Lista de ciudades: " + gp.getVertexList());
		System.out.println("Tiempo total: " + gp.getWeight()+" mins");
	}
	private static void apartadoB(Graph<Ciudad, Carretera> g, String o) { // jgraph
		System.out.println("----------------APARTADO B----------------");
		HeldKarpTSP<Ciudad, Carretera> ciclo = new HeldKarpTSP<>();
		System.out.println( ciclo.getTour(g).getVertexList());
	}
	
	private static void apartadoC(Graph<Ciudad, Carretera> g, String o, List<Ciudad> lista) { // jgraph
		System.out.println("----------------APARTADO B----------------");
		HeldKarpTSP<Ciudad, Carretera> ciclo = new HeldKarpTSP<>();
		System.out.println(ciclo.getTour(g).getVertexList());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	private static void exportarGrafo(Graph<Ciudad, Carretera> g, String nf) { // nf = nombre fichero
//		DOTExporter<Ciudad, Carretera> de = new DOTExporter<Ciudad, Carretera>(new IntegerComponentNameProvider<>(),
//				v -> v.getNombre(), a -> a.getNombre() + " (" + a.getTiempo() + ")");
//
//		PrintWriter pw = Files2.getWriter(nf);
//		de.exportGraph(g, pw);
//
//	}

	private static Graph<Ciudad, Carretera> cargarGrafo(String nombreFichero) { // cargar grafo
		return GraphsReader.newGraph(nombreFichero, Ciudad::create, // primer create para ciudad , el largo
				Carretera::create, // primero para caretera
				() -> new SimpleWeightedGraph<>(Ciudad::create, Carretera::create)); // los creates vacios
	}

}
