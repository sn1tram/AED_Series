package series.serie3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class DNACollectionUtilsTest {

	public static void createWrite(String file, int lenght, int lines){
		PrintWriter pw = null;
		String[] frag = {"A", "C", "T", "G"};
		Random r = new Random();

		try{
			pw = new PrintWriter(file);
			for(int j = 0; j < lines; ++j){
				for(int i = 0; i < lenght; ++i)
					pw.print(frag[r.nextInt(4)]);
				pw.println();
			}

		} catch(FileNotFoundException e){
			System.out.println("File not found!");
		} finally {
			pw.close();
		}
	}
}
