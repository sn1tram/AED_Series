import Problem.GenericHeap;
import Problem.GetFile;

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
		int n = 10;
		/*String s1 = "a", s2 = "b";
		System.out.println(s1.compareTo(s2)); //-1
		System.out.println(s2.compareTo(s1)); //1
		System.out.println(s1.compareTo("")); //1
		//System.out.println(s1.compareTo(null));
		System.out.println(s1.equals(null));*/
		//GetFile getFile = new GetFile(n, s1, s2, s3);

		Integer[] maxHeap = {18, 15, 16, 10, 9, 12, 14, 3, 4, 5, 2 };
		int [] array = {1, 2, 3, 4, 7, 8, 9, 10, 14, 16};

		buildMaxHeap(array, array.length);
		show(array);
	}

	public static void changeValueInMaxHeap(int[] v, int count, int ix, int newValue){

	}

	public static void show(int[] t) {
		for (int i = 0; i < t.length; i++)
			System.out.print(t[i] + " ");
		System.out.println();
	}

	public static void buildMaxHeap(int[] h, int n) {
		for (int i = n / 2 - 1; i >= 0; i--)
			maxHeapify(h, i, n);
	}

	/*public static int parent(int i) { return (i - 1) / 2; } */

	public static int left(int i) { return 2 * i + 1; }

	public static int right(int i) { return 2 * i + 2; }

	public static void maxHeapify(int[] h, int i, int n) {
		int l = left(i);
		int r = right(i);
		int largest;
		if (l < n && h[l] > h[i])
			largest = l;
		else largest = i;
		if (r < n && h[r] > h[largest])
			largest = r;
		if (largest != i) {
			exchange(h, i, largest);
			maxHeapify(h, largest, n);
		}
	}

	private static void exchange(int[] h, int i, int j) {
		int aux = h[i];
		h[i] = h[j];
		h[j] = aux;
	}
	/*public static void sortIPv4Addresses(String[] v, int l, int r){
		int idx, i = l+1;
		int a1, a2;
		String[] aux1 = new String[(r-l)+1];
		String[] aux2 = new String[(r-l)+1];
		while(l < r){
			idx = 0;
			aux1 = v[l].split("\\.");
			aux2 = v[l+1].split("\\.");
			a1 = Integer.parseInt(aux1[0]);
			a2 = Integer.parseInt(aux2[0]);
		}
	}*/
}
