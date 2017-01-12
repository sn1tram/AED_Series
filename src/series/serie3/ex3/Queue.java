package series.serie3.ex3;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class Queue {

	private Vertex[] arr;
	private int count;
	private Heap<Vertex> heap;
	
	public Queue(int cap){
		arr = new Vertex[cap];
		Comparator<Vertex> cmp = (v1, v2) -> compareDoubles(v2.getKey(), v1.getKey());
		count = 0;
		heap = new Heap<Vertex>(cmp);
	}
	
	private int compareDoubles(double d1, double d2) {
		double result = d1 - d2;
		if(result < 0)
			return -1;
		return result > 0 ? 1 : 0;
	}
	
	public boolean isEmpty(){
		return count == 0;
	}
	
	public Vertex push(Vertex v){
		if(count == arr.length)
			return null;
		arr[count++] = v;
		return v;
	}
	
	public Vertex pop(){
		if(isEmpty())
			throw new NoSuchElementException();
		Vertex v = arr[--count];
		arr[count] = null;
		return v;
	}
	
	public Vertex search(Vertex v) {
		Vertex ret;
		for(int i = 0; i < count; ++i) {
			ret = arr[i];
			if(ret.getId() == v.getId())
				return ret;
		}
		return null;
	}
	
	public void buildMinHeap(){
		heap.heapSort(arr, count);
	}
	
	public Vertex extractMin(){
		Vertex v = arr[0];
		arr[0] = pop();
		heap.minHeapify(arr, 0, count);
		return v;
	}
	
}
