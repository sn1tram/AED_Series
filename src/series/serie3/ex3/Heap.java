package series.serie3.ex3;

import java.util.Comparator;

public class Heap<E> {

public Comparator<E> cmp;
	
	public Heap(Comparator<E> c) {
		cmp = c;
	}
	
	public void heapSort(E[] arr, int len){
		buildHeap(arr, len);
		for(int i = len - 1; i > 0; --i){
			exchange(arr, 0, i);
			minHeapify(arr, 0, i);
		}
	}
	
	public void minHeapify(E[] arr, int idx, int len) {
		int l, r, largest;
		l = (idx << 1) + 1; 
		r = (idx << 1) + 2;
		largest = idx;
		if(l < len && this.cmp.compare(arr[l], arr[idx]) < 0)
			largest = l;
		if ( r < len && this.cmp.compare(arr[r], arr[largest]) < 0) 
			largest = r;
		if ( largest == idx )
			return;
		exchange(arr, idx, largest);		  
		minHeapify(arr, largest, len);
	}
	
	public void buildHeap(E[] arr, int n){
		int p = (n >> 1) - 1;
		for(; p >= 0; --p)
			minHeapify(arr, p, n);
	}
	
	public void exchange(E[] arr, int idx, int largest) {
		E temp = arr[idx];
		arr[idx] = arr[largest];
		arr[largest] = temp;
	}
}
