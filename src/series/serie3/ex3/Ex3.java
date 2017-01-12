package series.serie3.ex3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex3 {

	public static boolean isEdgeInAnMST(Vertex[] graph, int origId, int destId){
		if(!checkVertexes(graph, origId, destId))
			return false;
		MST(graph, origId, destId);
		Edge e = null;
		for(Vertex v : graph){
			if(v.getId() == origId){
				Edge aux = v.getAdjacentList();
				while(aux != null){
					if(aux.getAdjacent().getId() == destId){
						e = aux;
						if(e.getWeight() == aux.getAdjacent().getKey())
							return true;
					}
					aux = aux.getNextEdge();
				}
			}
		}
		return false;
		
	}
	
	private static void MST(Vertex[] graph, int origId, int destId) {
		Queue q = new Queue(graph.length);
		for(Vertex v : graph){
			if(v.getId() == origId)
				v.setKey(0);
			q.push(v);			
		}
		q.buildMinHeap();
		while(!q.isEmpty()){
			Vertex lower = q.extractMin();
			Edge e = lower.getAdjacentList();
			while(e!= null){
				Vertex v = e.getAdjacent();
				if(q.search(v) != null && e.getWeight() < v.getKey()){
					v.setParent(lower);
					v.setKey(e.getWeight());
				}
				e = e.getNextEdge();
			}
		}
		
	}

	private static boolean checkVertexes(Vertex[] graph, int origId, int destId) {
		for(Vertex v : graph){
			if(v.getId() == origId){
				Edge e = v.getAdjacentList();
				while(e != null){
					if(e.getAdjacent().getId() == destId)
						return true;
					e = e.getNextEdge();
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Vertex[] graph = new Vertex[4];
		for(int i = 0; i < graph.length; ++i)
			graph[i] = new Vertex(i + 1);
		try {
			BufferedReader br = new BufferedReader(new FileReader("graph.txt"));
			String line;
			String[] keys;
			while((line = br.readLine()) != null) {
				keys = line.split(" ");
				int id1 = Integer.parseInt(keys[0]);
				int id2 = Integer.parseInt(keys[1]);
				Double id3 = Double.parseDouble(keys[2]);
				graph[id1 - 1].addEdge(new Edge(graph[id2-1], id3));
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(isEdgeInAnMST(graph, 4, 3));

	}

}
