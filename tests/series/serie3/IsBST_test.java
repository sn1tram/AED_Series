package series.serie3;

import org.junit.Test;
import series.serie3.*;
import java.util.Comparator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static series.serie3.TreeUtils.isBST;


public class IsBST_test {

    public static Comparator<Integer> cmp = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    };

    @Test
     public void emptyTree(){

        Node root = null;

        assertTrue(isBST(root,cmp));

    }

    @Test
    public void isValidTree(){

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

        assertTrue(isBST(root,cmp));

    }

    @Test
    public void isNotValidTree(){

        Node root = new Node();
        root.value = 4;
        root.left = new Node();
        root.left.value = 6;
        root.right = new Node();
        root.right.value = 5;

        assertFalse(isBST(root, cmp));

    }




}
