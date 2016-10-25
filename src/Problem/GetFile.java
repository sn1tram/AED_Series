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
	Word[] saveWords;
	String[] heap;
	boolean b1=true, b2=true, b3=true;

	public GetFile(int n, String s1, String s2, String s3){
		numberOfWords = n;
		saveWords = new Word[numberOfWords];
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
		int count = 0, heapSize, aux=0;
		boolean read = false, change=false;
		txt1 = br1.readLine();
		txt2 = br2.readLine();
		txt3 = br3.readLine();
		while(txt1 != null || txt2 != null || txt3 != null){
			String[] x = { txt1, txt2, txt3 };
			read = true;
			//String word = x[0];
			//GenericHeap.buildHeap(x, x.length, new Cmp());
			GenericHeap.buildHeap(x, new Cmp());
			String word = x[0];
			//if(word == null) word = x[0];
			if(x[0].equals(txt1) && read){
				++count;
				txt1 = br1.readLine();
				read = false;
				change = txt1 != x[0];
			}
			if(x[0].equals(txt2) && read){
				++count;
				txt2 = br2.readLine();
				read = false;
				change = txt2 != x[0];
			}
			if(x[0].equals(txt3) && read){
				++count;
				txt3 = br3.readLine();
				read = false;
				change = txt3 != x[0];
			}
			if(change && count>numberOfWords) {
				Word line = new Word(word, count);
				//GenericHeap.buildHeap(line.getnOcorr(), new Cmp());
				System.out.println("I have to Save " + word);
				count = 0;
			}

		}
		br1.close();
		br2.close();
		br3.close();
	}

	//private void SaveWord()
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

class Word {
	private String Word;
	private int nOcorr=0;

	public Word(String word, int Ocorr){
		this.Word = word;
		nOcorr = Ocorr;
	}

	public String getWord(){ return Word; }

	public int getnOcorr(){ return nOcorr; }
}