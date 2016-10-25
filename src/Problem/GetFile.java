package Problem;

import java.io.*;
import java.util.Comparator;

/**
 * Created by Pedro on 15/10/2016.
 */
public class GetFile {

	BufferedReader br1, br2, br3;
	String txt1, txt2, txt3;
	int numberOfWords = 0, aux=0;
	Word[] saveWords;
	String[] heap;
	boolean b1=true, b2=true, b3=true;

	public GetFile(int n, String s1, String s2, String s3){
		numberOfWords = n;
		saveWords = new Word[numberOfWords];
		initializeHeap(saveWords);
		try {
			CreateBuffers(s1, s2, s3);
			ReadLine();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void initializeHeap(Word[] saveWords) {
		for(int i = 0; i < saveWords.length; i++)
			saveWords[i] = new Word("", 0);
	}

	public void CreateBuffers(String s1, String s2, String s3) throws Exception {
		br1 = new BufferedReader(new FileReader(s1));
		br2 = new BufferedReader(new FileReader(s2));
		br3 = new BufferedReader(new FileReader(s3));
	}

	public void ReadLine() throws Exception{
		int count = 0;
		boolean read, change=false;
		txt1 = br1.readLine();
		txt2 = br2.readLine();
		txt3 = br3.readLine();
		while(txt1 != null || txt2 != null || txt3 != null){
			String[] x = { txt1, txt2, txt3 };
			read = true;
			GenericHeap.buildHeap(x, new Cmp());
			String word = x[0];
			//if(word == null) word = x[0];
			if(x[0].equals(txt1) && read){
				++count;
				txt1 = br1.readLine();
				read = false;
				change = txt1 != x[0] && txt2 != x[0] && txt3 != x[0];
				//change = txt1 != x[0];
			}
			if(x[0].equals(txt2) && read){
				++count;
				txt2 = br2.readLine();
				read = false;
				change = txt1 != x[0] && txt2 != x[0] && txt3 != x[0];
				//change = txt2 != x[0];
			}
			if(x[0].equals(txt3) && read){
				++count;
				txt3 = br3.readLine();
				read = false;
				change = txt1 != x[0] && txt2 != x[0] && txt3 != x[0];
				//change = txt3 != x[0];
			}
			if (aux == 209922)
				System.out.print("");
			if(change && count>numberOfWords) {
				System.out.println(++aux);
				Word line = new Word(word, count);
				if(line.getnOcorr() > saveWords[0].getnOcorr() || saveWords[0] == null){
					saveWords[0] = line;
					GenericHeap.buildHeap(saveWords, new CmpObj());
				}
				count = 0;
			}

		}
		Save sv = new Save(saveWords);
		br1.close();
		br2.close();
		br3.close();
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

class CmpObj implements Comparator<Word>{
	@Override
	public int compare(Word o1, Word o2) {
		if(o1 == o2) return 0;
		if(o1 == null) return 1;
		if(o2 == null) return -1;
		return o1.getWord().compareTo(o2.getWord());
	}
}

class Save {

	String docName = "output.txt";
	File fout;
	FileOutputStream out;
	BufferedWriter bw;


	public Save(Word[] words){
		try{
			fout = new File(docName);
			out = new FileOutputStream(fout);
			bw = new BufferedWriter(new OutputStreamWriter(out));

			for(int i = 0; i < words.length; i++) {
				bw.write(words[i].getWord());
				bw.newLine();
			}
			bw.close();
		}catch (Exception ex){
			ex.getMessage();
		}

	}
}

class Word {
	private String word;
	private int nOcorr=0;

	public Word(String word, int Ocorr){
		this.word = word;
		nOcorr = Ocorr;
	}

	public String getWord(){ return word; }

	public int getnOcorr(){ return nOcorr; }
}