package series.serie3;


import org.junit.Test;

public class DNACollectionTest {

    @Test
    public void simpleTest(){
        DNACollection newCollection = new DNACollection();
        newCollection.add("AA");
        newCollection.add("AB");
        System.out.println("done");
    }

}
