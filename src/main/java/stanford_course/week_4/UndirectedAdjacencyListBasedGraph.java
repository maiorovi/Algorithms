package stanford_course.week_4;

import com.google.common.base.Preconditions;
import org.assertj.core.util.Lists;

import java.util.*;
import java.util.stream.Collectors;

public class UndirectedAdjacencyListBasedGraph implements Graph {
	private Map<Vertex, List<Edge>> adjacencyList;

	public UndirectedAdjacencyListBasedGraph() {
		adjacencyList = new LinkedHashMap<>();
	}

	public UndirectedAdjacencyListBasedGraph(UndirectedAdjacencyListBasedGraph graph) {
		adjacencyList = new LinkedHashMap<>(graph.adjacencyList);
	}

	public void addVertex(Vertex vertex) {
		Preconditions.checkNotNull(vertex, "vertex can`t be null");

		adjacencyList.put(vertex, Lists.newArrayList());
	}

	public void addEdgeBetween(Edge edge) {
		Vertex fstVertex = edge.getFirstVertex();
		Vertex sndVertex = edge.getSecondVertex();

		Preconditions.checkState(adjacencyList.containsKey(fstVertex) && adjacencyList.containsKey(sndVertex), "Both verteces should be in graph");

		adjacencyList.get(fstVertex).add(edge);
//		adjacencyList.get(sndVertex).add(edge.flipEdge());
	}

	public int vertexAmount() {
		return adjacencyList.size();
	}


	public List<Vertex> adjacentVertexes(Vertex x) {
		return adjacencyList.get(x).stream().map(edge -> edge.getSecondVertex()).collect(Collectors.toList());
	}

	public void contractGraph(Random rnd) {
		Edge randomlyChoosenEdge = randomEdge(rnd);
		Vertex fst = randomlyChoosenEdge.getFirstVertex();
		Vertex snd = randomlyChoosenEdge.getSecondVertex();

		List<Edge> sndEdges = adjacencyList.get(snd);
		List<Edge> fstEdges = adjacencyList.get(fst);
		//remove all edges to fst from snd
		updateAdjListWithNewPointers(sndEdges, snd, fst);
		//remove snd from fst adjList
		//merge snd adj list ot fst adj list
		adjacencyList.put(fst, moveAllEdgesToGivenVertex(sndEdges, fst));
		removeSelfLoops(fst);

		//remove sndVertex
		adjacencyList.remove(snd);
	}

	private void removeSelfLoops(Vertex fst) {
		adjacencyList.put(fst,
							adjacencyList.get(fst).stream().filter(edge -> !edge.getSecondVertex().equals(edge.getFirstVertex())).collect(Collectors.toList())
		);
	}

	protected List<Edge> moveAllEdgesToGivenVertex(List<Edge> edgesWithOutFstVertex, Vertex fst) {
		final List<Edge>  edges =  adjacencyList.get(fst);

		edgesWithOutFstVertex.forEach(edge -> edges.add(new Edge(fst, edge.getSecondVertex())));

		return edges;
	}

	protected void updateAdjListWithNewPointers(List<Edge> edgesForUpdate, Vertex vertexOld, Vertex vertexNew) {
		edgesForUpdate.forEach(edge -> {
			Vertex other = edge.other(vertexOld);
			List<Edge> edges = adjacencyList.get(other);
			adjacencyList.put(other, updateAllEdgesWithSpecifiedVertexToNewOne(edges, vertexOld, vertexNew, other));
		});
	}

	protected List<Edge> updateAllEdgesWithSpecifiedVertexToNewOne(List<Edge> edges, Vertex vertexOld, Vertex vertexNew, Vertex start) {
		return edges.stream().map(edge -> {
			if (edge.connectedTo(vertexOld)) {
				return new Edge(start, vertexNew);
			} else {
				return edge;
			}
		}).collect(Collectors.toList());
	}

	protected List<Edge> removeVertexFrom(List<Edge> edgesToMerge, Vertex vertexToRemove, Vertex fromVertex) {
		return edgesToMerge.stream().filter(edge -> edge.other(fromVertex) != vertexToRemove).collect(Collectors.toList());
	}

	protected Edge randomEdge(Random prg) {
		int index = Math.abs(prg.nextInt()) % (2 * edgesAmount());

		return adjacencyList.values().stream().flatMap(x -> x.stream()).collect(Collectors.toList()).get(index);
	}

	public List<Edge> edges() {
		return adjacencyList.values().stream().flatMap(x -> x.stream()).collect(Collectors.toList());
	}

	public int edgesAmount() {
		return adjacencyList.entrySet().stream().map(entry -> entry.getValue().size()).reduce(0, (x, y) -> x + y) / 2;
	}
}
