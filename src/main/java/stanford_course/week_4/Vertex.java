package stanford_course.week_4;

//TODO: should be immutable; also should have hash code and equals implemented;
public class Vertex {
	private String name;

	public Vertex() {
	}

	public Vertex(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Vertex{" +
				"name='" + name + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Vertex vertex = (Vertex) o;

		return name.equals(vertex.name);
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
