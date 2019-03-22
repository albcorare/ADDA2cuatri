package P2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
import org.jgrapht.alg.tour.HeldKarpTSP;
import org.jgrapht.graph.SimpleWeightedGraph;
import us.lsi.graphs.GraphsReader;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph<Ciudad, Carretera> g = cargarGrafo("./ficheros/Ejemplo.txt");
		Graph<Ciudad, Carretera> g2 = cargarGrafo("./ficheros/Ejemplo.txt");
		Graph<Ciudad, Carretera> g3 = cargarGrafo("./ficheros/Ejemplo.txt");
		g.edgeSet().forEach(a -> g.setEdgeWeight(a, a.getCoste())); // repesar aristas
		g2.edgeSet().forEach(a -> g2.setEdgeWeight(a, a.getTiempo())); // repesar aristas
		
		Ciudad c1 = new Ciudad("Lugar0");
		Ciudad c2 = new Ciudad("Lugar1");
		Ciudad c3 = new Ciudad("Lugar2");
		Ciudad c4 = new Ciudad("Lugar9");
		Set<Ciudad> ciudades = new HashSet<>();
		ciudades.add(c1);
		ciudades.add(c2);
		ciudades.add(c3);
		ciudades.add(c4);
	
		
		
		apartadoA(g, "Lugar0", "Lugar9");
		apartadoA1(g2,"Lugar0", "Lugar9");
		apartadoA2(g2, "Lugar7", "Lugar0");
		apartadoA21(g2, "Lugar7", "Lugar0");
		apartadoB(g3, "Lugar0");
		apartadoC(g, ciudades);
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
	
	private static void apartadoC(Graph<Ciudad, Carretera> g, Set<Ciudad> ciudades) {
		System.out.println("----------------APARTADO C----------------");
		List<Ciudad> borrar = new ArrayList<>();
		Set<Carretera> res = new HashSet<>();
		Graph<Ciudad, Carretera> grafo = new SimpleWeightedGraph<>(Carretera.class);
		for(Ciudad c: g.vertexSet()) {
			if(!ciudades.contains(c)) {
				ciudades.remove(c);
			}else {
				grafo.addVertex(c);
			}
		}	

		System.out.println(grafo);
	}
		
		
		
		
//		for (Ciudad c : g.vertexSet()) {
//			if (!ciudades.contains(c)) {
//				borrar.add(c);
//			}
//		}
//		g.removeAllVertices(borrar);
//		ConnectivityInspector<Ciudad, Carretera> co = new ConnectivityInspector<>(g);
//		if (co.isConnected()) {
//			KruskalMinimumSpanningTree<Ciudad, Carretera> k = new KruskalMinimumSpanningTree<>(g);
//			res=  k.getSpanningTree().getEdges();
//		} else {
//			res= new HashSet<>();
//		}
//		System.out.println(res);


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

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
