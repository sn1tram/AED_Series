import Problem.GenericHeap;
import Problem.GetFile;
import com.sun.org.apache.bcel.internal.generic.NEW;
import series.serie2.Node;

import java.awt.print.Printable;
import java.text.ParseException;
import java.util.Comparator;

/**
 * Created by Pedro on 15/10/2016.
 */
public class Main {

	static String s1 = "f1.txt";
	static String s2 = "f2.txt";
	static String s3 = "f3.txt";

	public static void main(String[] args){
		/*******************************************/
		/**              Serie_1                  **/
		/********************************************/
		//int n = 25;
		//GetFile getFile = new GetFile(n, s1, s2, s3);
		/*******************************************/
		/**              Serie_2                  **/
		/********************************************/
		/*********************************************/
		/**               TESTE_AED                  */
		/*********************************************/
		//int[] array = new int[]{25, 5, 7, 6, 3, 8, 12, 63, 41, 77};
		//Heap.buildMinHeap(array, array.length);
		//deleteSmallerThan(array, array.length, 9);
		/*Node<Integer> list = new Node<Integer>();
		Node<Integer> str = list;

		for(int i = 0; i < 8; i++){
			list.value = i;
			list.next = new Node<Integer>();
			list = list.next;
		}
		Node<Integer> aux = reverseKFromKElements(str, 3);
		while(aux.next != null){
			System.out.println(aux.value);
			aux = aux.next;
		}*/
		int[] a1 = {3, 27, 45, 68, 70, 81, 99};
		int[] b1 = {9, 16, 25, 35, 70, 84};

		System.out.println(findMinDifference(a1, b1));
	}

	public static <E> Node<E> reverseKFromKElements(Node<E> list, int k){
		Node<E> curr = list, end = list;
		int aux;
		E[] auxiliar = (E[]) new Object[k];//[k];
		while (list.next != null){
			aux = 0;
			while(aux < k && curr.next != null){
				auxiliar[aux++] = curr.value;
				curr = curr.next;
			}
			--aux;
			while(aux >= 0 && list != null){
				list.value = auxiliar[aux--];
				list = list.next;
			}
		}
		return end;
	}

	public static int findMinDifference(int[]elem1, int[]elem2){
		int idx1 = 0, idx2 = 0, idx = Integer.MAX_VALUE;
		while(idx1 != elem1.length &&  idx2 != elem2.length){
			int sub = elem1[idx1] - elem2[idx2];
			if (sub >= 0){
				if (idx > sub)
					idx = sub;
				++idx2;
			} else {
				if (idx > (-1)*sub)
					idx = (-1)*sub;
				++idx1;
			}
		}
		return idx;
	}

	public static <E> Node<Node<E>> distribute(Node<E> list, int k){
		Node<Node<E>> retlist = new Node<>();
		retlist.next = new Node<>();
		retlist.previous = retlist.next = retlist;
		Node<Node<E>> idx = retlist;
		Node<E> next = list.next;
		while ( next != null){
			if (retlist == null) {
				retlist.next = new Node<>();
			}
		}
		return new Node<>();
	}
	/*public static int deleteSmallerThan(int[] minHeap, int sizeHeap, int k){
		int count = 0, size = sizeHeap;
		while(size != 0){
			if (minHeap[0] < k){
				++count;
				--size;
				minHeap[0] = minHeap[size-1];
				Heap.minHeapify(minHeap, 0, size);
			}else break;
		}
		return sizeHeap-count;
	}*/
}
