import Problem.GetFile;

import java.awt.print.Printable;
import java.text.ParseException;

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


		GetFile getFile = new GetFile(n, s1, s2, s3);
		/*String[] ipv4 = new String[]{"192.168.1.6", "123.123.123.122"};
		String Str = new String("Welcome-to-Tutorialspoint.com");
		System.out.println("Return Value :" );
		String[] x = ipv4[0].split("\\.");

		int aux = Integer.parseInt(x[0]);
		System.out.println(aux);

		/*for (String retval: ipv4[0].split("\\.")) {
			int x = Integer.parseInt(retval);
			System.out.println(x);
		}*/
	}


	public static void sortIPv4Addresses(String[] v, int l, int r){
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
	}
}
