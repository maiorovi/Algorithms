package stanford_course.week_4;

import util.ClasspathResourceReader;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class KargersAlgorithm {
// 2 attempts
	ClasspathResourceReader classpathResourceReader = new ClasspathResourceReader();

	public int findMinCut(UndirectedAdjacencyListBasedGraph graph) {
		int minCut = Integer.MAX_VALUE;
		UndirectedAdjacencyListBasedGraph tmpGraph = new UndirectedAdjacencyListBasedGraph(graph);
		int N = tmpGraph.vertexAmount();
		long cycles = Math.round(Math.pow(N, 2) * Math.log(N));
		System.out.println(cycles);
		for (int i = 0; i < cycles; i++) {
			Random rnd = new Random();

			while (tmpGraph.vertexAmount() > 2) {
				tmpGraph.contractGraph(rnd);
			}
			int edges = tmpGraph.edgesAmount();
			minCut = Math.min(tmpGraph.edgesAmount(), minCut);
			System.out.println("MinCut: " + minCut + " Current min cut: " +  edges);
			tmpGraph = new UndirectedAdjacencyListBasedGraph(graph);
		}

		return minCut;
	}

	public static void main(String[] args) {
		KargersAlgorithm kargersAlgorithm = new KargersAlgorithm();

		UndirectedAdjacencyListBasedGraph graph = kargersAlgorithm.retrieveGraph();

		System.out.println("Min cut: " + kargersAlgorithm.findMinCut(graph));
	}

	public UndirectedAdjacencyListBasedGraph retrieveGraph() {
		UndirectedAdjacencyListBasedGraph graph = new UndirectedAdjacencyListBasedGraph();
		List<String> fileContent = classpathResourceReader.readFileAsString("kargerMinCut.txt");

//		fileContent.forEach(System.out::println);

		fileContent.stream().map(line -> line.split("\\s")[0]).forEach(vert -> graph.addVertex(new Vertex(vert)));

		List<String[]> vertecies = fileContent.stream().map(line -> line.split("\\s")).collect(Collectors.toList());

		for (String[] line : vertecies) {
			String startVert = line[0];
			for (int i = 1; i < line.length; i++) {
				graph.addEdgeBetween(new Edge(new Vertex(startVert), new Vertex(line[i])));
			}
		}

		return graph;
	}
}
