package stanford_course.week_4;

public class Edge {
	private Vertex start;
	private Vertex end;

	public Edge(Vertex start, Vertex end) {
		this.start = start;
		this.end = end;
	}

	public Vertex getFirstVertex() {
		return start;
	}

	public Vertex getSecondVertex() {
		return end;
	}

	public Edge flipEdge() {
		return new Edge(end, start);
	}

	public Vertex other(Vertex v) {
		if (start.equals(v)) return end;
		else if (end.equals(v)) return start;

		throw new IllegalArgumentException("Wrong vertex is given");
	}


	public boolean connectedTo(Vertex vertexOld) {
		return start.equals(vertexOld) || end.equals(vertexOld);
	}

	@Override
	public String toString() {
		return "Edge{" +
				"start=" + start.getName() +
				", end=" + end.getName() +
				'}';
	}
}
