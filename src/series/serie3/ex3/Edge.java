package series.serie3.ex3;

public class Edge {

	private Vertex adj;
	private double weight;
	private Edge next;
	
	public Edge(Vertex adj, double weight){
		this.adj = adj;
		this.weight = weight;
	}
	
	public Vertex getAdjacent(){
		return adj;
	}
	
	public double getWeight(){
		return weight;
	}
	
	public Edge getNextEdge(){
		return next;
	}
	
	public void setNextEdge(Edge e){
		next = e;
	}
}
