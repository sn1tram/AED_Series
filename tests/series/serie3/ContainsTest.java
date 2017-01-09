package series.serie3;

import org.junit.Test;
import java.util.Comparator;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static series.serie3.TreeUtils.contains;


public class ContainsTest {

    public static Comparator<Integer> cmp = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    };

    @Test
    public void emptyTree(){

        Node root = null;
        Integer min = 2, max = 5;

        assertFalse(contains(root, min, max, cmp));

    }

    @Test
    public void validNumber(){

        Node root = new Node();
        root.value = 4;
        root.left = new Node();
        root.left.value = 2;
        root.right = new Node();
        root.right.value = 5;
        root.left.left = new Node();
        root.left.left.value = 1;
        root.left.right = new Node();
        root.left.right.value = 3;

        Integer min = 5, max = 7;

        assertTrue(contains(root,min,max,cmp));
    }

    @Test
    public void notValid(){

        Node root = new Node();
        root.value = 4;
        root.left = new Node();
        root.left.value = 2;
        root.right = new Node();
        root.right.value = 5;
        root.left.left = new Node();
        root.left.left.value = 1;
        root.left.right = new Node();
        root.left.right.value = 3;

        Integer min = 7, max = 10;

        assertFalse(contains(root, min, max, cmp));
    }



}
