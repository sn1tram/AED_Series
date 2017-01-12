package series.serie3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class AddTest {

	static DNACollection dna;
	static final String SEVERAL_ELEMENTS = "SeveralElements.txt";
	static final String ONE_ELEMENT = "OneElement.txt";
	static final String EMPTY = "Empty.txt";
	static final char FIRST_CHAR = 97;
	
	@Test
	public void DNACollection_several_elements_add_test(){
		dna = new DNACollection();
		DNACollectionUtilsTest.createWrite(SEVERAL_ELEMENTS, 100, 20);
		assertTrue(readAndAddedToRoot(SEVERAL_ELEMENTS, dna));
	}
	
	@Test
	public void DNACollection_one_element_add_test(){
		dna = new DNACollection();
		DNACollectionUtilsTest.createWrite(ONE_ELEMENT, 100, 1);
		assertTrue(readAndAddedToRoot(ONE_ELEMENT, dna));
	}
	
	@Test
	public void DNACollection_zero_elements_add_test(){
		dna = new DNACollection();
		DNACollectionUtilsTest.createWrite(EMPTY, 0, 0);
		assertFalse(readAndAddedToRoot(EMPTY, dna));
		TNode root = dna.getRoot();
		for(int i = 0; i < root.getChilds().length; ++i)
			assertEquals(null, root.getChilds()[i]);
	}
	
	private static boolean readAndAddedToRoot(String file, DNACollection dna) {
		BufferedReader br;
		String line;
		try{
			br = new BufferedReader(new FileReader(file));
			while((line = br.readLine()) != null){
				line = line.toLowerCase();
				dna.add(line);
				return searchFrag(line, dna.getRoot());
			}	
			br.close();
		} catch(IOException e){
			System.out.println(e.getMessage());
		}
		return false;
	}

	private static boolean searchFrag(String line, TNode root) {
		TNode[] child = root.getChilds();
		String same = "";
		for(int i = 0, idx = 0; i < line.length(); ++i){
			idx = converterIdx(line.charAt(i) - FIRST_CHAR);
			same += child[idx].getValue();
			child = child[idx].getChilds();
		}
		return line.equals(same);
	}
	
	private static int converterIdx(int idx){
		return idx == 2 ? 1 : idx == 19 ? 2 : idx == 6 ? 3 : 0;
	}
	
}
