package series.serie3;

import java.util.Comparator;

public class TreeUtils {

    public static <E> boolean contains(Node<E> root, E min, E max, Comparator<E> cmp) {

        if (root == null) return false;

        if (cmp.compare(root.value, min) >= 0 && cmp.compare(root.value, max) <= 0)
            return true;

        return (contains(root.left, min, max, cmp) || contains(root.right, min, max, cmp));
    }

    public static Node<Integer> createBSTFromRange(int start, int end) {
        Node<Integer> root = new Node<>();
        createBSTFromRange(root, start, end);

        return root;
    }

    public static void createBSTFromRange(Node<Integer> node, int start, int end) {
        if (start == end) {
            node.value = start;
            return;
        }
        Node<Integer> left;
        Node<Integer> right;
        int middleValue = (start + end) / 2;
        node.value = middleValue;
        if (!(middleValue - 1 < start)) {
            left = new Node<>();
            node.left = left;
            createBSTFromRange(left, start, middleValue - 1);
        }
        if (!(middleValue + 1 > end)) {
            right = new Node<>();
            node.right = right;
            createBSTFromRange(right, middleValue + 1, end);
        }
    }

    public static <E> boolean isBST(Node<E> root, Comparator<E> cmp) {


        if (root == null) return true;  //uma arvore vazia é BST

        if (root.left != null && cmp.compare(root.value, root.left.value) < 0)
            return false;

        if (root.right != null && cmp.compare(root.value, root.right.value) > 0)
            return false;


        return (isBST(root.left, cmp) && isBST(root.right, cmp));

    }
}
