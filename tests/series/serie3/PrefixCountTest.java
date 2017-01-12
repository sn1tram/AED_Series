package series.serie3;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class PrefixCountTest {

	static DNACollection dna;
	static String[] fragments = {"CTCAAT", "TTCTTGG","GGT","TTA","ACA","CTT","GTC",
		"GCA","CGC","CAC","TAA","ACT","AAT"};
	
	@BeforeClass
	public static void before(){
		dna = new DNACollection();
		for(int i = 0; i < fragments.length; ++i)
			dna.add(fragments[i]);
	}
	@Test
	public void prefixCount_one_letter_test(){
		assertEquals(4,dna.prefixCount("C"));
		assertEquals(3,dna.prefixCount("T"));
		assertEquals(3,dna.prefixCount("A"));
		assertEquals(3,dna.prefixCount("G"));
	}
	
	@Test
	public void prefixCount_count_zero_test(){
		assertEquals(0,dna.prefixCount("AAA"));
		assertEquals(0,dna.prefixCount("ATA"));
		assertEquals(0,dna.prefixCount("TGA"));
		assertEquals(0,dna.prefixCount("CC"));
	}
	
	@Test
	public void prefixCount_several_letters_test(){
		assertEquals(1,dna.prefixCount("AAT"));
		assertEquals(2,dna.prefixCount("CT"));
		assertEquals(4,dna.prefixCount("C"));
		assertEquals(1,dna.prefixCount("GT"));
	}
}
