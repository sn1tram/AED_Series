package series.serie3.ex3;

public class Vertex {

	private int id;
	private Edge adjacentList;
	private double key;
	private Vertex parent;
	
	public Vertex(int id) {
		this.id = id;
		key = 100000.0;
		parent = null;
	}
	
	public int getId() {
		return id;
	}
	
	public Edge getAdjacentList() {
		return adjacentList;
	}
	
	public double getKey() {
		return key;
	}
	
	public Vertex getParent() {
		return parent;
	}

	public void setKey(double k) {
		key = k;
	}
	
	public void setParent(Vertex p) {
		parent = p;
	}
	
	public void addEdge(Edge e) {
		e.setNextEdge(adjacentList);
		adjacentList = e;
	}

}
