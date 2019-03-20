package P2;

import java.io.PrintWriter;

import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.io.DOTExporter;
import org.jgrapht.io.IntegerComponentNameProvider;
import us.lsi.common.Files2;
import us.lsi.graphs.GraphsReader;

public class Ejercicio2 {
	
	public static void main(String[] args) {
		Graph<Ciudad, Carretera> g = cargarGrafo("./ficheros/Andalucia.txt");
		exportarGrafo(g, "./ficheros/Andalucia.gv");

		System.out.println(g);
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
