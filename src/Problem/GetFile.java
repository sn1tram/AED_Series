package Problem;

import java.io.*;
import java.util.Comparator;

/**
 * Created by Pedro on 15/10/2016.
 */
public class GetFile {

	BufferedReader br1, br2, br3;
	String txt1, txt2, txt3;
	int numberOfWords = 0;
	String[] heap;
	boolean b1=true, b2=true, b3=true;

	public GetFile(int n, String s1, String s2, String s3){
		numberOfWords = n;
		heap = new String[n+1];
		fillString(heap);
		try {
			CreateBuffers(s1, s2, s3);
			ReadLine();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void fillString(String[] heap) {
		for(int i = 0; i<heap.length; ++i)
			heap[i] = "";
	}

	public void CreateBuffers(String s1, String s2, String s3) throws Exception {
		br1 = new BufferedReader(new FileReader(s1));
		br2 = new BufferedReader(new FileReader(s2));
		br3 = new BufferedReader(new FileReader(s3));
	}

	public void ReadLine() throws Exception{
		int t1 = 0, t2 = 0, t3 = 0;
		boolean affected;
		txt1 = br1.readLine();
		txt2 = br2.readLine();
		txt3 = br3.readLine();
		while(txt1 != null || txt2 != null || txt3 != null){
			affected = false;
			if(txt1.equals(txt2) && !affected){
				++t1;
				txt1 = br1.readLine();
				affected = true;
			}
			if(txt2.equals(txt3) && !affected){
				++t2;
				txt2 = br2.readLine();
				affected = true;
			}
			if(txt3.equals(txt1) && !affected){
				++t3;
				txt1 = br1.readLine();
				affected = true;
			}
			if((txt1.compareTo(txt2) < 0) && (txt1.compareTo(txt3) < 0) && !affected && b1){
				txt1 = br1.readLine();
				affected = true;
			}
			checkNull();
			if((txt2.compareTo(txt1) < 0) && (txt2.compareTo(txt3) < 0) && !affected && b2){
				txt2 = br2.readLine();
				affected = true;
			}
			checkNull();
			if((txt3.compareTo(txt1) < 0) && (txt3.compareTo(txt2) < 0) && !affected && b3){
				txt3 = br3.readLine();
				affected = true;
			}
			checkNull();
			if(t1>numberOfWords){
				t1=0;
				insertIntoHeap(txt1);
			}
			if(t2>numberOfWords){
				t2=0;
				insertIntoHeap(txt2);
			}
			if(t3>numberOfWords){
				t3=0;
				insertIntoHeap(txt3);
			}
		}
		SaveFile save = new SaveFile();
		save.saveText(heap);
		br1.close();
		br2.close();
		br3.close();
	}

	private void checkNull(){
		if(txt1 == null){
			txt1 = "";
			b1=false;
		}
		if(txt2 == null){
			txt2="";
			b2=false;
		}
		if(txt3 == null) {
			txt3="";
			b3=false;
		}
	}

	public void insertIntoHeap(String str){
		heap[numberOfWords] = str;
		GenericHeap.buildHeap(heap, new Cmp());
	}
}

class Cmp implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {
		if(o1 == o2) return 0;
		if(o1 == null) return 1;
		if(o2 == null) return -1;
		return o1.compareTo(o2);
	}
}
class SaveFile {

	String docName = "output.txt";
	FileOutputStream output;

	public void saveText(String[] s) throws IOException {
		output = new FileOutputStream(docName, true);
		for(int j = 0; j < s.length-1; ++j)
			for(int i = 0; i < s[j].length(); ++i){
				output.write(s[j].charAt(i));
			}
		output.write('\n');
		output.close();
	}

}