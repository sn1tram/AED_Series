package Problem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;

/**
 * Created by Pedro on 15/10/2016.
 */
public class GetFile {

	BufferedReader br1, br2, br3;
	String txt1, txt2, txt3;
	int numberOfWords = 0;

	public GetFile(int n, String s1, String s2, String s3){
		numberOfWords = n;
		try {
			CreateBuffers(s1, s2, s3);
			ReadLine();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void CreateBuffers(String s1, String s2, String s3) throws Exception {
		br1 = new BufferedReader(new FileReader(s1));
		br2 = new BufferedReader(new FileReader(s2));
		br3 = new BufferedReader(new FileReader(s3));
	}

	public void ReadLine() throws Exception{
		int t1 = 0, t2 = 0, t3 = 0, count = 0;
		txt1 = br1.readLine();
		txt2 = br2.readLine();
		txt3 = br3.readLine();
		while(txt1 != null || txt2 != null || txt3 != null){
			if(txt1.equals(txt2)){
				++t1;
				txt1 = br1.readLine();
			}
			if(txt2.equals(txt3)){
				++t2;
				txt2 = br2.readLine();
			}
			if(txt3.equals(txt1)){
				++t3;
				txt1 = br1.readLine();
			} else {
				if((txt1.compareTo(txt2) < 0) && (txt1.compareTo(txt3) < 0)) txt1 = br1.readLine();
				if((txt2.compareTo(txt1) < 0) && (txt2.compareTo(txt3) < 0)) txt2 = br2.readLine();
				if((txt3.compareTo(txt1) < 0) && (txt3.compareTo(txt2) < 0)) txt3 = br3.readLine();
				/*if((txt1.compareTo(txt2) > 0) && (txt1.compareTo(txt3) > 0)) txt1 = br1.readLine();
				if((txt2.compareTo(txt1) > 0) && (txt2.compareTo(txt3) > 0)) txt2 = br2.readLine();
				if((txt3.compareTo(txt1) > 0) && (txt3.compareTo(txt2) > 0)) txt3 = br3.readLine();*/
			}
		}
	}

	/*private class Compare implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			if(o1 == o2) return 0;
			if(o1 == null) return 1;
			if(o2 == null) return -1;
			return o1.compareTo(o2);
		}
	}*/
}
