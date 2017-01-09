package series.serie3;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static series.serie3.TreeUtils.createBSTFromRange;

public class createBSTFromRangeTest {

    @Test
    public void oneElement() {
        Node<Integer> root = new Node<>();
        root.value = 0;
        Node<Integer> testing = createBSTFromRange(0, 0);

        assertTrue(root.equals(testing));


    }


    @Test
    public void twoElements() {
        Node<Integer> root = new Node<>();
        root.value = 0;
        root.right = new Node<>(1);
        Node<Integer> testing = createBSTFromRange(0, 1);

        assertTrue(root.equals(testing));
        assertTrue(root.right.equals(testing.right));

    }

    @Test
    public void pairTree() {

        Node root = new Node();
        root.value = 3;
        root.left = new Node();
        root.left.value = 1;
        root.right = new Node();
        root.right.value = 5;
        root.left.left = new Node();
        root.left.left.value = 0;
        root.left.right = new Node();
        root.left.right.value = 2;
        root.right.left = new Node();
        root.right.left.value = 4;
        root.right.right = new Node();
        root.right.right.value = 6;

        Node<Integer> testing = createBSTFromRange(0, 6);
        assertTrue(root.equals(testing));
        assertTrue(root.left.equals(testing.left));
        assertTrue(root.right.equals(testing.right));
        assertTrue(root.left.left.equals(testing.left.left));
        assertTrue(root.left.right.equals(testing.left.right));
        assertTrue(root.right.left.equals(testing.right.left));
        assertTrue(root.right.right.equals(testing.right.right));

    }

    @Test
    public void oddTree() {

        Node root = new Node();
        root.value = 3;
        root.left = new Node();
        root.left.value = 1;
        root.right = new Node();
        root.right.value = 5;
        root.left.left = new Node();
        root.left.left.value = 0;
        root.left.right = new Node();
        root.left.right.value = 2;
        root.right.left = new Node();
        root.right.left.value = 4;

        Node<Integer> testing = createBSTFromRange(0, 6);
        assertTrue(root.equals(testing));
        assertTrue(root.left.equals(testing.left));
        assertTrue(root.right.equals(testing.right));
        assertTrue(root.left.left.equals(testing.left.left));
        assertTrue(root.left.right.equals(testing.left.right));
        assertTrue(root.right.left.equals(testing.right.left));

    }


}
