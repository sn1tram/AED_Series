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
		int n = 5;
		/*String s1 = "a", s2 = "b";
		System.out.println(s1.compareTo(s2)); //-1
		System.out.println(s2.compareTo(s1)); //1
		System.out.println(s1.compareTo("")); //1
		//System.out.println(s1.compareTo(null));
		System.out.println(s1.equals(null));*/
		GetFile getFile = new GetFile(n, s1, s2, s3);
		/*String ip = "192.168.1.1";
		String[] a = ip.split("\\.");
		String[] ipv4 = new String[]{"192.168.1.1", "192.168.1.4", "80.68.11.31", "192.168.10.33"};
		//System.out.println(ipv4.length);
		String[][] x = new String[ipv4.length][ipv4.length];
		//array bi-dimensional
		for(int i = 0; i< ipv4.length; ++i)
			x[i] = ipv4[i].split("\\.");*/

		/*int[] a = {5, 8, 6, 7, 50, 69, 10, 22, 1};
		ordena(a, a.length);
		for(int i = 0; i < a.length; ++i)
			System.out.println(a[i]);*/
	}

	public static void ordena(int[] a, int m){
		int n = a.length;

		int vetorAuxiliar[] = new int[m];

		//1ª - (Inicializar com zero)
		for(int i = 0; i < m; i++){
			vetorAuxiliar[i] = 0;
		}

		//2ª - Contagem das ocorrencias
		for(int i = 0; i < n; i++){
			vetorAuxiliar[a[i]]++;
		}

		//3ª - Ordenando os indices do vetor auxiliar
		int sum = 0;
		for(int i = 1; i < m; i++){
			int dum = vetorAuxiliar[i];
			vetorAuxiliar[i] = sum;
			sum += dum;
		}
		int vetorOrdenado[] = new int[n];
		for(int i = 0; i < n; i++){
			vetorOrdenado[vetorAuxiliar[a[i]]] = a[i];
			vetorAuxiliar[a[i]]++;
		}

		//4ª Retornando os valores ordenados para o vetor de entrada
		for (int i = 0; i < n; i++){
			a[i] = vetorOrdenado[i];
		}
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
