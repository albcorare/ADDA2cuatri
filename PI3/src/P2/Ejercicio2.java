package P2;

import java.util.ArrayList;
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
		Graph<Ciudad, Carretera> g = cargarGrafo("./ficheros/Andalucia.txt");
		Graph<Ciudad, Carretera> g3 = cargarGrafo("./ficheros/Andalucia.txt");
		Graph<Ciudad, Carretera> g2 = cargarGrafo("./ficheros/Andalucia.txt");
		
		Ciudad c1 = new Ciudad("Sevilla");
		Ciudad c2 = new Ciudad("Cadiz");
		Ciudad c3 = new Ciudad("Huelva");
		Ciudad c4 = new Ciudad("Algeciras");
		List<Ciudad> lista = new ArrayList<>();
		lista.add(c1);
		lista.add(c2);
		lista.add(c3);
		lista.add(c4);
		
		
		
		g.edgeSet().forEach(a -> g.setEdgeWeight(a, a.getCoste())); // repesar aristas
		g2.edgeSet().forEach(a -> g2.setEdgeWeight(a, a.getTiempo())); // repesar aristas
		apartadoA(g, "Sevilla", "Algeciras");
		apartadoA1(g2,"Sevilla", "Algeciras");
		apartadoA2(g2, "Granada", "Sevilla");
		apartadoA21(g2, "Granada", "Sevilla");
		apartadoB(g2, "Sevilla");
		
		g3.containsVertex(lista.get(1));
		g3.containsVertex(lista.get(1));
		g3.containsVertex(lista.get(2));
		g3.containsVertex(lista.get(3));
		Ciudad origen = new Ciudad("Sevilla");
		
		System.out.println(apartadoC(lista,g,origen));
		System.out.println(apartadoC2(lista, g, origen));
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
	private static void apartadoB(Graph<Ciudad, Carretera> g, String o) { 
		System.out.println("----------------APARTADO B----------------");
		System.out.println(new HeldKarpTSP().getTour(g));
	}
	
	public static List<Ciudad> apartadoC(List<Ciudad> c, Graph<Ciudad, Carretera> g, Ciudad s) {
		System.out.println("----------------APARTADO C----------------");
		for (Carretera carretera : g.edgeSet()) {
			g.setEdgeWeight(carretera, carretera.getCoste());
		}
		Ciudad origen = Ciudad.create(s.getNombre());
		List<Ciudad> res = new ArrayList<>();
		for (int i = 0; i < c.size(); i++) {
			Ciudad target = c.get(i);
			DijkstraShortestPath<Ciudad, Carretera> d = new DijkstraShortestPath<Ciudad, Carretera>(g);
			res.addAll(d.getPath(origen, target).getVertexList());
			res.remove(target);
			origen = c.get(i);
		}
		Ciudad target = Ciudad.create(s.getNombre());
		DijkstraShortestPath<Ciudad, Carretera> d = new DijkstraShortestPath<Ciudad, Carretera>(g);
		GraphPath<Ciudad, Carretera> path = d.getPath(origen, target);
		res.addAll(path.getVertexList());
		return res;
	}
	

	public static Double apartadoC2(List<Ciudad> c, Graph<Ciudad, Carretera> g, Ciudad s) {
		for (Carretera carretera : g.edgeSet()) {
			g.setEdgeWeight(carretera, carretera.getCoste());
		}
		Double resi = 0.;
		Ciudad origen = Ciudad.create(s.getNombre());
		List<Ciudad> res = new ArrayList<>();
		for (int i = 0; i < c.size(); i++) {
			Ciudad target = c.get(i);
			DijkstraShortestPath<Ciudad, Carretera> d = new DijkstraShortestPath<Ciudad, Carretera>(g);
			res.addAll(d.getPath(origen, target).getVertexList());
			res.remove(target);
			origen = c.get(i);
			resi  += d.getPath(origen,target).getWeight();
		}
		Ciudad target = Ciudad.create(s.getNombre());
		DijkstraShortestPath<Ciudad, Carretera> d = new DijkstraShortestPath<Ciudad, Carretera>(g);
		GraphPath<Ciudad, Carretera> path = d.getPath(origen, target);
		res.addAll(path.getVertexList());
		resi += path.getWeight();
		return resi;
	}
	
	//dkj
	
	
	

	private static Graph<Ciudad, Carretera> cargarGrafo(String nombreFichero) { // cargar grafo
		return GraphsReader.newGraph(nombreFichero, Ciudad::create, // primer create para ciudad , el largo
				Carretera::create, // primero para caretera
				() -> new SimpleWeightedGraph<>(Ciudad::create, Carretera::create)); // los creates vacios
	}

}
