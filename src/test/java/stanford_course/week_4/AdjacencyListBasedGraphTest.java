package stanford_course.week_4;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdjacencyListBasedGraphTest {

	private UndirectedAdjacencyListBasedGraph adjacencyListBasedGraph;
	private Vertex vertex;
	private Edge edge;

	@Before
	public void setUp() throws Exception {
		adjacencyListBasedGraph = new UndirectedAdjacencyListBasedGraph();
		vertex = mock(Vertex.class);
		edge = mock(Edge.class);
	}

	@Test(expected = NullPointerException.class)
	public void throwsIllegalArgumentExceptionOnNullVertexInput() throws Exception {
		adjacencyListBasedGraph.addVertex(null);
	}

	@Test
	public void returnsAmountOfVertexesOfGraphAsAList() throws Exception {
		Vertex anOtherVertex = mock(Vertex.class);

		adjacencyListBasedGraph.addVertex(vertex);
		adjacencyListBasedGraph.addVertex(anOtherVertex);

		assertThat(adjacencyListBasedGraph.vertexAmount()).isEqualTo(2);
	}

	@Test
	public void givesAdjacentVertexesToProvidedVertex() throws Exception {
		Vertex vertex = mock(Vertex.class);
		Vertex otherVertex = mock(Vertex.class);
		Edge edge = mock(Edge.class);

		when(edge.getFirstVertex()).thenReturn(vertex);
		when(edge.getSecondVertex()).thenReturn(otherVertex);

		adjacencyListBasedGraph.addVertex(vertex);
		adjacencyListBasedGraph.addVertex(otherVertex);
		adjacencyListBasedGraph.addEdgeBetween(edge);

		assertThat(adjacencyListBasedGraph.adjacentVertexes(vertex))
			.hasSize(1)
			.containsExactly(otherVertex);
	}

	@Test
	public void calculateEdgesAmount() throws Exception {
		Vertex vertex = mock(Vertex.class);
		Vertex otherVertex = mock(Vertex.class);
		Edge edge = mock(Edge.class);
		Edge edge1 = mock(Edge.class);

		when(edge.getFirstVertex()).thenReturn(vertex);
		when(edge.getSecondVertex()).thenReturn(otherVertex);
		when(edge1.getFirstVertex()).thenReturn(vertex);
		when(edge1.getSecondVertex()).thenReturn(otherVertex);

		adjacencyListBasedGraph.addVertex(vertex);
		adjacencyListBasedGraph.addVertex(otherVertex);
		adjacencyListBasedGraph.addEdgeBetween(edge);
		adjacencyListBasedGraph.addEdgeBetween(edge1);

		assertThat(adjacencyListBasedGraph.edgesAmount()).isEqualTo(2);
	}

	@Test
	public void contractsGraphWithUniformlyChoosenEdge() throws Exception {

	}

	@Test
	public void selectsEdgeRandomly() throws Exception {
		Vertex vertex = mock(Vertex.class);
		Vertex otherVertex = mock(Vertex.class);
		Edge edge = mock(Edge.class);
		Edge edge1 = mock(Edge.class);
		Random random = mock(Random.class);

		when(edge.flipEdge()).thenReturn(edge);
		when(edge1.flipEdge()).thenReturn(edge1);
		when(random.nextInt()).thenReturn(1);
		when(edge.getFirstVertex()).thenReturn(vertex);
		when(edge.getSecondVertex()).thenReturn(otherVertex);
		when(edge1.getFirstVertex()).thenReturn(vertex);
		when(edge1.getSecondVertex()).thenReturn(otherVertex);

		adjacencyListBasedGraph.addVertex(vertex);
		adjacencyListBasedGraph.addVertex(otherVertex);
		adjacencyListBasedGraph.addEdgeBetween(edge);
		adjacencyListBasedGraph.addEdgeBetween(edge1);

		assertThat(adjacencyListBasedGraph.randomEdge(random)).isEqualTo(edge1);
	}

	@Test
	public void removesEdgesToVertexFromGivenList() throws Exception {
		Edge edge1 = mock(Edge.class);
		Edge edge2 = mock(Edge.class);
		Edge edge3 = mock(Edge.class);

		List list = Lists.newArrayList(edge1, edge2, edge3);
		Vertex vertexToRemove = mock(Vertex.class);
		Vertex vertexFrom = mock(Vertex.class);
		Vertex otherVertex = mock(Vertex.class);

		when(edge1.other(vertexFrom)).thenReturn(otherVertex);
		when(edge2.other(vertexFrom)).thenReturn(vertexToRemove);
		when(edge3.other(vertexFrom)).thenReturn(vertexToRemove);

		List<Edge> result = adjacencyListBasedGraph.removeVertexFrom(list, vertexToRemove, vertexFrom);

		assertThat(result)
				.hasSize(1)
				.containsExactly(edge1);
	}

	@Test
	public void movesAllEdgesToGivenVertex() throws Exception {
		UndirectedAdjacencyListBasedGraph graph = setUpGraph();
		Random rnd = mock(Random.class);
		when(rnd.nextInt()).thenReturn(2);

		graph.contractGraph(rnd);
	}

	private UndirectedAdjacencyListBasedGraph setUpGraph() {
		Vertex v = new Vertex("v");
		Vertex v1 = new Vertex("v1");
		Vertex v2 = new Vertex("v2");
		Vertex v3 = new Vertex("v3");

		Edge e1 = new Edge(v, v1);
		Edge e2 = new Edge(v, v2);
		Edge e3 = new Edge(v1, v3);
		Edge e4 = new Edge(v2, v3);
		Edge e5 = new Edge(v,v3);
		Edge e6 = new Edge(v2, v1);

		UndirectedAdjacencyListBasedGraph  graph = new UndirectedAdjacencyListBasedGraph();

		graph.addVertex(v);
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);

		graph.addEdgeBetween(e1);
		graph.addEdgeBetween(e2);
		graph.addEdgeBetween(e3);
		graph.addEdgeBetween(e4);
		graph.addEdgeBetween(e5);
		graph.addEdgeBetween(e6);

		return graph;
	}
}

